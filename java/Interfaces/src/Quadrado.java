public class Quadrado implements AreaCalculavel{

	private int lado;
	
	@Override
	public double calculaArea() {
		return lado * lado;
	}
	
	public Quadrado() {
	}
	
	public Quadrado(int lado){
		this.lado = lado;
	}
}
