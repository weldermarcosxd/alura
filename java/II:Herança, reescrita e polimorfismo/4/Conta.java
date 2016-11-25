public class Conta {
protected double saldo;

public double getSaldo() {
        return this.saldo;
}

public void setSaldo(double saldo) {
        this.saldo = saldo;
}

public void saca(double saque){
        this.saldo -= saque;
}

public void deposita(double deposito){
        this.saldo += deposito;
}

public void atualiza(double taxa){
        this.saldo += this.saldo * taxa;
}

@Override
public String toString() {
        return "Conta [saldo=" + saldo+ "]";
}

public Conta() {
}
}
