package VehicleInsurance;



import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
abstract class InsurancePolicy {
    protected String policyId;
    protected String vehicleLicense;
    protected String vehicleMake;
    protected String vehicleModel;
    protected int vehicleYear;
    protected int engineSize;
    protected String customerName;
    protected String licenseNumber;
    protected double coverage;
    protected double premium;
    protected LocalDate startDate;
    protected LocalDate endDate;

    public InsurancePolicy(String policyId, String vehicleLicense, String vehicleMake,
                           String vehicleModel, int vehicleYear, int engineSize,
                           String customerName, String licenseNumber, double coverage,
                           LocalDate startDate, LocalDate endDate) {
        this.policyId = policyId;
        this.vehicleLicense = vehicleLicense;
        this.vehicleMake = vehicleMake;
        this.vehicleModel = vehicleModel;
        this.vehicleYear = vehicleYear;
        this.engineSize = engineSize;
        this.customerName = customerName;
        this.licenseNumber = licenseNumber;
        this.coverage = coverage;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public abstract void calculatePremium();
    public abstract boolean processClaim(double amount);
    public abstract void printDetails();
    }

