import { NgModule }      from '@angular/core';
import { CommonModule } from '@angular/common';
import { FotoComponent }   from './foto.component';
import { FotoPipes } from './foto.pipes';
import { FotoService } from './foto.service';

@NgModule({
  imports: [CommonModule],
  declarations: [ FotoComponent, FotoPipes ],
  exports: [FotoComponent, FotoPipes],
  providers: [FotoService]
})
export class FotoModule { }
