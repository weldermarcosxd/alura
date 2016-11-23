public class fatorialLong {
public static void main(String[] args) {
        for (long i = 1; i <=50; i++) {
                long x = 1;
                for (long j = i; j > 0; j-- ) {
                        x = x * j;
                }
                System.out.println("O fatorial de " + i + " é " + x);
        }
}
}
