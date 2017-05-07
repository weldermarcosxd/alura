import { Component, OnInit } from '@angular/core';
import { NavParams } from 'ionic-angular';

@Component({
  templateUrl:"detail.html",
  selector: "page-detail"
})
export class DetailPage implements OnInit{

  private carro;

  constructor(public navParams: NavParams){

  }

  ngOnInit(){
    this.carro = this.navParams.get('carroSelecionado');
  }

}
