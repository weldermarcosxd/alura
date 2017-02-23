import { RouterModule, Routes } from '@angular/router';
import { CadastroComponent } from './cadastro/cadastro.component';
import { ListagemComponent } from './listagem/listagem.component';

const app_routes: Routes =  [
  { path: '', component: ListagemComponent },
  { path: 'cadastro', component: CadastroComponent },
  { path: 'cadastro/:id', component: CadastroComponent },
  { path: '**', redirectTo: ''}
];

export const app_routing = RouterModule.forRoot(app_routes);
