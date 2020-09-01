import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean ordered = false;
        int inputValue;
        ArrayList<Integer> inputList = new ArrayList<>();

        //populate our input into a List object
        while (scan.hasNextInt()) {
            inputValue = scan.nextInt();
            inputList.add(inputValue);
            if (inputValue == 0) break;
        }

        if (isOrdered(inputList, "asc") || isOrdered(inputList, "desc")) {
            ordered = true;
        }

        System.out.println(ordered);
    }

    private static boolean isOrdered(List<Integer> listOfNumbers, String direction) {
        if (listOfNumbers.isEmpty() || listOfNumbers.size() == 1) {
            return true;
        }

        Iterator<Integer> iter = listOfNumbers.iterator();
        Integer current, previous = iter.next();
        while (iter.hasNext()) {
            current = iter.next();
            if (current == 0) break;
            if (previous.compareTo(current) == 0) continue;
            if (direction.equals("asc")) {
                if (previous.compareTo(current) > 0) {
                    return false;
                }
            } else {
                if (previous.compareTo(current) < 0) {
                    return false;
                }
            }

            previous = current;
        }
        return true;
    }
}
