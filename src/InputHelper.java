import java.util.Scanner;

public class InputHelper {

    public static String getNonZeroLenString(Scanner scan, String prompt) {
        while (true) {
            System.out.println(prompt + " ");
            String input = scan.nextLine();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Error: Input cannot be empty. Please try again.");
        }
    }

    public static int getInt(Scanner scan, String prompt) {
        while (true) {
            System.out.println(prompt + " ");
            if (scan.hasNextInt()) {
                int result = scan.nextInt();
                scan.nextLine();
                return result;
            }
            scan.nextLine();
            System.out.println("Error: Invalid integer entered. Please try again.");
        }
    }

    public static double getDouble(Scanner scan, String prompt) {
        while (true) {
            System.out.println(prompt + " ");
            if (scan.hasNextDouble()) {
                double result = scan.nextDouble();
                scan.nextLine();
                return result;
            }
            scan.nextLine();
            System.out.println("Error: Invalid double entered. Please try again.");
        }
    }

    public static int getRangedInt(Scanner scan, String prompt, int min, int max) {
        while (true) {
            int value = getInt(scan, prompt + " [" + min + " - " + max + "]:");
            if (value >= min && value <= max) {
                return value;
            }
            System.out.println("Error: Input is out of range.");
        }
    }

    public static double getRangedDouble(Scanner scan, String prompt, double min, double max) {
        while (true) {
            double value = getDouble(scan, prompt + " [" + min + " - " + max + "]:");
            if (value >= min && value <= max) {
                return value;
            }
            System.out.println("Error: Input is out of range.");
        }
    }

    public static int getPositiveNonZeroInt(Scanner scan, String prompt) {
        while (true) {
            int value = getInt(scan, prompt);
            if (value > 0) {
                return value;
            }
            System.out.println("Error: Input must be greater than 0.");
        }
    }

    public static boolean getYNConfirm(Scanner scan, String prompt) {
        while (true) {
            System.out.println(prompt + " [Y/N]: ");
            String input = scan.nextLine();
            if (input.equalsIgnoreCase("Y")) return true;
            if (input.equalsIgnoreCase("N")) return false;
            System.out.println("Error: You must enter 'Y' or 'N'.");
        }
    }

    public static String getRegExString(Scanner scan, String prompt, String regExPattern) {
        while (true) {
            System.out.print(prompt + " ");
            String s = scan.nextLine();
            if (s.matches(regExPattern)) {
                return s;
            }
            System.out.println("Input does not match the right pattern.");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("--- Testing InputHelper ---");

        String name = getNonZeroLenString(scan, "Enter your name:");
        System.out.println("Hello, " + name + "!\n");

        int age = getRangedInt(scan, "Enter your age", 1, 120);
        System.out.println("Your age is recorded as: " + age + "\n");

        boolean choice = getYNConfirm(scan, "Do you like coding?");
        System.out.println("Your choice was: " + choice + "\n");

        String phone = getRegExString(scan, "Enter your phone number (XXX-XXX-XXXX):", "\\d{3}-\\d{3}-\\d{4}");
        System.out.println("Phone number recorded: " + phone);
    }
}
