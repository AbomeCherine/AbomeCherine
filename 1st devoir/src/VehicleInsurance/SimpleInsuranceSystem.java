package VehicleInsurance;

import java.util.Scanner;
import java.time.LocalDate;

public class SimpleInsuranceSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static InsurancePolicy[] policies = new InsurancePolicy[100];
    private static int policyCount = 0;

    public static void main(String[] args) {
        System.out.println("Simple Insurance System");

        boolean running = true;
        while (running) {
            System.out.println("\n1. Create Policy\n2. Make Claim\n3. View Policies\n4. Exit");
            System.out.print("Select option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    createPolicy();
                    break;
                case 2:
                    makeClaim();
                    break;
                case 3:
                    viewPolicies();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void createPolicy() {
        System.out.println("\nCreate New Policy");

        // Get vehicle details
        System.out.print("License plate: ");
        String license = scanner.nextLine();
        System.out.print("Make: ");
        String make = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Year: ");
        int year = scanner.nextInt();
        System.out.print("Engine size (cc): ");
        int engineSize = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        // Get customer details
        System.out.print("\nCustomer name: ");
        String name = scanner.nextLine();
        System.out.print("Driver's license: ");
        String licenseNum = scanner.nextLine();

        // Policy details
        System.out.print("\nCoverage amount: $");
        double coverage = scanner.nextDouble();
        System.out.print("Policy type (1-Comprehensive, 2-Third Party): ");
        int type = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        String policyId = "POL" + (policyCount + 1001);
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusYears(1);

        if (type == 1) {
            System.out.print("Include theft coverage? (true/false): ");
            boolean theftCoverage = scanner.nextBoolean();
            policies[policyCount++] = new ComprehensivePolicy(
                    policyId, license, make, model, year, engineSize,
                    name, licenseNum, coverage, startDate, endDate, theftCoverage);
        } else {
            policies[policyCount++] = new ThirdPartyPolicy(
                    policyId, license, make, model, year, engineSize,
                    name, licenseNum, coverage, startDate, endDate);
        }

        System.out.println("\nPolicy created! ID: " + policyId);
    }

    private static void makeClaim() {
        if (policyCount == 0) {
            System.out.println("No policies exist");
            return;
        }

        System.out.println("\nAvailable Policies:");
        for (int i = 0; i < policyCount; i++) {
            System.out.println((i + 1) + ". " + policies[i].policyId + " - " +
                    policies[i].vehicleMake + " " + policies[i].vehicleModel);
        }

        System.out.print("Select policy: ");
        int policyIndex = scanner.nextInt() - 1;
        System.out.print("Claim amount: $");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Clear buffer

        if (policyIndex >= 0 && policyIndex < policyCount) {
            if (policies[policyIndex].processClaim(amount)) {
                System.out.println("Claim approved!");
            } else {
                System.out.println("Claim denied");
            }
        } else {
            System.out.println("Invalid policy selection");
        }
    }

    private static void viewPolicies() {
        if (policyCount == 0) {
            System.out.println("No policies exist");
            return;
        }

        System.out.println("\nAll Policies:");
        for (int i = 0; i < policyCount; i++) {
            policies[i].printDetails();
        }
    }
}
