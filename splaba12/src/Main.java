import java.util.Random;
import java.util.Scanner;

class BankAccount {
    private double currentBalance;

    // пополнение счета
    public synchronized void addBalance(double amount) {
        currentBalance += amount;
        System.out.printf("Баланс +%.2f. Текущий: %.2f%n", amount, currentBalance);
        notifyAll(); // уведомляем о новом балансе
    }

    // снятие средств
    public synchronized void withdrawal(double amount) throws InterruptedException {
        while (currentBalance < amount) {
            System.out.println("Недостаточно средств");
            wait(); // ждем пополнения
        }

        currentBalance -= amount;

        System.out.printf("Снято: %.2f. Остаток: %.2f%n", amount, currentBalance);
    }

    // текущий баланс
    public synchronized double getCurrentBalance() {
        return currentBalance;
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Внести или снять (1 или 2, 0 для выхода): ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Выход из программы.");
                break; // выход из цикла и завершение программы
            }
            switch (choice) {
                case 1:
                    System.out.print("Какую сумму Вы бы хотели внести: ");
                    double addAmount = scanner.nextDouble();
                    Thread adderThread = new Thread(() -> {
                        account.addBalance(addAmount);
                        try {
                            Thread.sleep(700); // задержка пополнения
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    });
                    adderThread.start();
                    break;
                case 2:
                    System.out.print("Какую сумму Вы бы хотели снять: ");
                    double withdrawalAmount = scanner.nextDouble();
                    try {
                        Thread.sleep(3000); // ожидание перед снятием
                        account.withdrawal(withdrawalAmount); // попытка снятия
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    break;

                default:
                    System.out.println("Некорректный выбор");
                    continue;
            }
        }
        // финальный баланс
        System.out.printf("Остаток: %.2f%n", account.getCurrentBalance());
    }
}
