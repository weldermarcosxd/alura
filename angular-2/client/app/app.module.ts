import { NgModule }      from '@angular/core';
import { HttpModule }      from '@angular/http';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppComponent }   from './app.component';
import { FotoModule } from './foto/foto.module';
import { BotaoModule } from './botao/botao.module';
import { PainelModule } from './painel/painel.module';
import { CadastroComponent } from './cadastro/cadastro.component';
import { ListagemComponent } from './listagem/listagem.component';
import { app_routing } from './app.routes';

import 'rxjs/add/operator/map';

@NgModule({
  imports:      [ BrowserModule, FotoModule, BotaoModule, PainelModule,  HttpModule, FormsModule, ReactiveFormsModule, app_routing ],
  declarations: [ AppComponent, CadastroComponent, ListagemComponent ],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
