package JavaAssessment;

class TaxUtil {
    // Solution 1: Pure function by passing rate as parameter
    public double calculateTaxWithParam(double amount, double rate) {
        return amount * rate;
    }

    // Solution 2: Pure function using a constant rate
    private static final double RATE = 0.15;

    public double calculateTaxWithConstant(double amount) {
        return amount * RATE;
    }
}

public class PureFunctionExample {
    public static void main(String[] args) {
        TaxUtil taxUtil = new TaxUtil();
        double amount = 1000.0;
        // Using method with rate as parameter
        double tax1 = taxUtil.calculateTaxWithParam(amount, 0.18);
        System.out.println("Tax with parameter rate: " + tax1);
        // Using method with constant rate
        double tax2 = taxUtil.calculateTaxWithConstant(amount);
        System.out.println("Tax with constant rate: " + tax2);
    }
}
