package main.java;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().calculateFibonacci(12));
    }

    private int greatestCommonDivisor(int num1, int num2) {
        if (num1 < 0 || num2 < 0) {
            throw new IllegalArgumentException("Both Arguments need to be positive.");
        }
        if (num1 == 0 || num2 == 0) {
            return num1 == 0 ? num2 : num1;
        }

        if (num1 == num2) {
            return num1;
        }

        int largestOfTheTwoArgs = 0;
        int smallestOfTheTwoArgs = 0;
        if (num1 > num2) {
            largestOfTheTwoArgs = num1;
            smallestOfTheTwoArgs = num2;
        } else {
            largestOfTheTwoArgs = num2;
            smallestOfTheTwoArgs = num1;
        }
        ArrayList<Integer> factorsOfLargestNum = getFactors(largestOfTheTwoArgs);
        System.out.println("factorsOfLargestNum: " + factorsOfLargestNum.toString());
        ArrayList<Integer> factorsOfSmallestNum = getFactors(smallestOfTheTwoArgs);
        System.out.println("factorsOfSmallestNum: " + factorsOfSmallestNum.toString());

        Set<Integer> commonFactors = new HashSet<Integer>(factorsOfLargestNum);
        commonFactors.retainAll(factorsOfSmallestNum);
        Object[] arr = commonFactors.toArray();
        Arrays.sort(arr);
        return (Integer) arr[commonFactors.size() - 1];

    }

    private ArrayList<Integer> getFactors(int num) {
        ArrayList<Integer> factors = new ArrayList<Integer>();

        int currentFactor = 1;
        do {
            if (num % currentFactor == 0) {
                factors.add(currentFactor);
            }
            currentFactor += 1;
        } while (currentFactor <= num);

        return factors;
    }

    private ArrayList<Integer> calculateFibonacci(int numberOfResults) {
        if (numberOfResults <= 0) {
            throw new IllegalArgumentException("The number of results desired has to be greater than 0.");
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        int currentNumber = 0;
        int previousNumber = 1;
        for (int i = 0; i < numberOfResults; i++) {
            int localCurrentNum = currentNumber;
            list.add(localCurrentNum);
            localCurrentNum = currentNumber + previousNumber;
            previousNumber = currentNumber;
            currentNumber = localCurrentNum;
        }
        return list;
    }
}
