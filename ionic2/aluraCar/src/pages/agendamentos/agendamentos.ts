import { Component, OnInit } from '@angular/core';
import { NavController, NavParams, AlertController } from 'ionic-angular';
import { Agendamento } from '../../models/agendamento/Agendamento';
import { AgendamentoDAO } from '../../persistence/agendamento/agendamento-dao';
import { AgendamentoProvider } from '../../providers/agendamento-provider';
import { ItemSliding } from 'ionic-angular';

@Component({
  selector: 'page-agendamentos',
  templateUrl: 'agendamentos.html'
})
export class AgendamentosPage implements OnInit {

  public agendamentos: Array<Agendamento>;

  constructor(
    public navCtrl: NavController,
    public navParams: NavParams,
    public agendamentoDAO: AgendamentoDAO,
    public agendamentoProvider: AgendamentoProvider,
    public alertController: AlertController) { }

  ngOnInit() {
    this.agendamentoDAO.findList()
      .then(data => this.agendamentos = data);
  }

  reenviar(agendamento: Agendamento, slidingItem: ItemSliding) {
    this.agendamentoProvider.reenvia(agendamento)
      .then(reenviado => {

        let alert = this.alertController.create({
          title: 'Reenvio',
          buttons: [{ text: 'Ok' }]
        });

        reenviado ?
          alert.setSubTitle('Agendamento reenviado com sucesso') :
          alert.setSubTitle('Não foi possível reenviar o agendamento. Tente outra vez');

        alert.present();
      });
      slidingItem.close()
  }
}
