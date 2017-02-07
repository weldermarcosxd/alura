import { Component, Input, OnInit} from '@angular/core';

@Component({
  moduleId: module.id,
  selector: 'painel',
  templateUrl: './painel.component.html'
})

export class PainelComponent implements OnInit{

  @Input() title: string;

  ngOnInit(){
    this.title = this.title.length > 7 ? this.title.substr(0, 7) + "..." : this.title;
  }

}
