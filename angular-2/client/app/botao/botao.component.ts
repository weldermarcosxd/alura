import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  moduleId: module.id,
  selector: 'botao',
  templateUrl: './botao.component.html'
})
export class BotaoComponent {
  @Input() name: string = 'OK';
  @Input() style: string = 'btn-default';
  @Input() type: string = 'button';
  @Input() disabled: boolean;
  @Output() acao = new EventEmitter();
  @Input() confirmacao: boolean;

  executaAcao(){
    if(this.confirmacao){
      if(confirm('Are you sure?')){
        this.acao.emit(null);
      }
      return ;
    }
    this.acao.emit(null);
  }
}
