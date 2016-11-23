public class condicional {
public static void main(String[] args) {
        System.out.print("Digite um número: ");
        int numero = Integer.valueOf(System.console().readLine());

        System.out.print(numero);

        while(numero != 1) {
                System.out.print(">");
                if(numero % 2 == 0) {
                        numero = numero / 2;
                }else {
                        numero = numero * 3 + 1;
                }
                System.out.print(numero);
        }
}
}
