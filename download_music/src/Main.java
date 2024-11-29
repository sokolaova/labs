import java.awt.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class Main {

    public static void main(String[] args) {
        String audio = "C:\\Users\\User\\Documents\\оллля\\шаражкина контора\\sohraneniya\\audio.mp3";
        String photo = "C:\\Users\\User\\Documents\\оллля\\шаражкина контора\\sohraneniya\\photo.jpeg";
        String video = "C:\\Users\\User\\Documents\\оллля\\шаражкина контора\\sohraneniya\\video.mp4";
        File audioFile = new File(audio);
        File photoFile = new File(photo);
        File videoFile = new File(video);

        Thread audioThread = new Thread(() -> {
            downloadFile(
                    "https://zvukipro.com/uploads/files/2019-05/1559045711_24b0d8ed4ae4cb2.mp3", audioFile);
        });

        Thread photoThread = new Thread(() -> {
            downloadFile(
                    "https://tengrinews.kz/userdata/news/2024/news_555280/thumb_b/photo_494419.jpeg", photoFile);
        });

        Thread videoThread = new Thread(() -> {
        downloadFile(
                "https://v3.cdnpk.net/videvo_files/video/free/2012-11/large_preview/MVI_1482.mp4?token=exp=1729349403~hmac=06c566924f5b1aad7fa947676b47d7e7ddd4d97f97923d398a44221eaafb49c0", videoFile);
        });

        long timeParallelno = System.nanoTime();

        audioThread.start();
        photoThread.start();
        videoThread.start();

        try {
            audioThread.join();
            photoThread.join();
            videoThread.join();
            System.out.println("время при параллельном: " + (System.nanoTime() - timeParallelno)/1000000.0 + " миллисекунд");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Загрузка файлов завершена.");

        openFile(photoFile);
        openFile(audioFile);
        openFile(videoFile);

    }

    public static void downloadFile(String fileURL, File output) {
        try {
            URLConnection conn = new URL(fileURL).openConnection();
            InputStream is = conn.getInputStream();
            OutputStream os = new FileOutputStream(output);

            byte[] buffer = new byte[4096];
            int length;

            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }

            os.close();
            is.close();
            System.out.println("Файл " + output + " успешно загружен.");
        } catch (IOException e) {
            System.err.println("Ошибка при скачивании " + output + ": " + e.getMessage());
        }
    }

    public static void openFile(File file) {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(file);
            } else {
                System.err.println("Desktop не поддерживается.");
            }
        } catch (IOException e) {
            System.err.println("Ошибка при открытии файла " + file + ": " + e.getMessage());
        }
    }
}
