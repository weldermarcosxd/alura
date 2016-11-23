public class Empresa {

private String nome;
private String cnpj;
private Funcionario[] funcionarios;
int count = 0;

public void contratar(Funcionario f){
        Funcionario[] funcionarios = this.getFuncionarios();
        funcionarios[this.count++] = f;
        this.setFuncionarios(funcionarios);
}

public boolean contem(Funcionario f){
        Boolean contem = false;
        for(Funcionario funcionario : this.getFuncionarios()) {
                if(f == funcionario) {
                        contem = true;
                }
        }
        return contem;
}

public Empresa() {
}

public String getNome() {
        return this.nome;
}

public void setNome(String nome) {
        this.nome = nome;
}

public String getCnpj() {
        return this.cnpj;
}

public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
}

public Funcionario[] getFuncionarios() {
        return this.funcionarios;
}

public void setFuncionarios(Funcionario[] funcionario) {
        this.funcionarios = funcionario;
}
}
