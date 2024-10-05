import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main {
    public static void main(String[] args) {
        String file = "something.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder text = new StringBuilder();
            String line;
            int wordCount = 0;
            int wordCountWithoutSpace = 0;
            int charCount = 0;


            // Читаем файл построчно
            while ((line = reader.readLine()) != null) {
                charCount += line.length(); // Увеличиваем счетчик символов
                wordCount += line.split("\\s+").length; // Увеличиваем счетчик слов
                text.append(line);
            }
            Pattern pattern = Pattern.compile("\\S"); // \S соответствует любому символу, кроме пробела
            Matcher matcher = pattern.matcher(text.toString());

                while (matcher.find()) {
                    wordCountWithoutSpace++;
                }

            //выводим статистику в конец файла
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.newLine(); // Добавляем новую строку перед записью
                writer.write("Статистика файла: " );
                writer.newLine();
                writer.write("Количество символов без пробелов: " + wordCountWithoutSpace);
                writer.newLine();
                writer.write("Количество слов: " + wordCount);
                writer.newLine();
                writer.write("Количество символов: " + charCount);
            }

            //выводим статистику на консоль
            System.out.println("Статистика файла: ");
            System.out.println("Количество символов без пробелов: " + wordCountWithoutSpace);
            System.out.println("Количество слов: " + wordCount);
            System.out.println("Количество символов: " + charCount);
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
