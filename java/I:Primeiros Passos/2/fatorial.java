public class fatorial {
public static void main(String[] args) {
        for (int i = 1; i <=10; i++) {
                int x = 1;
                for (int j = i; j > 0; j-- ) {
                        x = x * j;
                }
                System.out.println("O fatorial de " + i + " é " + x);
        }
}
}
