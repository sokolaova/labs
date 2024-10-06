public class Main {

    // класс потока для вывода сообщения "Курица"
    static class ChickenThread extends Thread {
        @Override
        public void run() {
            System.out.println("Курица");
        }
    }

    // класс потока для вывода сообщения "Яйцо"
    static class EggThread extends Thread {
        @Override
        public void run() {
            System.out.println("Яйцо");
        }
    }

    public static void main(String[] args) {
        // создаем экземпляры потоков
        ChickenThread chicken = new ChickenThread();
        EggThread egg = new EggThread();

        // запускаем потоки
        chicken.start();
        egg.start();

        try {
            // ждем завершения обоих потоков
            chicken.join();
            egg.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // определяем, какой поток завершился последним, и выводим результат спора
        if (chicken.isAlive()) {
            System.out.println("Курица!");
        } else if (egg.isAlive()) {
            System.out.println("Яйцо!");
        } else {
            System.out.println("Спор имеет философскую идею...");
        }
    }
}
