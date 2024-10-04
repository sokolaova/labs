
class AnimalThread extends Thread {
    private final String animalName;
    private final int priority; //начальный приоритет для потока
    private static volatile boolean hasWinner = false; //флаг, указывающий, есть ли уже победитель
    private static String winnerName;

    private static final int DISTANCE = 100;

    public AnimalThread(String animalName, int priority) {
        this.animalName = animalName;
        this.priority = priority;
        setName(animalName); //присваиваем имя потоку
        setPriority(priority); //устанавливаем приоритет потока
    }

    @Override
    public void run() {
        int distanceCovered = 0; //инициализация переменной, отслеживающей пройденное расстояние

        while (distanceCovered < DISTANCE) { //пока дистанция не достигнута
            //случайным образом увеличиваем пройденное расстояние на от 1 до 10 метров
            distanceCovered += (int) (Math.random() * 10) + 1;
            System.out.printf("%s пробежал: %d метров.%n", animalName, distanceCovered);
            //регулируем приоритет потока в зависимости от пройденной дистанции
            adjustPriority(distanceCovered);

        }
        if (!hasWinner) {
            hasWinner = true; //устанавливаем флаг победителя
            winnerName = animalName; //запоминаем имя победителя
        }
    }

    private void adjustPriority(int distance) {
        if (distance < 33) {
            setPriority(Thread.MAX_PRIORITY); //увеличиваем приоритет, если поток пробежал менее 33 метров
        } else if (distance < DISTANCE) {
            setPriority(Thread.MIN_PRIORITY); //снижаем приоритет, если поток пробежал от 33 до 100 метров
        }
    }

    public static String getWinner() {
        return winnerName; //метод для получения имени победителя
    }
}

public class Main {
    public static void main(String[] args) {
        //два потока, которые будут участвовать в гонке
        AnimalThread Rabbit = new AnimalThread("кролик", Thread.NORM_PRIORITY);
        AnimalThread Turtle = new AnimalThread("черепашка", Thread.NORM_PRIORITY);

        Rabbit.start();
        Turtle.start();

        try {
            Rabbit.join(); //ждём завершения потока кролика
            Turtle.join(); //ждём завершения потока черепахи
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("победитель: " + AnimalThread.getWinner());
    }
}
