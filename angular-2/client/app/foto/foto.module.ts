import { NgModule }      from '@angular/core';
import { FotoComponent }   from './foto.component';
import { FotoPipes } from './foto.pipes';

@NgModule({
  declarations: [ FotoComponent, FotoPipes ],
  exports: [FotoComponent, FotoPipes]
})
export class FotoModule { }
