import java.lang.System;
import java.util.Scanner;

class Student {
    private String fullName;
    private int admissionYear;
    private String address;
    private String phoneNumber;
    private int course;
    private String faculty;

    public Student(String fullName, int admissionYear, String address, String phoneNumber, int course, String faculty) {
        this.fullName = fullName;
        this.admissionYear = admissionYear;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.course = course;
        this.faculty = faculty;
    }

    public String getfullName() {
        return fullName;
    }

    public void setfullName(String fullName) {
        this.fullName = fullName;
    }

    public int getadmissionYear() {
        return admissionYear;
    }

    public void setadmissionYear(int admissionYear) {
        this.admissionYear = admissionYear;
    }

    public String getaddress() {
        return address;
    }

    public String getphoneNumber() {
        return phoneNumber;
    }

    public void setphoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getcourse() {
        return course;
    }

    public void setcourse(int course) {
        this.course = course;
    }

    public String getfaculty() {
        return faculty;
    }

    public void setfaculty(String faculty) {
        this.faculty = faculty;
    }
}

public class Main {
    public static void main(String[] args) {

       Student[] students = new Student[4];
        students[0] = new Student("Крянин Иван", 2022, "ул. Кирова, д.3", "89267351839", 2, "Информационные системы и программирование");
        students[1] =new Student("Парвадов Павел", 2022, "ул. Лермонтова, д.55", "89368267483", 2, "Информационные системы и программирование");
        students[2] =new Student("Лекарева Олеся", 2022, "ул. Антонова, д.47", "85173849274", 2, "Информационные системы и программирование");
        students[3] =new Student("Якушик Елизавета", 2023, "пр. Строителей, д.120", "89273845103", 1, "Информационные системы и веб-разработка приложений");

        System.out.println("ФИО всех студентов:");
        for (Student student : students) {
            System.out.println(student.getfullName());
        }
        System.out.println();
        System.out.println("Введите факультет: ");
        Scanner input = new Scanner(System.in);
        String facultySearch = input.nextLine();

        System.out.println("Список студентов факультета " + facultySearch + ":");
        for (Student student : students) {
            if (student.getfaculty().equals(facultySearch)) {
                System.out.println(student.getfullName());
            }
        }
        System.out.println();
        System.out.println("Введите год постпления: ");
        Scanner inputt = new Scanner(System.in);
        int admissionYearSearch = inputt.nextInt();

        System.out.println("Список студентов, поступивших после " + admissionYearSearch + " года:");
        for (Student student : students) {
            if (student.getadmissionYear() >= admissionYearSearch) {
                System.out.println(student.getfullName());
            }
        }
    }
}
