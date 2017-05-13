import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { User } from '../models/user/user';
import 'rxjs/add/operator/map';

const KEY = 'avatarUrl';

@Injectable()
export class LoginProvider {

  private currentUser: User;

  constructor(public http: Http) {}

  authenticate(email: string, senha: string): Promise<User> {
    let url = `https://aluracar.herokuapp.com/login?email=${email}&senha=${senha}`;
    return this.http.get(url)
    .map(res => res.json().usuario)
    .toPromise()
    .then(data => {
      let usuario = new User(data.nome, data.dataNascimento, data.email, data.telefone);
      this.currentUser = usuario;
      return usuario;
    })
    .catch(err => {
      throw new Error(err)
    });
  }

  getCurrentUser(): User{
    return this.currentUser;
  }

  setAvatar(url){
    localStorage.setItem(KEY, url);
  }

  getAvatar(){
    return localStorage.getItem(KEY);
  }
}
