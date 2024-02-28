import java.lang.System;

class Student {
    String fullName;
    String groupNumber;
    int[] grades;

    public Student(String fullName, String groupNumber, int[] grades) {
        this.fullName = fullName;
        this.groupNumber = groupNumber;
        this.grades = grades;
    }

    public double middleGrade() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }


}
public class Main {
    public static void main(String[] args) {
        Student[] students = new Student[10];

        students[0] = new Student("Крянин И.И.", "Группа 22ИТ17", new int[]{4, 3, 5, 4, 4});
        students[1] = new Student("Парвадов П.П.", "Группа 22ИТ17", new int[]{5, 5, 5, 5, 5});
        students[2] = new Student("Соколова С.С.", "Группа 22ИТ17", new int[]{5, 4, 5, 4, 5});
        students[3] = new Student("Лекарева Е.В.", "Группа 22ИТ17", new int[]{5, 4, 5, 5, 4});
        students[4] = new Student("Бобров М.А.", "Группа 22ИТ17", new int[]{2, 2, 2, 2, 4});
        students[5] = new Student("Кузнецов А.С.", "Группа 22ИТ17", new int[]{5, 5, 5, 4, 3});
        students[6] = new Student("Воронова Д.И.", "Группа 22ИТ17", new int[]{4, 4, 4, 3, 4});
        students[7] = new Student("Новикова Е.Н.", "Группа 22ИТ17", new int[]{5, 5, 5, 5, 5});
        students[8] = new Student("Михайлюк О.О.", "Группа 22ИТ17", new int[]{4, 3, 4, 5, 4});
        students[9] = new Student("Файзутдинова В.В.", "Группа 22ИТ17", new int[]{5, 5, 4, 5, 4});


        for (int i = 0; i < 10 - 1; i++) {
            for (int j = 0; j < 10 - i - 1; j++) {
                if (students[j].middleGrade() > students[j + 1].middleGrade()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;

                }
            }
        }
        for (Student student : students) {
            System.out.println("ФИО: " + student.fullName + "средний балл: " + student.middleGrade());
        }
        System.out.println("Студенты с оценками 4 и 5:");
        for (Student student : students) {
            for (int grade : student.grades) {
                if (grade >= 4) {
                    System.out.println("Фамилия: " + student.fullName + ", Номер группы: " + student.groupNumber);
                    break;
                }
            }
        }
    }
}

