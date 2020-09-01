import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> input = new ArrayList<>();
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            if (str.equals("0")) {
                break;
            }
            input.add(str);
        }

        for (String inputStr : input) {
            try {
                int num = Integer.parseInt(inputStr);
                System.out.println(num * 10);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid user input: " + inputStr);
            }
        }
    }
}
