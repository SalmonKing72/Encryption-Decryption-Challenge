package encryptdecrypt;

public interface CryptoAlgorithm {
    String encrypt(String inputStr, int key);
    String decrypt(String inputStr, int key);
}
