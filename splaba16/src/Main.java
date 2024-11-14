import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String file = "C:\\Users\\User\\IdeaProjects\\splaba16\\xxx.txt"; //путь к файлу
        int maxLengthX = findLongestX(file);

        //результат
        if (maxLengthX > 0) {
            System.out.println("Длина самой длинной последовательности 'x': " + maxLengthX);
        } else {
            System.out.println("Символ 'x' не найден в файле");
        }
    }

    private static int findLongestX(String file) {
        StringBuilder fileContent = new StringBuilder(); //создаем строку для содержимого файла

        //читаем содержимое файла в строку
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                fileContent.append(currentLine); //добавляем каждую строку к содержимому
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }

        //регулярка для поиска последовательностей 'x'
        Pattern xPattern = Pattern.compile("x+");
        Matcher xMatcher = xPattern.matcher(fileContent.toString());

        int longestX = 0; //переменная для хранения максимальной длины

        //ищем все последовательности 'x' и определяем максимальную длину
        while (xMatcher.find()) {
            longestX = Math.max(longestX, xMatcher.group().length()); //обновляем максимальную длину
        }

        return longestX; //возвращаем максимальную длину
    }
}
