package encryptdecrypt;

import java.util.Arrays;

public class ShiftAlgorithm implements CryptoAlgorithm {
    private static final Character[] ALPHABET = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    public String encrypt(String inputStr, int key) {
        char[] inputChars = inputStr.toCharArray();
        StringBuilder outputChars = new StringBuilder();

        for (char ch : inputChars) {
            if (!Character.isLetter(ch)) {
                outputChars.append(ch);
                continue;
            }
            int modifiedCharIndex = Arrays.asList(ALPHABET).indexOf(Character.toLowerCase(ch)) + key;
            if (modifiedCharIndex > ALPHABET.length) {
                modifiedCharIndex = modifiedCharIndex - ALPHABET.length;
            }
            Character charToAppend = Character.isUpperCase(ch) ?
                Character.toUpperCase(ALPHABET[modifiedCharIndex]) :
                ALPHABET[modifiedCharIndex];

            outputChars.append(charToAppend);
        }

        return outputChars.toString();
    }

    public String decrypt(String inputStr, int key) {
        char[] inputChars = inputStr.toCharArray();
        StringBuilder outputChars = new StringBuilder();

        for (char ch : inputChars) {
            if (!Character.isLetter(ch)) {
                outputChars.append(ch);
                continue;
            }
            int modifiedCharIndex = Arrays.asList(ALPHABET).indexOf(ch) - key;
            if (modifiedCharIndex < 0) {
                modifiedCharIndex = modifiedCharIndex + ALPHABET.length;
            }
            Character charToAppend = Character.isUpperCase(ch) ?
                    Character.toUpperCase(ALPHABET[modifiedCharIndex]) :
                    ALPHABET[modifiedCharIndex];

            outputChars.append(charToAppend);
        }

        return outputChars.toString();
    }
}
