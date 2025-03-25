import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This program reads a file of numbers, sorts them, and calculates the mean
 * and median of the numbers. The sorted array, mean, and median are then
 * written to an output file.
 * @author Tony Tran
 * @version 1.0
 * @since 2025-03-25
 */

final class ArraysL {
    /**
     * This is a private constructor to satisfy style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private ArraysL() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method to run the program.
     * @param array
     * @return mean
     */
    static float mean(final Integer[] array) {
        float sum = 0;
        // For each element in the array
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return (float) sum / array.length;
    }

    /**
     * This is the main method to run the program.
     * @param array
     * @return median
     */
    static float median(final Integer[] array) {
        // If the length of the array is even
        int length = array.length;
        if (length % 2 == 0) {
            return (float) (array[length / 2] + array[length / 2 - 1]) / 2;
        } else {
            return (float) array[length / 2];
        }
    }

    /**
     * This is the main method to run the program.
     * 
     * @param array
     * @return mode
     */
    static float mode(final Integer[] array) {
        // Initialize mode and maxCount
        int mode = 0;
        int maxCount = 0;
        // For each element in the array
        for (int i = 0; i < array.length; i++) {
            int count = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[j] == array[i]) {
                    count++;
                }
            }
            // If the count is greater than the maxCount
            if (count > maxCount) {
                maxCount = count;
                mode = array[i];
            }
        }
        return mode;
    }

    /**
     * This is the main method to run the program.
     * @param args
     */
    public static void main(final String[] args) throws Exception {
        // Create a Scanner object to read user input
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        File filePathSet = new File(args[0]);
        FileWriter outputFile = new FileWriter("output.txt");
        // Read the input file
        Scanner fileSet = new Scanner(filePathSet);
        // While there are still lines to read from the file
        while (fileSet.hasNextLine()) {
            // Read the next line from the file
            String line = fileSet.nextLine();
            String[] arrayOfStrings = line.split(" ");
            // For each string in the array
            for (String numString : arrayOfStrings) {
                int numInt = Integer.parseInt(numString);
                numbers.add(numInt);
            }
        }
        // Close scanners
        fileSet.close();
        // Convert the ArrayList to an array
        Integer[] numbersArray = numbers.toArray(new Integer[0]);
        // Sort the array
        Arrays.sort(numbersArray);
        // Print the sorted array
        System.out.println("The sorted array is: \n"
         + Arrays.toString(numbersArray));
        System.out.printf("The mean is: %.2f\n", mean(numbersArray));
        System.out.printf("The median is: %.2f\n", median(numbersArray));
        System.out.printf("The mode is: %.2f\n", mode(numbersArray));
        // Write the sorted array, mode, mean, and median to the output file
        outputFile.write("The sorted array is: \n"
                + Arrays.toString(numbersArray) + "\n");
        outputFile.write("The mean is: " + mean(numbersArray) + "\n");
        outputFile.write("The median is: " + median(numbersArray) + "\n");
        outputFile.write("The mode is: " + mode(numbersArray) + "\n");
        // Close the output file
        outputFile.close();
    }
}
