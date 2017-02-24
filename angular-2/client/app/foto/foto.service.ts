import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs';
import { FotoComponent } from './foto.component';
import { CadastroMessage } from '../cadastro/cadastro.message';

@Injectable()
export class FotoService {

    http: Http;
    headers: Headers;
    url: string = 'v1/fotos';

    constructor(http: Http) {
        this.http = http;
        this.headers = new Headers();
        this.headers.append('Content-type', 'application/json');
    }

    findList(): Observable<FotoComponent[]> {
        return this.http.get(this.url).map(res => res.json());
    }

    findById(id: string): Observable<FotoComponent> {
        return this.http.get(this.url + "/" + id).map(res => res.json());
    }

    persist(foto: FotoComponent): Observable<CadastroMessage> {
        if(foto._id){
          return this.http.put(this.url + "/" + foto._id, JSON.stringify(foto), { headers: this.headers })
            .map(() => new CadastroMessage("Foto alterada com sucesso", false));
        }else{
          return this.http.post(this.url, JSON.stringify(foto), { headers: this.headers }).
            map(() => new CadastroMessage("Foto inserida com sucesso", true));;
        }
    }

    update(foto: FotoComponent): Observable<Response> {
        return this.http.put(this.url + "/" + foto._id, JSON.stringify(foto), { headers: this.headers });
    }

    delete(foto: FotoComponent): Observable<Response> {
        return this.http.delete(this.url + "/" + foto._id);
    }
}
