import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        String filename = "C:\\Users\\Igor\\intidea\\splaba13\\data.txt";
        List<Pair> pairs = readPairsFromFile(filename);

        int maxSum = getMaxSumNotDivisibleBy3(pairs);
        System.out.println(maxSum);
    }

    private static List<Pair> readPairsFromFile(String filename) {
        List<Pair> pairs = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] numbers = line.split(" ");
                if (numbers.length == 2) {
                    int first = Integer.parseInt(numbers[0]);
                    int second = Integer.parseInt(numbers[1]);
                    pairs.add(new Pair(first, second));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pairs;
    }

    private static int getMaxSumNotDivisibleBy3(List<Pair> pairs) {
        AtomicInteger maxSum = new AtomicInteger(0);
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        for (Pair pair : pairs) {
            executor.submit(() -> {
                // Вычисление сумм с выбором каждого числа из пары
                int sum1 = maxSum.get() + pair.first;
                int sum2 = maxSum.get() + pair.second;

                // Обновление максимальной суммы
                if (sum1 % 3 != 0) {
                    maxSum.updateAndGet(v -> Math.max(v, sum1));
                }
                if (sum2 % 3 != 0) {
                    maxSum.updateAndGet(v -> Math.max(v, sum2));
                }
            });
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            // Ожидание завершения всех потоков
        }

        return maxSum.get();
    }
}
