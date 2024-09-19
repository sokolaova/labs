import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int withSummary(int num1, int num2){
        int result = 0;
        for (int i = 0; i<num2; i++){
             result += num1;
        }
        return result;
    }

    public static int withDivision(int num1, int num2){
        double num1converted = (double) num1;
        double num2converted = (double) num2;
        double result = num1converted/(1.0/num2converted);
        return (int) result;
    }

    public static int withArray(int num1, int num2) {
        int result = 0;
        int[] array = new int[num2];
        Arrays.fill(array, num1);
        for (int i = 0; i < num2; i++) {
            result += array[i]; // Сложение значений в массиве
        }
        return result;
    }

    public static int withRecursion(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        else {
            return num1 + withRecursion(num1, num2 - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int num1 = scanner.nextInt();

        System.out.print("Введите второе число: ");
        int num2 = scanner.nextInt();

        System.out.println("Выберите способ умножения (1 - через сложение; 2 - через деление; 3 - через массив; 4 - через рекурсию): ");
        int select = scanner.nextInt();
        int goal;
        switch (select){
            case 1:
                goal = withSummary(num1, num2);//умножения через сложение
                break;
            case 2:
                goal = withDivision(num1, num2);//умножения через деление
                break;
            case 3:
                goal = withArray(num1, num2);//умножения через массив
                break;
            case 4:
                goal = withRecursion(num1,num2) - num1;//рекурсивное умножение
                break;
            default:
                System.out.println("Некорректный выбор.");//если выбор некорректный, сообщение об ошибке
                return;
        }
        System.out.println("Результат: " + goal);
        }
    }
