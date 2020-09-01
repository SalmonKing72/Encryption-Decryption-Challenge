import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String house = scanner.next();
        String output;

        switch (house) {
            case "gryffindor":
                output = "bravery";
                break;
            case "hufflepuff":
                output = "loyalty";
                break;
            case "slytherin":
                output = "cunning";
                break;
            case "ravenclaw":
                output = "intellect";
                break;
            default:
                output = "not a valid house";
        }

        System.out.println(output);
    }
}
