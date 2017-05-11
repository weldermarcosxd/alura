import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Agendamento } from '../models/agendamento/Agendamento';
import { AgendamentoDAO } from '../persistence/agendamento/agendamento-dao';
import 'rxjs/add/operator/map';

@Injectable()
export class AgendamentoProvider {

  constructor(public http: Http, public agendamentoDao: AgendamentoDAO) {}

  agenda(agendamento: Agendamento): Promise<boolean>{
    return this.agendamentoDao.getDuplicity(agendamento)
      .then(duplicado => {
        if(!duplicado){
          let url = `http://aluracar.herokuapp.com/salvarpedido?carro=${agendamento.carro.nome}&nome=${agendamento.nome}&preco=${agendamento.preco}&endereco=${agendamento.endereco}&email=${agendamento.email}&dataAgendamento=${agendamento.data}`;
          return this.http.get(url)
          .toPromise()
          .then(() => agendamento.confirmado = true, err => console.log(err))
          .then(() => this.agendamentoDao.persist(agendamento))
          .then(() => agendamento.confirmado);
        }else{
          throw new Error("Agendamento já realizado para este dia");
        }
      });
  }

}
