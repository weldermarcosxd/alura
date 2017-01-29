import { Component } from '@angular/core';
import {Http} from '@angular/http';

@Component({
  moduleId: module.id,
  selector: 'listagem',
  templateUrl: './listagem.component.html',
})
export class ListagemComponent {

  fotos: Object[] = [];

  constructor(http: Http){
    http.get('v1/fotos').map(res => {
      return res.json();
    }).subscribe(fotos => {
      this.fotos = fotos;
    }, err => {
      console.log(err);
    });
  }

}
