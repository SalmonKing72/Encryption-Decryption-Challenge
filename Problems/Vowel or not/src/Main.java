import java.util.Scanner;

public class Main {

    public static boolean isVowel(char ch) {
        // write your code here
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        boolean result = false;
        for (char vowel : vowels) {
            if (Character.toString(vowel).equals( Character.toString(ch).toLowerCase())) result = true;
        }
        return result;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char letter = scanner.nextLine().charAt(0);
        System.out.println(isVowel(letter) ? "YES" : "NO");
    }
}
