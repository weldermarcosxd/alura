import { Component } from '@angular/core';
import { Http, Headers } from '@angular/http';
import { ActivatedRoute, Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { FotoComponent } from '../foto/foto.component';
import { FotoService } from '../foto/foto.service';

@Component({
    moduleId: module.id,
    selector: 'cadastro',
    templateUrl: './cadastro.component.html',
})
export class CadastroComponent {

    foto: FotoComponent = new FotoComponent();
    service: FotoService;
    meuForm: FormGroup;
    activatedRoute: ActivatedRoute;
    router: Router;
    mensagem: string = '';


    constructor(service: FotoService, formBuilder: FormBuilder, activatedRoute: ActivatedRoute, router: Router) {
        this.service = service;
        this.activatedRoute = activatedRoute;
        this.router = router;

        this.activatedRoute.params.subscribe(params => {
            let id = params['id'];

            if (id) {
                this.service.findById(id).subscribe(
                    foto => this.foto = foto,
                    err => console.log("Erro na busca do registro: " + err)
                );
            }

        }, err => {
            console.log('Erro na busca do registro: ' + err);
        });

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

        this.service.persist(this.foto)
            .subscribe((res) => {
                this.mensagem = res.message;
                this.foto = new FotoComponent();
                if(!res.include) this.router.navigate(['']);
            }, err => {
                console.log('ERROR: ' + err);
            });
    }
}
