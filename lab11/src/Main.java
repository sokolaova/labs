import java.lang.System;
import java.util.Scanner;

class Person{
    private int age;
    public String fullName;
    public String phoneNumber;
    public Person(int age, String fullName, String phoneNumber) {
        this.age = age;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
    }
    public int getAge() {
        return age;
    }

}
class Student extends Person{
    public int course;
    public String faculty;
    private int admissionYear;

    public Student(int age, String fullName, String phoneNumber, int course, String faculty, int admissionYear) {
        super (age, fullName, phoneNumber);
        this.course = course;
        this.faculty = faculty;
        this.admissionYear = admissionYear;

    }
    public int getAdmissionYear() {
        return admissionYear;
    }

}
public class Main {
    public static void main(String[] args) {
        Student[] students = new Student[3];

        students[0] =new Student(16, "Парвадов Павел", "89378267485", 2, "Информационные системы и программирование", 2022);
        students[1] =new Student(17, "Соколова Ольга", "89330285637", 2, "Информационные системы и программирование", 2022);
        students[2] =new Student(16, "Якушик Елизавета", "89632749305", 1, "Информационные системы и веб-разработка приложений", 2023);

        System.out.println("ФИО и возраст всех студентов:");
        for (Student student : students) {
            System.out.println(student.fullName+ ", "+ student.getAge() + " лет");

        }
        System.out.println();
        System.out.println("Введите факультет: ");
        Scanner input = new Scanner(System.in);
        String facultySearch = input.nextLine();

        System.out.println("Список студентов факультета " + facultySearch + ":");
        for (Student student : students) {
            if (student.faculty.equals(facultySearch)) {
                System.out.println(student.fullName);
            }
        }

        System.out.println();
        System.out.println("Введите год постпления: ");
        int admissionYearSearch = input.nextInt();

        System.out.println("Список студентов, поступивших после " + admissionYearSearch + " года:");
        for (Student student : students) {
            if (student.getAdmissionYear() >= admissionYearSearch) {
                System.out.println(student.fullName);
                }
            }
        }
    }
