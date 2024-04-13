import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.String;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        String regex = "\\/\\/.*?$";
        String regexp = "\\/\\*(.|/n)*?\\*\\/";
        Pattern pattern = Pattern.compile(regex);
        Pattern patternp = Pattern.compile(regexp);

        try (BufferedReader skomment = new BufferedReader(new FileReader("code.txt"))) {
            String s;
            BufferedWriter bezkomment = new BufferedWriter(new FileWriter("codenew.txt"));
            while ((s = skomment.readLine()) != null) {
                Matcher matcher = pattern.matcher(s);
                while (matcher.find()) {
                    s = matcher.replaceAll(" ");
                }
                bezkomment.write(s);
                bezkomment.flush();
            }


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (BufferedReader skommentp = new BufferedReader(new FileReader("codenew.txt"))) {
            String i;
            BufferedWriter bezkommentp = new BufferedWriter(new FileWriter("codenewp.txt"));
            while ((i = skommentp.readLine()) != null) {
                Matcher matcherp = patternp.matcher(i);
                while (matcherp.find()) {
                    i = matcherp.replaceAll(" ");
                }
                bezkommentp.write(i);
                bezkommentp.flush();
            }


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}