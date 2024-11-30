import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Считываем количество выпиленных клеток
        System.out.println("Введите количество выпиленных клеток: ");
        int amount = scanner.nextInt();
        int[][] board = new int[8][8];
        System.out.println("Введите координаты через пробел: ");
        // Считываем координаты выпиленных клеток
        for (int i = 0; i < amount; i++) {
            System.out.print((i+1) + " клетка: ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            board[row][col] = 1;
        }

        int perimeter = 0;

        // проходимся по массиву
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (board[row][col] == 1) { // Если клетка выпилена, проверяем каждую из 4 сторон
                    // Вверх
                    if (row == 0 || board[row - 1][col] == 0) {
                        perimeter++;
                    }
                    // Вниз
                    if (row == 7 || board[row + 1][col] == 0) {
                        perimeter++;
                    }
                    // Влево
                    if (col == 0 || board[row][col - 1] == 0) {
                        perimeter++;
                    }
                    // Вправо
                    if (col == 7 || board[row][col + 1] == 0) {
                        perimeter++;
                    }
                }
            }
        }

        // Выводим результат
        System.out.println(perimeter);
    }
}
