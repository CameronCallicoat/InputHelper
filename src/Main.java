import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("--- Testing InputHelper ---");

        String name = InputHelper.getNonZeroLenString(scan, "Enter your name:");
        System.out.println("Hello, " + name + "!\n");

        int age = InputHelper.getRangedInt(scan, "Enter your age", 1, 120);
        System.out.println("Your age is recorded as: " + age + "\n");

        boolean choice = InputHelper.getYNConfirm(scan, "Do you like coding?");
        System.out.println("Your choice was: " + choice + "\n");

        String phone = InputHelper.getRegExString(scan, "Enter your phone number (XXX-XXX-XXXX):", "\\d{3}-\\d{3}-\\d{4}");
        System.out.println("Phone number recorded: " + phone);
    }
}
