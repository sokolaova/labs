//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
interface User {
    void Login();
    void Password();

}

abstract class People implements User {
    String name;
    int age;
    String position;
    String login;
    String password;

    public People(String name, int age, String position, String login, String password) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.login = login;
        this.password = password;

    }
}

class Teacher extends People {
    public Teacher(String name, int age, String position, String login, String password) {
        super(name, age, position, login, password);
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

class Student extends People {
    public Student(String name, int age, String position, String login, String password) {
        super(name, age, position, login, password);
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

public class Main {
    public static void main(String[] args) {

        Teacher teacher1 = new Teacher("Пузренков Александр Николаевич", 36, "Преподаватель по программированию", "puzrenkov", "ny54b3nvcb5t38");
        Teacher teacher2 = new Teacher("Никишина Ольга Викторовна", 45, "Преподаватель по экономике", "id280670844", "8b4wb83nn038y");

        Student student1 = new Student("Лекарева Олеся Сергеевна", 17, "Студент", "lekareva", "n457n8405");
        Student student2 = new Student("Соколова Ольга Игоревна", 17, "Студент", "sokolaaa_", "bwo876456");

        System.out.println("Преподаватели: " + teacher1.name);
        teacher1.Login();
        teacher1.Password();
        System.out.println(teacher2.name);
        teacher2.Login();
        teacher2.Password();;
        System.out.println("Студенты: " + student1.name);
        student1.Login();
        student1.Password();
        System.out.println(student2.name);
        student2.Login();
        student2.Password();
    }
}
