import { Injectable } from '@angular/core';
import { Agendamento }  from '../../models/agendamento/Agendamento';
import { Carro } from '../../models/carro/Carro';
import { Storage }  from '@ionic/storage';

@Injectable()
export class AgendamentoDAO {

  constructor(public storage: Storage) { }

  private getKey(agendamento: Agendamento): string {
    return agendamento.email + agendamento.data.substring(0, 10);
  }

  persist(agendamento: Agendamento): Promise<any> {
    return this.storage.set(this.getKey(agendamento), agendamento);
  }

  getDuplicity(agendamento: Agendamento): Promise<boolean> {
    return this.storage.get(this.getKey(agendamento))
      .then(data => {
        return data ? true : false;
      });
  }

  findList() {
    let agendamentos: Array<Agendamento> = [];
    return this.storage.forEach(data => {
      let carro = new Carro(data.carro.nome, data.carro.valor);
      let agendamento = new Agendamento(
        carro,
        data.preco,
        data.nome,
        data.endereco,
        data.email,
        data.data,
        data.confirmado
      );
      agendamentos.push(agendamento);
    })
      .then(() => agendamentos);
  }
}
