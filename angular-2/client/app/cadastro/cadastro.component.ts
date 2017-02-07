import { Component } from '@angular/core';
import { Http, Headers } from '@angular/http';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { FotoComponent } from '../foto/foto.component';

@Component({
    moduleId: module.id,
    selector: 'cadastro',
    templateUrl: './cadastro.component.html',
})
export class CadastroComponent {

    foto: FotoComponent = new FotoComponent();
    http: Http;
    meuForm: FormGroup;

    constructor(http: Http, formBuilder: FormBuilder) {
        this.http = http;

        this.meuForm = formBuilder.group({
            titulo: ['', Validators.compose(
                [Validators.required, Validators.minLength(4)]
            )],
            url: ['', Validators.required],
            descricao: ['']
        });
    }

    cadastrar(event) {
        event.preventDefault();

        let header = new Headers();
        header.append('Content-type', 'application/json');
        let url: string = "v1/fotos";

        this.http.post(url, JSON.stringify(this.foto), { headers: header })
            .subscribe(() => {
                this.foto = new FotoComponent();
                console.log('Foto Salva com sucesso!');
            }, err => {
                console.log('ERROR: ' + err);
            });
        console.log(this.foto);
    }
}
