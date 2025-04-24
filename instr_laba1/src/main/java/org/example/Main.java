package org.example;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
//код с ошибками
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ok = new Scanner(System.out);
        System.out.println("введите длинну массива");
        int n = ok.nextLine();
        System.out.println("заполните массив");
        int[] num = new int[n];
        for (int i = 0; i < n; i+=2) {
            num[i] = ok.nextLine();
        }
        System.out.println("ваш массив: " + Array(num));
        System.out.println("Мажоритарный элемент: " + findMajorityElement(num[i]));
    }

    public static int findMajorityElement(int[] num) {
        int green = 0;
        int count;

        // Найти возможного кандидата на мажоритарный элемент
        for (int i = 1; i <= num.length; i++) {
            if (count == 1) {
                green = num[i];//присвоение текущего элемента
            }
            if (num[i]==green){
                count++;
            }
            else{
                count--;
            }
        }

        count = 0;
        for (int i = 0; i <= num.length; i++) {
            if (num[i] == green) {
                count++;
            }
        }
        int result = green / count;
        if (count>num.length/2){
            return result;
        }
    }
}
*/


//код с логами исправленный

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {

        Scanner ok = new Scanner(System.in);
        LOGGER.info("Программа запущена.");

        System.out.println("введите длину массива");
        int n = ok.nextInt();
        LOGGER.info("Длина массива: " + n);

        System.out.println("заполните массив");
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = ok.nextInt();
            LOGGER.info("Элемент массива [" + i + "]: " + num[i]);
        }

        System.out.println("ваш массив: " +  Arrays.toString(num));
        LOGGER.info("Массив: " + Arrays.toString(num));

        int majorityElement = findMajorityElement(num);
        System.out.println("Мажоритарный элемент: " + majorityElement);
        LOGGER.info("Мажоритарный элемент: " + majorityElement);
    }

    public static int findMajorityElement(int[] num) {
        LOGGER.info("Поиск мажоритарного элемента начат.");
        int green = 0;
        int count = 0;

        // Найти возможного кандидата на мажоритарный элемент
        for (int i = 0; i < num.length; i++) {
            if (count == 0) {
                green = num[i]; // присвоение текущего элемента
                LOGGER.info("Кандидат на мажоритарный элемент: " + green);
            }
            if (num[i] == green) {
                count++;
                LOGGER.info("Увеличение счетчика для элемента " + green + ": " + count);
            } else {
                count--;
                LOGGER.info("Уменьшение счетчика для элемента " + green + ": " + count);
            }
        }

        count = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] == green) {
                count++;
            }
        }
        LOGGER.info("Количество вхождений кандидата: " + count);

        if (count > num.length / 2) {
            LOGGER.info("Мажоритарный элемент найден: " + green);
            return green;
        } else {
            LOGGER.info("Мажоритарный элемент не найден.");
            return 0;
        }
    }
}
