import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

class Student {
    private static student[] students;

    private static class student{
        char name[] = new char[10];
        double gpa;
        int studentID;
    }

    private static void Init(int n){
        students = new student[n];
        Random ra = new Random();
        for(int i = 0; i <n ; i++){
            students[i] = new student();
            students[i].gpa = ra.nextDouble()*4.0;
            students[i].studentID = n-i;
            String name = "student" +i;
            char[] charName = name.toCharArray();
            System.arraycopy(charName, 0, students[i].name, 0, charName.length);
        }
    }

    private static void sortGPA(){
        for(int i=0;i<students.length;i++){
            double temp = students[i].gpa;
            int work = i;
            student flag = students[i];
            for(int j=i;j<students.length;j++){
                if (students[j].gpa<temp){
                    temp = students[j].gpa;
                    work = j;
                    flag = students[j];
                }
            }
            students[work] = students[i];
            students[i] = flag;
        }
        printStudents();
    }

    private static void sortSID(){
        for(int i=0;i<students.length;i++){
            int temp = students[i].studentID;
            int work = i;
            student flag = students[i];
            for(int j=i;j<students.length;j++){
                if (students[j].studentID<temp){
                    temp = students[j].studentID;
                    work = j;
                    flag = students[j];
                }
            }
            students[work] = students[i];
            students[i] = flag;
        }
        printStudents();
    }

    private static void printStudents(){
        for (Student.student student : students) {
            out.println("name:" + String.copyValueOf(student.name) +
                "\tgpa:" + student.gpa + "\tstudentID:" + student.studentID);
        }
    }

    public static void main(String[] args){
        out.print("Input students' number:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Init(n);
        printStudents();
        out.println("Sort by gpa:");
        sortGPA();
        out.println("Sort by SID:");
        sortSID();
    }
}
