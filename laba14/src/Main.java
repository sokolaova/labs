import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.String;

public class Main {
    public static void main(String[] args) {
        String text = "3.78.56.10 или 36.689.39.1"; //ввод текста
        IPAddress(text); //вызов метода
    }

    public static void IPAddress(String text) {
        String regex = "\\b(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\b";/*
        регулярное выражение
        String s; */
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Найденные корректные IP-адреса:");
        while (matcher.find()) {
            System.out.println(matcher.group()); //вывод найденных айпи-адресов
        }
    }
}