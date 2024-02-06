import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = 20;
        int[] numbers = new int[size];

        // Ввод элементов массива
        for (int i = 0; i < size; i++) {
            System.out.print("Введите число: ");
            numbers[i] = input.nextInt();
        }

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (numbers[j] == 0 && numbers[j + 1] != 0) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }

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
}