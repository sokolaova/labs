import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = 20;
        int[] numbers = new int[size];

// Ввод элементов массива
        for (int i = 0; i < size; i++) {
            System.out.print("Введите число: ");
            numbers[i] = scanner.nextInt();
        }

        combSort(numbers);
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (numbers[i] !=0) {
                count++;
            }}

        int[] nums = new int[count];
        for (int i = 0; i < count; i++) {
            nums[i]=numbers[i];
        }
        System.out.println("Отсортированный массив: " + Arrays.toString(nums));
    }

    public static void combSort(int[] arr) {
        int step = arr.length;
        double factor = 1.247;
        boolean sorted = false;

        while (!sorted) {
            step = (int) (step / factor);
            if (step <= 1) {
                step = 1;
                sorted = true;
            }

            for (int i = 0; i + step < arr.length; i++) {
                if (arr[i] == 0 && arr[i + step] != 0) {
                    int temp = arr[i];
                    arr[i] = arr[i + step];
                    arr[i + step] = temp;
                }
            }
        }
    }
}
