import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите время начала работы часов (в формате 'часы минуты'): ");
        String[] fromTime = scanner.nextLine().split(" ");
        int fromHour = Integer.parseInt(fromTime[0]);
        int fromMinute = Integer.parseInt(fromTime[1]);

        System.out.println("Введите время конца работы часов (в формате 'часы минуты'): ");
        String[] toTime = scanner.nextLine().split(" ");
        int toHour = Integer.parseInt(toTime[0]);
        int toMinute = Integer.parseInt(toTime[1]);

        // Преобразуем время в минуты
        int fromInMinutes = inMinute(fromHour, fromMinute);
        int toInMinutes = inMinute(toHour, toMinute);

        // переход на следующий день (добавляем 24 часа (1440 минут))
        if (toInMinutes <= fromInMinutes) {
            toInMinutes += 1440;
        }

        System.out.println(strikes(fromInMinutes, toInMinutes));
    }
    public static int inMinute(int hour, int minute){
        int inMinute = hour * 60 + minute;
        return inMinute;

    }
    public static int strikes(int startMinutes, int endMinutes){
        int totalAmount = 0;

        for (int currentMinutes = startMinutes; currentMinutes < endMinutes; currentMinutes++) {
            int currentHour = (currentMinutes / 60) % 12; // Получаем час в 12-часовом формате
            if (currentHour == 0) currentHour = 12; // Если час 0, то это 12

            // Удары в начале часа
            if (currentMinutes % 60 == 0) {
                totalAmount += currentHour;
            }
            // Удары в середине часа
            if (currentMinutes % 60 == 30) {
                totalAmount += 1;
            }
        }
        return totalAmount;
    }
}
