package VehicleInsurance;

import java.time.LocalDate;

public class ComprehensivePolicy extends InsurancePolicy {
    private boolean includesTheft;

    public ComprehensivePolicy(String policyId, String vehicleLicense, String vehicleMake,
                               String vehicleModel, int vehicleYear, int engineSize,
                               String customerName, String licenseNumber, double coverage,
                               LocalDate startDate, LocalDate endDate, boolean includesTheft) {
        super(policyId, vehicleLicense, vehicleMake, vehicleModel, vehicleYear, engineSize,
                customerName, licenseNumber, coverage, startDate, endDate);
        this.includesTheft = includesTheft;
        calculatePremium();
    }

    @Override
    public void calculatePremium() {
        int vehicleAge = LocalDate.now().getYear() - vehicleYear;
        premium = coverage * 0.05 * (1 + (vehicleAge * 0.01));
        if (includesTheft) premium *= 1.2;
    }

    @Override
    public boolean processClaim(double amount) {
        if (amount > coverage) {
            System.out.println("Claim exceeds coverage limit");
            return false;
        }
        System.out.println("Comprehensive claim processed for $" + amount);
        return true;
    }

    @Override
    public void printDetails() {
        System.out.println("\nComprehensive Policy " + policyId);
        System.out.println("Vehicle: " + vehicleMake + " " + vehicleModel + " (" + vehicleLicense + ")");
        System.out.println("Customer: " + customerName + " (License: " + licenseNumber + ")");
        System.out.println("Coverage: $" + coverage);
        System.out.println("Premium: $" + premium);
        System.out.println("Theft Coverage: " + (includesTheft ? "Yes" : "No"));
    }
}