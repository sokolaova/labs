class Person {
    String firstName;
    String lastName;
    int birthYear;

    public Person(String firstName, String lastName, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }

    public void printInfo() {
        System.out.println("Имя: " + firstName);
        System.out.println("Фамилия: " + lastName);
        System.out.println("Год рождения: " + birthYear);
    }
}

class Car {
    String brand;
    int productionYear;
    double engineCapacity;

    public Car(String brand, int productionYear, double engineCapacity) {
        this.brand = brand;
        this.productionYear = productionYear;
        this.engineCapacity = engineCapacity;
    }

    public void printInfo() {
        System.out.println("Марка: " + brand);
        System.out.println("Год выпуска: " + productionYear);
        System.out.println("Объем двигателя: " + engineCapacity);
    }
}

class Book {
    String title;
    String author;
    int publicationYear;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public void printInfo() {
        System.out.println("Название: " + title);
        System.out.println("Автор: " + author);
        System.out.println("Год выпуска: " + publicationYear);
    }

    public void read(Person person, Car car) {
        System.out.println(person.firstName + " читает книгу " + title + " про машину " + car.brand);
    }
}

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Иван", "Иванов", 2006);
        Car car = new Car("Mazda", 2023, 2.0);
        Book book = new Book("Mazda - гениальность вне времени", "Киитиро масада", 2020);

        person.printInfo();
        System.out.println();
        car.printInfo();
        System.out.println();
        book.printInfo();
        System.out.println();
        book.read(person, car);
    }
}
