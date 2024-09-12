import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество элементов в массиве: ");
        int a = scanner.nextInt();
        int[] arr = new int[a];
        System.out.print("Введите элементы массива: ");
        for (int i = 0; i < a; i++) {
            arr[i] = scanner.nextInt();
        }


        int major = SearchMajor(arr);
        if (major > 0) {
            System.out.println("Мажоритарный элемент: " + major);
        }
        else{
            System.out.println("Мажоритарный элемент не найден");
        }
    }
    public static int SearchMajor(int arr[]){
        int x = 0;
        int count = 0;

        for (int number : arr){
            if (count == 0){
                x = number;
                count = 1;
            }
            else if (number == x) {
                count++;
            }
            else{
                count--;
            }
        }

        count = 0;
        for (int number : arr) {
            if (number == x) {
                count++;
            }
        }

        if (count > arr.length/2) {
            return x;
        }
        else{
            return 0;
        }

    }
}