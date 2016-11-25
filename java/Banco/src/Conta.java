
public abstract class Conta {
	private double saldo;

	public void saca(double valor) {
		this.saldo -= valor;
	}
	
	public void deposita(double valor) throws ValorInvalidoException{
		if(valor < 0){
			throw new ValorInvalidoException();
		}else{
			this.saldo += valor;
		}
	}

	public abstract void atualiza(double valor);

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double valor) {
		this.saldo = valor;
	}
}
