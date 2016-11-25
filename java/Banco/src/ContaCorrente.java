public class ContaCorrente extends Conta implements Tributavel{
	
	@Override
	public void atualiza(double valor) {
		// TODO Auto-generated method stub
	}

	@Override
	public double calculaTributos() {
		return this.getSaldo() * 0.01;
	}
	
}
