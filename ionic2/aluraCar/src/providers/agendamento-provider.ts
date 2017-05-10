import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Agendamento } from '../models/agendamento/Agendamento';

import 'rxjs/add/operator/map';

@Injectable()
export class AgendamentoProvider {

  constructor(public http: Http) {}

  agenda(agendamento: Agendamento){
    let url = `http://aluracar.herokuapp.com/salvarpedido?carro=${agendamento.carro.nome}&nome=${agendamento.nome}&preco=${agendamento.preco}&endereco=${agendamento.endereco}&email=${agendamento.email}&dataAgendamento=${agendamento.data}`;
    return this.http.get(url)
    .toPromise();
  }

}
