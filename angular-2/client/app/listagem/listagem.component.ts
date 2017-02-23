import { Component } from '@angular/core';
import { Http } from '@angular/http';
import { FotoComponent } from '../foto/foto.component';
import { FotoService } from '../foto/foto.service'

@Component({
    moduleId: module.id,
    selector: 'listagem',
    templateUrl: './listagem.component.html',
})
export class ListagemComponent {

    fotos: FotoComponent[] = [];
    fotoService: FotoService;
    mensagem: string = "";

    constructor(service: FotoService) {
        this.fotoService = service;
        service.findList().subscribe(
          fotos => this.fotos = fotos,
          err => console.log(err)
        );
    }

    remove(foto: FotoComponent): void {
      this.fotoService.delete(foto).subscribe(
        () => {
          let novasFotos = this.fotos.slice(0);
          let index = novasFotos.indexOf(foto);
          novasFotos.splice(index, 1);
          this.fotos = novasFotos;
          this.mensagem = 'Foto removida com sucesso';
        },
        err => {
          console.log(" Falha na remoção da foto.")
          this.mensagem = 'Não foi possível remover a foto';
        }
      );
    }
}
