public class GerenciadorDeImpostoDeRenda {
	private double total;
	
	void adiciona(Tributavel tributavel){
		System.out.println("Adicionando Tributavel: " + tributavel);
		this.setTotal(this.getTotal() + tributavel.calculaTributos());
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}
