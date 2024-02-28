import java.lang.System;
import java.util.Scanner;
class Reader {
    String fullName;
    int ticketNumber;
    String faculty;
    String dateOfBirth;
    String phoneNumber;

    public Reader(String fullName, int ticketNumber, String faculty, String dateOfBirth, String phoneNumber) {
        this.fullName = fullName;
        this.ticketNumber = ticketNumber;
        this.faculty = faculty;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
    }

    public void takeBook(int numberOfBooks) {
        System.out.println(fullName + " взял " + numberOfBooks + " книги.");
    }

    public void takeBook(String... bookNames) {
        System.out.print(fullName + " взял книги: ");
        for (String bookName : bookNames) {
            System.out.print(bookName + ", ");
        }
        System.out.println();
    }

    public void returnBook(int numberOfBooks) {
        System.out.println(fullName + " вернул " + numberOfBooks + " книги.");
    }

    public void returnBook(String... bookNames) {
        System.out.print(fullName + " вернул книги: ");
        for (String bookName : bookNames) {
            System.out.print(bookName + ", ");
        }
        System.out.println();
    }
}
public class Main {
    public static void main(String[] args) {
        Reader[] readers = new Reader[5];
        readers[0] = new Reader("Иванов Иван", 12345, "IT", "01.01.2000", "123456789");
        readers[1] = new Reader("Петров Василий", 23456, "Medicine", "05.05.1998", "987654321");
        readers[2] = new Reader("Сидорова Ольга", 34567, "Economics", "10.10.1995", "555555555");
        readers[3] = new Reader("Козлов Николай", 45678, "Education", "15.03.1997", "777777777");
        readers[4] = new Reader("Смирнова Анна", 56789, "Art", "20.12.1999", "999999999");

        System.out.println("Существующие пользователи на данный момент: 12345, 23456, 34567, 45678, 56789");
        System.out.println("Введите номер читательского билета: ");
        Scanner input = new Scanner(System.in);
        int nticket = input.nextInt();;

            switch (nticket) {
                case 12345:
                    readers[0].takeBook(3);
                    readers[0].takeBook("Приключения", "Словарь", "Энциклопедия");
                    break;
                case 23456:
                    readers[1].returnBook(5);
                    readers[1].returnBook("Повести", "Роман", "Стихи", "Мифы Древней Греции", "Рассказы");
                    break;
                case 34567:
                    readers[2].takeBook(2);
                    readers[2].takeBook("Словарь", "Энциклопедия");
                    break;
                case 45678:
                readers[3].returnBook(1);
                readers[3].returnBook("Стихи серебрянного века");
                    break;
                case 56789:
                    readers[4].takeBook(4);
                    readers[4].takeBook("Денискины рассказы", "Толковый словарь", "Мифы Древней Греции");
                    break;
                default:
                    System.out.println("К сожалению читателя нашей библиотеки с таким номером читательского билета нет");
                    break;
            }


    }
}
