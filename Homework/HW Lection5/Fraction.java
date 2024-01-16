public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (getClass() != obj.getClass()) return false;

        Fraction otherFraction = (Fraction) obj;

        long leftProduct = this.numerator * otherFraction.denominator;
        long rightProduct = otherFraction.numerator * this.denominator;

        return leftProduct == rightProduct;
    }

}
