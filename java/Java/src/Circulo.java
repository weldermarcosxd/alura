public class Circulo implements AreaCalculavel{
	private double raio;

	@Override
	public double calculaArea() {
		return Math.PI * this.raio;
	}
	
	public Circulo(double raio) {
		this.raio = Math.pow(raio, 2);
	}
}
