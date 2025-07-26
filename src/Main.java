import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Declare variables for car's state
        boolean engineOn = false;
        String gear = "P"; // "P" for Park, "D" for Drive, "R" for Reverse
        int speed = 0;
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Main program loop
        while (true) {
            // Display current state of the car
            System.out.println("\nCurrent Car State:");
            System.out.println("1. Engine: " + (engineOn ? "ON" : "OFF"));
            System.out.println("2. Gear: " + gear);
            System.out.println("3. Speed: " + speed + " km/h");

            // Display menu options
            System.out.println("\nOptions:");
            System.out.println("1. Turn engine " + (engineOn ? "OFF" : "ON"));
            System.out.println("2. Change gear");
            System.out.println("3. Accelerate");
            System.out.println("4. Brake");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            // Get user input
            choice = scanner.nextInt();

            // Process user choice
            switch (choice) {
                case 1: // Toggle engine
                    engineOn = !engineOn;
                    if (!engineOn) {
                        gear = "P";
                        speed = 0;
                    }
                    System.out.println("Engine turned " + (engineOn ? "ON" : "OFF"));
                    break;

                case 2: // Change gear
                    if (!engineOn) {
                        System.out.println("Cannot change gear - engine is OFF");
                        break;
                    }
                    System.out.print("Enter new gear (P, D, R): ");
                    String newGear = scanner.next().toUpperCase();
                    if (newGear.equals("P") || newGear.equals("D") || newGear.equals("R")) {
                        if (speed == 0 || (newGear.equals("P") && speed == 0)) {
                            gear = newGear;
                            System.out.println("Gear changed to " + gear);
                        } else {
                            System.out.println("Cannot change gear while moving!");
                        }
                    } else {
                        System.out.println("Invalid gear selection");
                    }
                    break;

                case 3: // Accelerate
                    if (!engineOn) {
                        System.out.println("Cannot accelerate - engine is OFF");
                        break;
                    }
                    if (gear.equals("P")) {
                        System.out.println("Cannot accelerate in Park gear");
                        break;
                    }
                    System.out.print("Enter acceleration amount: ");
                    int acceleration = scanner.nextInt();
                    speed += acceleration;
                    System.out.println("Accelerated to " + speed + " km/h");
                    break;

                case 4: // Brake
                    if (speed > 0) {
                        System.out.print("Enter braking amount: ");
                        int braking = scanner.nextInt();
                        speed = Math.max(0, speed - braking);
                        System.out.println("Slowed down to " + speed + " km/h");
                    } else {
                        System.out.println("Car is already stopped");
                    }
                    break;

                case 5: // Exit
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please enter 1-5.");
            }
        }
    }
}