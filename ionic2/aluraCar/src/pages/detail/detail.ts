import { Component, OnInit } from '@angular/core';
import { NavParams, NavController } from 'ionic-angular';
import { Carro } from '../../models/carro/Carro';
import { Acessorio } from '../../models/carro/Acessorio';
import { CadastroPage } from '../cadastro/cadastro';

@Component({
  templateUrl: "detail.html",
  selector: "page-detail"
})
export class DetailPage implements OnInit {

  public carro: Carro;
  public acessorios: Array<Acessorio>;
  private _precoTotal: number;

  constructor(public navParams: NavParams, public navController: NavController) {}

  ngOnInit() {
    this.carro = this.navParams.get('carroSelecionado');
    this.acessorios = [
      new Acessorio('Freio ABS',800),
      new Acessorio('Ar-condicionado',1000),
      new Acessorio('MP3 Player',500)
    ];
    this._precoTotal = this.carro.preco;
  }

  atualizaPreco(marcado: Boolean, acessorio){
    marcado ? this._precoTotal+=acessorio.preco:
              this._precoTotal-=acessorio.preco;
  }

  get precoTotal(){
    return this._precoTotal;
  }

  avancar(){
    this.navController.push(CadastroPage, {
      carro: this.carro,
      precoTotal: this.precoTotal
    });
  }
}
