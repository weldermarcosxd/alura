import { Component, OnInit } from '@angular/core';
import { NavController, NavParams, AlertController, Alert } from 'ionic-angular';
import { Carro } from '../../models/carro/Carro';
import { Agendamento } from '../../models/agendamento/Agendamento';
import { HomePage } from '../home/home';
import { AgendamentoProvider } from '../../providers/agendamento-provider';

import { Vibration } from '@ionic-native/vibration';
import { DatePicker } from '@ionic-native/date-picker';

@Component({
  selector: 'page-cadastro',
  templateUrl: 'cadastro.html'
})
export class CadastroPage implements OnInit {

  private _alert: Alert;
  public carro: Carro;
  public precoTotal: number;
  public agendamento: Agendamento;

  constructor(
    public navCtrl: NavController,
    public navParams: NavParams,
    public agendamentoProvider: AgendamentoProvider,
    public alertController: AlertController,
    public vibration: Vibration,
    public datePicker: DatePicker) { }

  ngOnInit() {
    this.carro = this.navParams.get('carro');
    this.precoTotal = this.navParams.get('precoTotal');
    this.agendamento = new Agendamento(this.carro, this.precoTotal);
    this._alert = this.alertController.create({
      title: "Aviso", buttons: [{
        text: "OK", handler: () => {
          this.navCtrl.setRoot(HomePage);
        }
      }]
    });
  }

  getDate() {
    this.datePicker.show({
      mode: 'date',
      date: new Date()
    })
      .then(data => {
        this.agendamento.data = data.toISOString();
      });
  }

  finalizar() {

    if (!this.agendamento.nome || !this.agendamento.email || !this.agendamento.endereco) {
      this.vibration.vibrate(500);
      this.alertController.create({
        title: "Atenção",
        subTitle: "Todos os campos devem ser preenchidos corretamente.",
        buttons: [{ text: "OK" }]
      }).present();
      return;
    }

    this.agendamentoProvider.agenda(this.agendamento)
      .then(confirmado => {
        confirmado ?
          this._alert.setSubTitle("Agendamento realizado com sucesso!") :
          this._alert.setSubTitle("Agendamento não pode ser realizado!");
        this._alert.present();
      })
      .catch(err => {
        console.log(err)
        this._alert.setSubTitle(err.message);
        this._alert.present();
      });
  }
}
