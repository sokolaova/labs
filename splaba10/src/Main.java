import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // получение входных данных с проверкой
        System.out.print("Введите текст для файла somethingFrom.txt: ");
        String text = scanner.nextLine();
        File inputFile = new File("somethingFrom.txt");
        File outputFile = new File("somethingTo.txt");
        try {
            Files.write(inputFile.toPath(), text.getBytes());
            copyFileUsingStream(inputFile, outputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.print("Проверьте файл somethingTo.txt");
    }
        private static void copyFileUsingStream (File source, File dest) throws IOException {
            InputStream is = null;
            OutputStream os = null;
            try {
                is = new FileInputStream(source);
                os = new FileOutputStream(dest);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    os.write(buffer, 0, length);
                }
            } finally {
                is.close();
                os.close();
            }
        }
    }
