import { Component } from '@angular/core';
import { NavController, NavParams, AlertController } from 'ionic-angular';
import { HomePage } from '../home/home';
import { LoginProvider } from '../../providers/login-provider';

@Component({
  selector: 'page-login',
  templateUrl: 'login.html'
})
export class LoginPage {

  public email: string = "joao@alura.com.br";
  public password: string = "alura123";

  constructor(
    public navCtrl: NavController,
    public navParams: NavParams,
    public loginProvider: LoginProvider,
    public alertController: AlertController
  ) {}

  authenticate(){
    this.loginProvider.authenticate(this.email, this.password)
    .then(user => this.navCtrl.setRoot(HomePage))
    .catch(err => {
      this.alertController.create({
        title: "Falha na autenticação",
        buttons: [{text: "OK"}]
      }).present()
    });
  }

}
