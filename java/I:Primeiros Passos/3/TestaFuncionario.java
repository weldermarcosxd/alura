class TestaFuncionario {

public static void main(String[] args) {
        Funcionario f1 = new Funcionario();

        Data data = new Data();
        data.setDia(10);
        data.setMes(10);
        data.setAno(2010);

        f1.setNome("Hugo");
        f1.setSalario(100);
        f1.recebeAumento(50);
        f1.setDataEntrada(data);
        f1.mostra();

        System.out.println("salario atual:" + f1.getSalario());
        System.out.println("ganho anual:" + f1.calculaGanhoAnual());

        Funcionario f2 = new Funcionario();
        f2.setNome("Danilo");
        f2.setSalario(100);
        f2.setDataEntrada(data);

        Funcionario f3 = new Funcionario();
        f3.setNome("Danilo");
        f3.setSalario(100);
        f3.setDataEntrada(data);

        if (f3 == f2) {
                System.out.println("iguais");
        } else {
                System.out.println("diferentes");
        }

        Funcionario f4 = new Funcionario();
        f4.setNome("Danilo");
        f4.setSalario(100);
        f4.setDataEntrada(data);

        Funcionario f5 = f4;

        if (f5 == f4) {
                System.out.println("iguais");
        } else {
                System.out.println("diferentes");
        }

        Funcionario f6 = new Funcionario();
        f6.setNome("João");
        f6.setSalario(100);
        f6.setDataEntrada(data);

        f6.mostra();
}
}
