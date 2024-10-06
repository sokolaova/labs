import java.util.Scanner;

public class Main {

    // метод для подсчета максимального количества шоколадок
    private static int calcMaxChoco(int money, int price, int wraps) {
        // начальное количество шоколадок
        int totalChoco = money / price;
        int currentWraps = totalChoco;

        // обмен оберток на шоколадки
        while (currentWraps >= wraps) {
            int newChocolates = currentWraps / wraps; // новые шоколадки
            totalChoco += newChocolates; // обновление Total шоколадок
            currentWraps = newChocolates + (currentWraps % wraps); // обновление оберток
        }

        return totalChoco;
    }

    // метод для проверки ввода данных


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // получение входных данных с проверкой
        System.out.print("Введите имеющиеся деньги: ");
        int money = scanner.nextInt();

        System.out.print("Введите цену за шоколадку: ");
        int price = scanner.nextInt();

        System.out.print("Введите количество оберток, нужное для получения еще одной шоколадки: ");
        int wraps = scanner.nextInt();
        // вычисление максимального количества шоколадок
        int maxChocolates = calcMaxChoco(money, price, wraps);

        // вывод результата
        System.out.println("максимальное количество шоколадок: " + maxChocolates);
    }
}
