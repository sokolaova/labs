import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        for (int i = 0; i<3; i++) { //3 раза создаем и убиваем процесс
            try{
            // указываем в конструкторе ProcessBuilder, что нужно запустить программу ls с параметрами -l /dev
            ProcessBuilder procBuilder = new ProcessBuilder();
            procBuilder.command("notepad.exe");
            Process process = procBuilder.start(); // запуск программы
                try {
                    Thread.sleep(1000); //ждем
                } catch (InterruptedException ex) {
                }
                process.destroy(); //убиваем процесс
        }
        catch (IOException e)
            {
                e.printStackTrace();
            }


        }
    }
}

