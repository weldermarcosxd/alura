import { NgModule, ErrorHandler } from '@angular/core';
import { IonicApp, IonicModule, IonicErrorHandler } from 'ionic-angular';
import { MyApp } from './app.component';
import { HomePage } from '../pages/home/home';
import { DetailPage } from '../pages/detail/detail';
import { CadastroPage } from '../pages/cadastro/cadastro';
import { AgendamentosPage } from "../pages/agendamentos/agendamentos";
import { AgendamentoProvider } from '../providers/agendamento-provider';
import { AgendamentoDAO } from '../persistence/agendamento/agendamento-dao';
import { Storage } from '@ionic/storage';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';

function provideStorage(){
  return new Storage(['indexeddb'], {
    name: 'aluracar',
    storeName: 'agendamentos'
  });
}

@NgModule({
  declarations: [
    MyApp,
    HomePage,
    DetailPage,
    CadastroPage,
    AgendamentosPage
  ],
  imports: [
    IonicModule.forRoot(MyApp)
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    HomePage,
    DetailPage,
    CadastroPage,
    AgendamentosPage
  ],
  providers: [
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    AgendamentoProvider,
    AgendamentoDAO,
    {provide: Storage, useFactory: provideStorage},
  ]
})
export class AppModule {}
