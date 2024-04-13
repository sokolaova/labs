import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.String;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите пароль: ");
        String text = input.next();
        Password(text); //вызов метода
    }

    public static void Password(String text) {
        String regex = "(\\S){8,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            String a = "[A-Z]"+ "[a-z]" + "\\!|\\#|\\$|\\%|\\(|\\)|\\*|\\+|\\_|\\-|\\=|\\?|\\[|\\]|\\{|\\}|\\||\\~";
            Pattern ap = Pattern.compile(a);
            Matcher am = ap.matcher(text);
            if (am.find()){
                boolean yesornot = false;
                for (int i = 0; i < text.length(); i++) {
                    if (i == 0 || Math.abs(text.charAt(i) - text.charAt(i - 1)) != 1) {
                        yesornot = true;
                    }
                }
                if (yesornot) {
                    System.out.println("true");
                }
                else{
                    System.out.println("false");
                }
            }
            else{
                System.out.println("false");
            }
        }
        else{
            System.out.println("false");
        }
    }
}