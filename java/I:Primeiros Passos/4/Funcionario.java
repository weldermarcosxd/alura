public class Funcionario {
private String nome;
private String departamento;
private double salario;
private Data dataEntrada;
private String rg;

private static int proximoIdentificador = 1;
private int identificador;

public static int getProximoIdentificador(){
        return proximoIdentificador;
}

public Funcionario(){
}

public Funcionario(String nome){
        this.setNome(nome);
        this.setIdentificador(++proximoIdentificador);
}

public void mostra() {
        System.out.println("Nome: " + this.getNome());
        System.out.println("Departamento: " + this.getDepartamento());
        System.out.println("Salario: " + this.getSalario());
        System.out.println("Data Entrada:" +this.getDataEntrada());
        System.out.println("RG: " + this.getRg());
        // imprimir aqui os outros atributos...
        // também pode imprimir this.calculaGanhoAnual()
        System.out.println("RG: " + this.getDataEntrada().getFormatada());
}

public void recebeAumento(double aumento){
        setSalario(getSalario() + aumento);
}

public double calculaGanhoAnual(){
        double retorno = 0;

        if(0 < getSalario()) {
                retorno = getSalario() * 12;
        }
        return retorno;
}

public int getIdentificador(){
        return this.identificador;
}

public void setIdentificador(int identificador){
        this.identificador = identificador;
}

public String getNome() {
        return this.nome;
}

public void setNome(String nome) {
        this.nome = nome;
}

public String getDepartamento() {
        return this.departamento;
}

public void setDepartamento(String departamento) {
        this.departamento = departamento;
}

public double getSalario() {
        return this.salario;
}

public void setSalario(double salario) {
        this.salario = salario;
}

public Data getDataEntrada() {
        return this.dataEntrada;
}

public void setDataEntrada(Data dataEntrada) {
        this.dataEntrada = dataEntrada;
}

public String getRg() {
        return this.rg;
}

public void setRg(String rg) {
        this.rg = rg;
}
}
