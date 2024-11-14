import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int totalNumbers = 10000; //количество случайных чисел для генерации
        int[] randomNumbers = generateRandomArray(totalNumbers); //генерация массива случайных целых чисел

        //выводим сгенерированные числа
        System.out.println("Сгенерированные случайные числа:");
        printArray(randomNumbers); //вызов метода для вывода массива

        int maxSquareSum = findMaxSquareSum(randomNumbers); //находим максимальную сумму квадратов двух элементов
        System.out.println("Максимальная сумма квадратов: " + maxSquareSum);
    }

    //метод для генерации массива случайных целых чисел
    private static int[] generateRandomArray(int count) {
        Random rand = new Random();
        int[] numbersArray = new int[count]; //массив для хранения сгенерированных чисел

        for (int index = 0; index < count; index++) {
            //генерация случайных чисел в диапазоне от -100 до 100
            numbersArray[index] = rand.nextInt(201) - 100;
        }
        return numbersArray;
    }

    //метод для вывода массива
    private static void printArray(int[] array) {
        for (int index = 0; index < array.length; index++) {
            System.out.print(array[index] + " ");
            //переход на новую строку после каждых 20 чисел
            if ((index + 1) % 20 == 0) {
                System.out.println();
            }
        }
        System.out.println(); //добавление пустой строки для разделения
    }

    //метод для нахождения максимальной суммы квадратов двух элементов
    public static int findMaxSquareSum(int[] numbers) {
        Arrays.sort(numbers); //сортируем массив

        //находим два наибольших элемента
        int largest = numbers[numbers.length - 1];
        int secondLargest = numbers[numbers.length - 11];

        //вычисляем сумму квадратов этих двух элементов
        return (largest * largest) + (secondLargest * secondLargest);
    }
}
