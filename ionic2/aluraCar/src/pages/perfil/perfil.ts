import { Component, OnInit } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import { LoginProvider } from '../../providers/login-provider';
import { User } from '../../models/user/user';
import { Camera } from '@ionic-native/camera';

@Component({
  selector: 'page-perfil',
  templateUrl: 'perfil.html'
})
export class PerfilPage implements OnInit {

  public url: string;

  constructor(
    public navCtrl: NavController,
    public navParams: NavParams,
    public loginProvider: LoginProvider,
    public camera: Camera) { }

  ngOnInit() {
    this.url = this.loginProvider.getAvatar();
    if(!this.url){
      this.url = `http://i.pravatar.cc/150?u=${this.loginProvider.getCurrentUser().email}`;
    }
  }

  get currentUser(): User {
    return this.loginProvider.getCurrentUser();
  }

  avatar() {
    this.camera.getPicture({
      destinationType: this.camera.DestinationType.FILE_URI,
      saveToPhotoAlbum: true,
      correctOrientation: true
    })
    .then(url => {
      this.loginProvider.setAvatar(url);
      this.url = url;
    })
    .catch(err => {
      throw new Error("Erro ao acessar a camera: " + err.message);
    });
  }
}
