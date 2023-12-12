public class currencyConverter {
    private double commission;
    private double exchangeRate;

    public currencyConverter(double commission, double exchangeRate) {
        this.commission = commission;
        this.exchangeRate = exchangeRate;
    }

    public double getCommission() {
        return commission;
    }


    public double getExchangeRate() {
        return exchangeRate;
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
        return amountInUah - commissionAmount;
    }

    }


