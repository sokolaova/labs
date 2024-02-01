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

        // Сортировка прямым способом
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (numbers[i] != 0) {
                numbers[index++] = numbers[i];
            }
        }
        while (index < size) {
            numbers[index++] = 0;
        }

        System.out.println("Отсортированный массив: " + Arrays.toString(numbers));
    }
}