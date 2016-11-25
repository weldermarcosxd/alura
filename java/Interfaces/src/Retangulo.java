public class Retangulo implements AreaCalculavel{
	
	private int largura;
	private int altura;

	@Override
	public double calculaArea() {
		return this.largura * this.altura;
	}
	
	public Retangulo() {
	}
	
	public Retangulo(int largura, int altura) {
		this.largura = largura;
		this.altura = altura;
	}

}
