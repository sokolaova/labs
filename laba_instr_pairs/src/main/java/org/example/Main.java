package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "17.txt";
        try {
            List<Integer> numbers = readFile(filePath);
            int min3DivBy7 = findMin3DivBy7();
            int min4 = findMin4(numbers);

            int count = 0;
            int maxSum = Integer.MIN_VALUE;

            for (int i = 0; i < numbers.size() - 1; i++) {
                int a = numbers.get(i);
                int b = numbers.get(i + 1);

                if ((a < min3DivBy7 || b < min3DivBy7) &&
                        (a * b) % 10 == min4 % 10) {
                    count++;
                    maxSum = Math.max(maxSum, a + b);
                }
            }

            System.out.println(count + " " + maxSum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Integer> readFile(String filePath) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                numbers.add(Integer.parseInt(line.trim()));
            }
        }
        return numbers;
    }

    private static int findMin3DivBy7() {
        for (int i = 100; i <= 999; i++) {
            if (i % 7 == 0) {
                return i;
            }
        }
        return -1; // Этот случай невозможен, так как числа, делящиеся на 7, существуют
    }

    private static int findMin4(List<Integer> numbers) {
        int min4 = Integer.MAX_VALUE;
        for (int number : numbers) {
            if (number >= 1000 && number < min4) {
                min4 = number;
            }
        }
        return min4;
    }
}
