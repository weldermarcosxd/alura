class TestaFuncionario2 {

public static void main(String[] args) {
        Empresa empresa = new Empresa();
        empresa.setFuncionarios(new Funcionario[10]);

        Data data = new Data();
        data.setDia(10);
        data.setMes(10);
        data.setAno(2010);

        for (int i =0; i < 10; i++ ) {
                Funcionario f6 = new Funcionario();
                f6.setNome("João");
                f6.setSalario(100 + i * i);
                f6.setDataEntrada(data);

                empresa.contratar(f6);
        }

        for(Funcionario funcionario : empresa.getFuncionarios()) {
                funcionario.mostra();
        }

        System.out.println(empresa.contem(new Funcionario()));
}
}
