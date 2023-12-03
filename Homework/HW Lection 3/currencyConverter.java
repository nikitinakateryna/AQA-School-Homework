public class currencyConverter {
    private float commission;
    private float exchangeRate;

    public currencyConverter(float commission, float exchangeRate) {
        this.commission = commission;
        this.exchangeRate = exchangeRate;
    }

    private double convertUsdToUah(double amountInUsd) {
        return amountInUsd * exchangeRate;
    }

    private double calculateCommission(double amount) {
        return amount * commission / 100;
    }

    public double calculateTotalAmount(double amountInUsd) {
        double amountInUah = convertUsdToUah(amountInUsd);
        double commissionAmount = calculateCommission(amountInUah);
        return amountInUah + commissionAmount;
    }
}
