import java.security.SecureRandom;

public class PasswordGenerator {
    public static void main(String[] args) {
        String userUpperCase = "A"; // Kullanıcıdan alınan büyük harf
        String userLowerCase = "a"; // Kullanıcıdan alınan küçük harf
        String userNumbers = "24"; // Kullanıcıdan alınan sayılar
        String userSpecialChar = "#"; // Kullanıcıdan alınan özel simge

        String password = generatePassword(userUpperCase, userLowerCase, userNumbers, userSpecialChar);

        System.out.println("Oluşturulan Şifre: " + password);
    }

    public static String generatePassword(String userUpperCase, String userLowerCase, String userNumbers, String userSpecialChar) {
        if (userUpperCase.length() != 1 || userLowerCase.length() != 1 || userNumbers.length() != 2 || userSpecialChar.length() != 1) {
            throw new IllegalArgumentException("Geçersiz giriş.");
        }

        StringBuilder password = new StringBuilder();
        password.append(userUpperCase);
        password.append(userLowerCase);

        String allChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < 5; i++) {
            int randomIndex = random.nextInt(allChars.length());
            password.append(allChars.charAt(randomIndex));
        }

        password.append(userNumbers);
        password.append(userSpecialChar);

        password.append(generateRandomChars(2, allChars));

        return password.toString();
    }

    private static String generateRandomChars(int length, String validChars) {
        StringBuilder randomChars = new StringBuilder();
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(validChars.length());
            randomChars.append(validChars.charAt(randomIndex));
        }

        return randomChars.toString();
    }
}