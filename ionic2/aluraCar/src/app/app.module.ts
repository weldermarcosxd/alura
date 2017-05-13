import { NgModule, ErrorHandler } from '@angular/core';
import { IonicApp, IonicModule, IonicErrorHandler } from 'ionic-angular';
import { MyApp } from './app.component';
import { HomePage } from '../pages/home/home';
import { DetailPage } from '../pages/detail/detail';
import { CadastroPage } from '../pages/cadastro/cadastro';
import { PerfilPage } from '../pages/perfil/perfil';
import { LoginPage } from '../pages/login/login';
import { LoginProvider } from '../providers/login-provider';
import { AgendamentosPage } from "../pages/agendamentos/agendamentos";
import { AgendamentoProvider } from '../providers/agendamento-provider';
import { AgendamentoDAO } from '../persistence/agendamento/agendamento-dao';
import { Storage } from '@ionic/storage';

import { BrowserModule } from '@angular/platform-browser';
import { HttpModule } from '@angular/http';

import { SplashScreen } from '@ionic-native/splash-screen';
import { StatusBar } from '@ionic-native/status-bar';
import { Vibration } from '@ionic-native/vibration';
import { DatePicker } from '@ionic-native/date-picker';
import { Camera } from '@ionic-native/camera';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';

function provideStorage(){
  return new Storage({
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
    AgendamentosPage,
    LoginPage,
    PerfilPage
  ],
  imports: [
    IonicModule.forRoot(MyApp),
    BrowserModule,
    HttpModule
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    HomePage,
    DetailPage,
    CadastroPage,
    AgendamentosPage,
    LoginPage,
    PerfilPage
  ],
  providers: [
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    {provide: Storage, useFactory: provideStorage},
    AgendamentoProvider,
    AgendamentoDAO,
    LoginProvider,
    SplashScreen,
    StatusBar,
    Vibration,
    DatePicker,
    Camera
  ]
})
export class AppModule {}
