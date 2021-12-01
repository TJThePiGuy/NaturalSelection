package NaturalSelection;
import java.util.Random;

public class Helper {
    static Random random = new Random();

    final private static String setOfCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789?!. ";

    static char newRandomChar() {
        return setOfCharacters.charAt(random.nextInt(setOfCharacters.length()));
    }
}
