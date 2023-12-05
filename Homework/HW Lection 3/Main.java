import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please, enter the USD amount you want to convert in UAH: ");
        double usdAmount = scanner.nextDouble();


        double commissionRate = 0.01;
        double exchangeRate = 36.55;

        currencyConverter converter = new currencyConverter(commissionRate, exchangeRate);
        double total = converter.calculateTotalAmount(usdAmount);

        System.out.println("You should pay in UAH: " + total);
    }



}



