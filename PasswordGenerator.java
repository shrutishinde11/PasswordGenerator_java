import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of the password: ");
        int length = scanner.nextInt();

        System.out.print("Enter the complexity (1: Letters, 2: Letters + Numbers, 3: Letters + Numbers + Special Characters): ");
        int complexity = scanner.nextInt();

        String password = generatePassword(length, complexity);
        System.out.println("Generated Password: " + password);
    }

    public static String generatePassword(int length, int complexity) {
        StringBuilder password = new StringBuilder();
        SecureRandom random = new SecureRandom();

        String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String specialChars = "!@#$%^&*()_+{}[]";

        String characters = letters;

        if (complexity >= 2) {
            characters += numbers;
        }
        if (complexity >= 3) {
            characters += specialChars;
        }

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }

        return password.toString();
    }
}
