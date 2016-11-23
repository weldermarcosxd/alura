public class BalancoTrimestral {
public static void main(String[] args) {
        int gastosJaneiro = 1500;
        int gastosFevereiro = 23000;
        int gastosMarco = 17000;
        int gastosTrimestre = gastosJaneiro + gastosFevereiro + gastosMarco;

        System.out.println("O gasto do trimestre foi: R$" + gastosTrimestre);
        System.out.println("A média do trimestre foi: R$" + gastosTrimestre/3);
}
}
