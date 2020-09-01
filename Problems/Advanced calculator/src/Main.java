import java.util.ArrayList;
import java.util.Collections;

/* Please, do not rename it */
class Problem {
    static final String MAX_OPERATOR = "MAX";
    static final String MIN_OPERATOR = "MIN";
    static final String SUM_OPERATOR = "SUM";

    public static void main(String[] args) {
        String operator = args[0];
        // write your code here
        ArrayList<Integer> sequence = new ArrayList<Integer>();
        for (int i = 1; i < args.length; i++) {
            sequence.add(Integer.parseInt(args[i]));
        }
        Collections.sort(sequence);

        if (operator.toUpperCase().equals(MAX_OPERATOR)) {
            System.out.println(sequence.get(sequence.size() - 1));
            return;
        }

        if (operator.toUpperCase().equals(MIN_OPERATOR)) {
            System.out.println(sequence.get(0));
        }

        if (operator.toUpperCase().equals(SUM_OPERATOR)) {
            System.out.println(calculateSum(sequence));
        }
    }

    private static int calculateSum(ArrayList<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }
}
