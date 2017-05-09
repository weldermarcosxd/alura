import { Component, OnInit } from '@angular/core';
import { NavController, LoadingController, AlertController } from 'ionic-angular';
import { Http } from '@angular/http';
import { DetailPage } from '../detail/detail';
import { Carro } from '../../models/carro/Carro';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage implements OnInit {

  public carros: Array<Carro>;

  constructor(public navCtrl: NavController,
    public http: Http,
    public loadingController: LoadingController,
    public alertController: AlertController) { }

  ngOnInit() {
    let loading = this.loadingController.create({
      content: "Carregando Carros..."
    });

    loading.present();

    this.http.get("https://aluracar.herokuapp.com")
      .map(res => res.json())
      .toPromise()
      .then(carros => {
        this.carros = carros;
        loading.dismiss();
      })
      .catch(err => {
        console.log(err);
        loading.dismiss();
        this.alertController.create({
          title: "Falha na conexão",
          buttons: [{ text: "OK" }],
          subTitle: "Verifique sua conexão ou tente novamente mais tarde"
        }).present();
      });
  }

  selecionar(carro){
    this.navCtrl.push(DetailPage, {carroSelecionado: carro});
  }

}
