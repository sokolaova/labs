import java.io.*;

public class Main {

    public static void main(String[] args) {
        File if1 = new File("if1.txt");
        File if2 = new File("if2.txt");
        File of1 = new File("of1.txt");
        File of2 = new File("of2.txt");

        long timePosledovatelno = System.nanoTime();

        try {
            copyFileUsingStream(if1, if2);
            copyFileUsingStream(if2, of1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("время при последовательном: " + timePosledovatelno + " миллисекунд");

        Thread thread1 = new Thread(() -> {
            try {
                copyFileUsingStream(if1, of1);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                copyFileUsingStream(if2, of2);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        long timeParallelno = System.nanoTime();

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
            System.out.println("время при параллельном: " + (System.nanoTime() - timeParallelno)/1000000.0 + " миллисекунд");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


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

