package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String ENCRYPT_OPERATION = "enc";
    private static final String DECRYPT_OPERATION = "dec";
    private static final String SHIFT_ALGORITHM = "shift";
    private static final String UNICODE_ALGORITHM = "unicode";
    private static final String MODE_ARG_NAME = "-mode";
    private static final String DATA_ARG_NAME = "-data";
    private static final String KEY_ARG_NAME = "-key";
    private static final String INFILE_ARG_NAME = "-in";
    private static final String OUTFILE_ARG_NAME = "-out";
    private static final String ALG_ARG_NAME = "-alg";

    private static String retrieveInput(List<String> arguments) {
        StringBuilder input = new StringBuilder();
        if (arguments.contains(DATA_ARG_NAME) && arguments.contains(INFILE_ARG_NAME)) {
            input.append(arguments.get(arguments.indexOf(DATA_ARG_NAME) + 1));
        } else if (arguments.contains(DATA_ARG_NAME)) {
            input.append(arguments.get(arguments.indexOf(DATA_ARG_NAME) + 1));
        } else if (arguments.contains(INFILE_ARG_NAME)) {
            try {
                File file = new File(arguments.get(arguments.indexOf(INFILE_ARG_NAME) + 1));
                Scanner scanner = new Scanner(file);
                while (scanner.hasNext()) {
                    input.append(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("Error: There was a problem reading the input file");
            }
        }
        return input.toString();
    }

    private static void generateOutput(List<String> arguments, String operationResult) {
        if (arguments.contains(OUTFILE_ARG_NAME)) {
            try {
                File file = new File(arguments.get(arguments.indexOf(OUTFILE_ARG_NAME) + 1));
                FileWriter writer = new FileWriter(file);
                writer.write(operationResult);
                writer.close();
            } catch (IOException e) {
                System.out.println("Error: There was a problem generating the output file");
                e.printStackTrace();
            }
        } else {
            System.out.println(operationResult);
        }
    }

    public static void main(String[] args) {
        List<String> arguments = Arrays.asList(args);
        String algorithmType = arguments.contains(ALG_ARG_NAME) ?
                arguments.get(arguments.indexOf(ALG_ARG_NAME) + 1) : SHIFT_ALGORITHM;
        String operation = arguments.contains(MODE_ARG_NAME) ?
                arguments.get(arguments.indexOf(MODE_ARG_NAME) + 1) : ENCRYPT_OPERATION;
        String input = retrieveInput(arguments);
        int key = arguments.contains(KEY_ARG_NAME) ?
                Integer.parseInt(arguments.get(arguments.indexOf(KEY_ARG_NAME) + 1)) : 0;

        CryptoAlgorithm algorithm = algorithmType.equals("unicode") ? new UnicodeAlgorithm() :
            new ShiftAlgorithm();

        if (operation.equals(ENCRYPT_OPERATION)) {
            generateOutput(arguments, algorithm.encrypt(input, key));
        } else if (operation.equals(DECRYPT_OPERATION)) {
            generateOutput(arguments, algorithm.decrypt(input, key));
        } else {
            System.out.println("Error: An unsupported operation was provided...");
        }
    }
}
