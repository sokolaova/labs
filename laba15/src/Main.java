import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.String;

public class Main {
    public static void main(String[] args) {
        String text = "3.78.56.10 или 36.689.39.1";
        IPAddress(text);
    }

    public static void IPAddress(String text){
            String regex = "\\b(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\b";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);

            File ipishnic = new File("ipishnic1.txt");
            try(FileWriter fw = new FileWriter("ipishnic1.txt")){
            if (matcher.find()) {
                String found = "Найденные IP-адреса:";
                System.out.println(found);
                    System.out.println(matcher.group());
                    fw.write(found + matcher.group());

            }
            else{
                String notfound = "IP-адреса не найдены";
                fw.write(notfound);
                System.out.println(notfound);
            }
            }
            catch(IOException ex){
                ex.printStackTrace(System.out);
            }
    }
}