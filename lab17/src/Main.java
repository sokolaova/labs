import java.io.*;
import java.util.Scanner;
class Calc implements Serializable {
    private double x;
    private double result;

    public Calc(double x) {
        this.x = x;
        this.result = calculate();
    }

    public double calculate() {
        return x - Math.sin(x);
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите x: ");
        Calc calculator = new Calc(input.nextDouble());
        System.out.println("x = " + calculator.getX() + " y = " + calculator.getResult());


        while (true) {
            System.out.println("Введите: save (сохранить состояние) или upload (загрузить) или result (найти результат) или finish (закончить) или new (установить новый x)");
            String choose = input.next();

            if (choose.equals("finish")) {
                System.out.println("Завершено");
                break;
            }
        switch (choose) {
            case ("save"):
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("state.txt"))) {
                    oos.writeObject(calculator);
                    System.out.println("Состояние объекта сохранено в файл: " + "state.txt");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case ("upload"):
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("state.txt"))) {
                    calculator = (Calc) ois.readObject();
                    System.out.println("Состояние объекта загружено из файла: " + "state.txt");
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case ("result"):
                System.out.println("x = " + calculator.getX() + " y: " + calculator.calculate());
                break;
            case ("new"):
                System.out.println("Введите новый x: ");
                calculator.setX(input.nextDouble());
                break;
            default:
                System.out.println("Завершено");
                break;
        }
        }
    }
}
