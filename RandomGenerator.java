package kimball;  // Ensure the package matches the folder structure

import java.util.Random;

public class RandomGenerator {
    private static String randomh = null;  // Static variable to store the random string

    // Static block to generate the random string only once
    static {
        Random random = new Random();
        int randomInt = random.nextInt(10000); // Generates a random integer from 0 to 9999
        String randomString = String.valueOf(randomInt);
        String text = "unique";
        randomh = randomString + text; // Concatenate randomInt and "unique"
    }

    // Static method to access the random string
    public static String getRandomh() {
        return randomh;
    }
}
