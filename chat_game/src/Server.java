import java.io.*;
import java.net.*;
import java.util.*;
import java.util.regex.Pattern;

public class Server {
    private static final int PORT = 8080;
    private static final List<String> words = new ArrayList<>();
    private static Socket player1Socket;
    private static Socket player2Socket;
    private static PrintWriter player1Out;
    private static PrintWriter player2Out;
    private static BufferedReader player1In;
    private static BufferedReader player2In;

    public static void main(String[] args) throws IOException {
        loadWords();
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Сервер запущен...");

        // Подключение двух игроков
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
        // Загрузка слов из файла
        try (BufferedReader br = new BufferedReader(new FileReader("words.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void startGame() throws IOException {
        int player1Score = 0;
        int player2Score = 0;

        while (true) {
            String word = getRandomWord();
            player1Out.println("Ваше слово: " + word); // Скрытое сообщение для Игрока 1
            player2Out.println("Игрок 1 загадал слово. Угадайте его!");

            final Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    player1Out.println("Время вышло! Загаданное слово: " + word);
                    player2Out.println("Время вышло! Загаданное слово: " + word);
                }
            }, 30000); // 30 секунд на угадывание

            // Цикл для объяснений от Игрока 1
            String explanation;
            while ((explanation = player1In.readLine()) != null) {
                player2Out.println("Игрок 1 объясняет: " + explanation); // Вывод объяснений игрока 1
            }

            // Угадывание от Игрока 2 в отдельном потоке
            boolean guessedCorrectly = handleGuessing(word, timer);

            if (!guessedCorrectly) {
                player1Out.println("Игрок 2 не угадал слово. Загаданное слово было: " + word);
                player2Out.println("Вы не угадали слово. Загаданное слово было: " + word);
            }

            player1Out.println("Счет: Игрок 1 - " + player1Score + ", Игрок 2 - " + player2Score);
            player2Out.println("Счет: Игрок 1 - " + player1Score + ", Игрок 2 - " + player2Score);

            // Спрашиваем, хотят ли игроки сыграть еще раз
            player1Out.println("Хотите сыграть еще раз? (да/нет)");
            player2Out.println("Хотите сыграть еще раз? (да/нет)");

            String playAgainPlayer1 = player1In.readLine();
            String playAgainPlayer2 = player2In.readLine();

            // Обработка ответа на вопрос о новой игре
            if (!playAgainPlayer1.equalsIgnoreCase("да") || !playAgainPlayer2.equalsIgnoreCase("да")) {
                player1Out.println("Игра окончена! Спасибо за игру!");
                player2Out.println("Игра окончена! Спасибо за игру!");
                break; // Выход из цикла, если игроки не хотят играть снова
            }
            // Если игроки хотят сыграть снова, счет обнуляется и игра начинается заново
            player1Score = 0;
            player2Score = 0;
        }
    }

    private static boolean handleGuessing(String word, Timer timer) throws IOException {
        String guess = "";
        boolean guessedCorrectly = false;
        while ((guess = player2In.readLine()) != null) {
            player1Out.println("Игрок 2 пытается угадать: " + guess); // Вывод догадки игрока 2

            // Сравнение с загаданным словом с помощью регулярных выражений
            if (Pattern.compile(Pattern.quote(guess), Pattern.CASE_INSENSITIVE).matcher(word).matches()) {
                // Если игрок 2 угадал слово
                player1Out.println("Игрок 2 угадал слово: " + word);
                player2Out.println("Вы угадали слово: " + word);
                guessedCorrectly = true;
                timer.cancel(); // Остановить таймер
                break; // Прерываем цикл
            }

            player2Out.println("Неправильный ответ: " + guess);
        }
        return guessedCorrectly;
    }

    private static String getRandomWord() {
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }
}
