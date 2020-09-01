import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        double a, b, c;
        double radius;
        double area;
        final double pi = 3.14;

        Scanner scanner = new Scanner(System.in);
        String room = scanner.next();

        switch (room) {
            case "rectangle":
                a = scanner.nextInt();
                b = scanner.nextInt();
                area = a * b;
                break;
            case "triangle":
                a = scanner.nextInt();
                b = scanner.nextInt();
                c = scanner.nextInt();
                double semiPerimeter = (a + b + c) / 2;
                area = Math.sqrt(semiPerimeter * (semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c));
                break;
            case "circle":
                radius = scanner.nextInt();
                area = pi * Math.pow(radius, 2);
                break;
            default:
                throw new IllegalArgumentException("not a valid room type");
        }

        System.out.println(area);
    }
}
