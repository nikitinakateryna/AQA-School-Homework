import java.util.Scanner;

public class Result {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter two fractions a/b c/d: ");
        String input = scanner.nextLine();
        String[] parts = input.split(" ");

        String[] fraction1Parts = parts[0].split("/");
        Fraction fraction1 = new Fraction(Integer.parseInt(fraction1Parts[0]), Integer.parseInt(fraction1Parts[1]));

        String[] fraction2Parts = parts[1].split("/");
        Fraction fraction2 = new Fraction(Integer.parseInt(fraction2Parts[0]), Integer.parseInt(fraction2Parts[1]));

        System.out.println("Result: " + fraction1.equals(fraction2));

    }

}
