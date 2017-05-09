import { Component, OnInit } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import { Carro } from '../../models/carro/Carro';

@Component({
  templateUrl: 'cadastro.html'
})
export class CadastroPage implements OnInit{

  public carro: Carro;
  public precoTotal: number;

  public nome: string;
  public endereco: string;
  public email: string;
  public data: string = new Date().toISOString();

  constructor(public navCtrl: NavController, public navParams: NavParams) {}

  ngOnInit(){
    this.carro = this.navParams.get('carro');
    this.precoTotal = this.navParams.get('precoTotal');
  }

  finalizar(){
    console.log("Gravado");
  }

}
