public class Triangle {
    public static void main(String[] args) {

            for (int i = 1; i <= 7; i++) {
                for (int j = 1; j <= 7 - i; j++) {
                    System.out.print("  ");
                }

                int k = 1;
                while (k <= 2 * i - 1) {
                    System.out.print("* ");
                    k++;
                }
                System.out.println();

            }
        }
}
