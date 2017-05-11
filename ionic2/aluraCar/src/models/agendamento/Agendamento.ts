import { Carro } from '../carro/Carro';

export class Agendamento{

  constructor(
    public carro: Carro = null,
    public preco: number = 0,
    public nome: string = '',
    public endereco: string = '',
    public email: string = '',
    public data: string = new Date().toISOString(),
    public confirmado: boolean = false){  }

}
