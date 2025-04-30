package VehicleInsurance;

import java.time.LocalDate;

public class ThirdPartyPolicy extends InsurancePolicy {
    public ThirdPartyPolicy(String policyId, String vehicleLicense, String vehicleMake,
                            String vehicleModel, int vehicleYear, int engineSize,
                            String customerName, String licenseNumber, double coverage,
                            LocalDate startDate, LocalDate endDate) {
        super(policyId, vehicleLicense, vehicleMake, vehicleModel, vehicleYear, engineSize,
                customerName, licenseNumber, coverage, startDate, endDate);
        calculatePremium();
    }

    @Override
    public void calculatePremium() {
        premium = coverage * 0.03 * (engineSize / 1000.0);
    }

    @Override
    public boolean processClaim(double amount) {
        if (amount > coverage * 0.8) {
            System.out.println("Third party claims limited to 80% of coverage");
            return false;
        }
        System.out.println("Third party claim processed for $" + amount);
        return true;
    }

    @Override
    public void printDetails() {
        System.out.println("\nThird Party Policy " + policyId);
        System.out.println("Vehicle: " + vehicleMake + " " + vehicleModel + " (" + vehicleLicense + ")");
        System.out.println("Customer: " + customerName + " (License: " + licenseNumber + ")");
        System.out.println("Coverage: $" + coverage);
        System.out.println("Premium: $" + premium);
    }
    }
