import { NgModule }      from '@angular/core';
import { HttpModule }      from '@angular/http';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }   from './app.component';
import { FotoModule } from './foto/foto.module';
import { PainelModule } from './painel/painel.module';

import 'rxjs/add/operator/map';

@NgModule({
  imports:      [ BrowserModule, FotoModule, PainelModule,  HttpModule ],
  declarations: [ AppComponent ],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
