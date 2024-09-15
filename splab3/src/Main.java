import java.util.*;
public class Main {
    // Метод для сортировки пузырьком
    public static void bubbleSort(int[][] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Сравниваем второй столбец
                if (array[j][1] < array[j + 1][1]) {
                    // Меняем местами строки
                    int[] temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
                final int ALL_PAIRS = 16; //константа, содержащая максимальное количество участвующих пар

                Scanner scanner = new Scanner(System.in);

                System.out.print("Введите количество пришедших sms-сообщений: ");//количество сообщений-голосов
                int numberOfVotes = scanner.nextInt();

                //создание массива для хранения голосов
                int[][] votes = new int[ALL_PAIRS][2];

                for (int i = 0; i < ALL_PAIRS; i++) {
                    votes[i][0] = i+1;
                }

                System.out.println("Проголосуйте за номер пары от 1 до 16:");
                for (int i = 0; i < numberOfVotes; i++) {
                    int pairNumber = scanner.nextInt(); //номер пары
                    if (pairNumber >= 1 && pairNumber <= ALL_PAIRS) { //проверка корректности ввода
                        votes[pairNumber-1][1]++; //прибавляем голос конкретной пары
                    } else {
                        System.out.println("Некорректный номер пары: " + pairNumber);
                    }
                }

                // пузырьковая сортировка
                bubbleSort(votes);

                //вывод
                for (int[] oneOf : votes) {
                    System.out.println("Пара под номером " + oneOf[0] + ": " + oneOf[1] + " голоса(-ов)");
                }
            }


}
