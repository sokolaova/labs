//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

interface Product {
    void Name();
    void Price();
    void Rating();
}


class Clothes implements Product {
     String name;
     double price;
     int rating;

    Clothes (String name, double price, int rating){
        this.name = name;
        this.price = price;
        this.rating = rating;

    }

    @Override
    public void Name() {
        System.out.println("Название: " + name);
    }

    @Override
    public void Price() {
        System.out.println("Цена: " + price);
    }

    @Override
    public void Rating() {
        System.out.println("Оценка: " + rating);
    }
}

class Books implements Product {
     String name;
     double price;
     int rating;

    Books (String name, double price, int rating){
        this.name = name;
        this.price = price;
        this.rating = rating;

    }

    @Override
    public void Name() {
        System.out.println("Название: " + name);
    }

    @Override
    public void Price() {
        System.out.println("Цена: " + price);
    }

    @Override
    public void Rating() {
        System.out.println("Оценка: " + rating);
    }
}

class Electronics implements Product {
     String name;
     double price;
     int rating;

    Electronics (String name, double price, int rating){
        this.name = name;
        this.price = price;
        this.rating = rating;
    }
    @Override
    public void Name() {
        System.out.println("Название: " + name);
    }

    @Override
    public void Price() {
        System.out.println("Цена: " + price);
    }

    @Override
    public void Rating() {
        System.out.println("Оценка: " + rating);
    }
}


interface User {
    void Login();

    void Password();
}


class Mama implements User {
     String login;
     String password;

    Mama(String login, String password){
        this.login = login;
        this.password = password;
    }
    @Override
    public void Login() {
        System.out.println("Логин: " + login);

    }

    @Override
    public void Password() {
        System.out.println("Пароль: " + password);
    }
}

class Papa implements User {
     String login;
     String password;

    Papa(String login, String password){
        this.login = login;
        this.password = password;
    }
    @Override
    public void Login() {
        System.out.println("Логин: " + login);

    }

    @Override
    public void Password() {
        System.out.println("Пароль: " + password);
    }
}

class Kid implements User {
     String login;
     String password;

    Kid(String login, String password){
        this.login = login;
        this.password = password;
    }
    @Override
    public void Login() {
        System.out.println("Логин: " + login);

    }

    @Override
    public void Password() {
        System.out.println("Пароль: " + password);
    }
}


class Shopping implements Product, User {
     String name;
     double price;
     int rating;
     String login;
     String password;

    Shopping(String name, double price, int rating, String login, String password){
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.login = login;
        this.password = password;
    }

    @Override
    public void Name() {
        System.out.println("Название: " + name);
    }

    @Override
    public void Price() {
        System.out.println("Цена: " + price);
    }

    @Override
    public void Rating() {
        System.out.println("Оценка: " + rating);
    }

    @Override
    public void Login() {
        System.out.println("Логин: " + login);

    }

    @Override
    public void Password() {
        System.out.println("Пароль: " + password);
    }

    public void ShoppingOf() {
        System.out.println("Пользователь " + login + " купил товар " + name);
    }
}

public class Main {
    public static void main(String[] args) {
        Clothes cloth = new Clothes("футболка", 799.99, 5);
        Books book = new Books("Тимур и его команда", 300.0, 5);
        Electronics electronic = new Electronics("фен", 4999.0, 4);

        Mama mama = new Mama("tractorina1970", "vy80589y");
        Papa papa = new Papa("pendil1970", "jhwcf0476h687");
        Kid kid = new Kid("govoryukrutoy2010", "hve9654vh");

        Shopping shopping = new Shopping(book.name, book.price, book.rating, kid.login, kid.password);
        shopping.ShoppingOf();
    }
}
