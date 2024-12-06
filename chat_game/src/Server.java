import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class Server {
    private static final int PORT = 8080;
    private static final List<String> words = new ArrayList<>();
    private static Socket player1Socket;
    private static Socket player2Socket;
    private static PrintWriter player1Out;
    private static PrintWriter player2Out;
    private static BufferedReader player1In;
    private static BufferedReader player2In;
    private static ScheduledExecutorService scheduler;

    public static void main(String[] args) throws IOException {
        loadWords();
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Сервер запущен...");

        player1Socket = serverSocket.accept();
        player1Out = new PrintWriter(player1Socket.getOutputStream(), true);
        player1In = new BufferedReader(new InputStreamReader(player1Socket.getInputStream()));
        System.out.println("Игрок 1 подключен: " + player1Socket.getInetAddress());

        player2Socket = serverSocket.accept();
        player2Out = new PrintWriter(player2Socket.getOutputStream(), true);
        player2In = new BufferedReader(new InputStreamReader(player2Socket.getInputStream()));
        System.out.println("Игрок 2 подключен: " + player2Socket.getInetAddress());

        startGame();
    }

    private static void loadWords() {
        try (BufferedReader br = new BufferedReader(new FileReader("words.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getRandomWord() {
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }

    private static void startGame() throws IOException {
        int player1Score = 0;
        int player2Score = 0;

        while (true) {
            String word = getRandomWord();
            player1Out.println("Ваше слово: " + word);
            player2Out.println("Игрок 1 загадал слово. Угадайте его!");

            scheduler = Executors.newScheduledThreadPool(1);
            Runnable task = () -> {
                try {
                    player1Out.println("Время вышло! Загаданное слово: " + word);
                    player2Out.println("Время вышло! Загаданное слово: " + word);
                } catch (Exception e) {
                    System.err.println("Error sending timeout message: " + e.getMessage());
                }
                scheduler.shutdown();
            };

            ScheduledFuture<?> scheduledFuture = scheduler.schedule(task, 30, TimeUnit.SECONDS);

            new Thread(() -> {
                try {
                    String explanation;
                    while ((explanation = player1In.readLine()) != null) {
                        player2Out.println("Игрок 1 объясняет: " + explanation);
                    }
                } catch (IOException e) {
                    System.err.println("Error receiving explanation from Player 1: " + e.getMessage());
                }
            }).start();

            boolean guessedCorrectly = handleGuessing(word, scheduledFuture);

            if (!guessedCorrectly) {
                player1Out.println("Игрок 2 не угадал слово. Загаданное слово было: " + word);
                player2Out.println("Вы не угадали слово. Загаданное слово было: " + word);
            } else {
                player1Score++;
                player2Out.println("Вы угадали слово! Хотите сыграть еще раз? (да/нет)");
                player1Out.println("Игрок угадал слово! Хотите сыграть еще раз? (да/нет)");
                String response = player2In.readLine();

                if (response.equalsIgnoreCase("да")) {
                    continue; // Перезапуск игры
                } else {
                    player1Out.println("Вы закончили игру. Спасибо за участие!");
                    player2Out.println("Вы закончили игру. Спасибо за участие!");
                    break; // Завершение игры
                }
            }
        }
    }

    private static boolean handleGuessing(String word, ScheduledFuture<?> scheduledFuture) {
        try {
            String guess;
            while ((guess = player2In.readLine()) != null) {
                player1Out.println("Игрок 2 думает: " + guess);
                if (guess.equalsIgnoreCase(word)) {
                    player2Out.println("Вы угадали слово: " + word);
                    scheduledFuture.cancel(false);
                    return true;
                }
                // Если игрок 2 не угадал, можно добавить дополнительную логику
            }
        } catch (IOException e) {
            System.err.println("Error receiving guess from Player 2: " + e.getMessage());
        }
        return false;
    }
}
