import { Component, OnInit } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import { Agendamento } from '../../models/agendamento/Agendamento';
import { AgendamentoDAO } from '../../persistence/agendamento/agendamento-dao';

@Component({
  selector: 'page-agendamentos',
  templateUrl: 'agendamentos.html'
})
export class AgendamentosPage implements OnInit {

  public agendamentos: Array<Agendamento>;

  constructor(
    public navCtrl: NavController,
    public navParams: NavParams,
    public agendamentoDAO: AgendamentoDAO) { }

  ngOnInit() {
    this.agendamentoDAO.findList()
    .then(data => this.agendamentos = data);
  }

}
