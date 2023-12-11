import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please, enter the USD amount you want to convert in UAH: ");
        double usdAmount = scanner.nextDouble();


        currencyConverter converter = new currencyConverter(0.01, 36.55);

        double commission = converter.getCommission();
        double exchangeRate = converter.getExchangeRate();

        double total = converter.calculateTotalAmount(usdAmount);

        System.out.println("You should pay in UAH: " + total);
    }



}



