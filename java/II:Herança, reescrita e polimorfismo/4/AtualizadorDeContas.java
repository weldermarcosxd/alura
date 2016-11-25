class AtualizadorDeContas {
private double saldoTotal = 0;
private double selic;

public AtualizadorDeContas(double selic) {
        this.selic = selic;
}

public void roda(Conta c) {
        System.out.print(c.getSaldo());
        c.setSaldo(c.getSaldo() - this.selic);
        c.atualiza(this.selic);
        setSaldoTotal(getSaldoTotal() + c.getSaldo());
}

// outros métodos, colocar o getter para saldoTotal!

public double getSaldoTotal() {
        return this.saldoTotal;
}

public void setSaldoTotal(double saldoTotal) {
        this.saldoTotal = saldoTotal;
}

public double getSelic() {
        return this.selic;
}

public void setSelic(double selic) {
        this.selic = selic;
}
}
