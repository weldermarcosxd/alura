import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import { LoginProvider } from '../../providers/login-provider';
import { User } from '../../models/user/user';

@Component({
  selector: 'page-perfil',
  templateUrl: 'perfil.html'
})
export class PerfilPage {

  public url : string = `http://i.pravatar.cc/150?u=${this.loginProvider.getCurrentUser().email}`;

  constructor(
    public navCtrl: NavController,
    public navParams: NavParams,
    public loginProvider: LoginProvider) {}

  get currentUser(): User{
    return this.loginProvider.getCurrentUser();
  }
}
