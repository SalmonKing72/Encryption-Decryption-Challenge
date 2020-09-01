package encryptdecrypt;

public class UnicodeAlgorithm implements CryptoAlgorithm {
    public String encrypt(String inputStr, int key) {
        char[] inputChars = inputStr.toCharArray();
        StringBuilder outputChars = new StringBuilder();

        for (char ch : inputChars) {
            int modifiedCharIndex = (int) ch + key;
            outputChars.append((char) modifiedCharIndex);
        }

        return outputChars.toString();
    }

    public String decrypt(String inputStr, int key) {
        char[] inputChars = inputStr.toCharArray();
        StringBuilder outputChars = new StringBuilder();

        for (char ch : inputChars) {
            int modifiedCharIndex = (int) ch - key;
            outputChars.append((char) modifiedCharIndex);
        }

        return outputChars.toString();
    }
}
