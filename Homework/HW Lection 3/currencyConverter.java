public class currencyConverter {
    private double commission;
    private double exchangeRate;

    public currencyConverter(double commission, double exchangeRate) {
        this.commission = commission;
        this.exchangeRate = exchangeRate;
    }

    private double convertUsdToUah(double usdAmount) {
        return usdAmount * exchangeRate;
    }

    private double calculateCommission(double commissionAmount) {
        return commissionAmount * commission;
    }

    public double calculateTotalAmount(double usdAmount) {
        double amountInUah = convertUsdToUah(usdAmount);
        double commissionAmount = calculateCommission(amountInUah);
        return amountInUah + commissionAmount;
    }

    }


