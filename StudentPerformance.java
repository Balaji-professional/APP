import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    int[] marks = new int[3];
    double attendance;
}

public class StudentPerformance {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Student[] students = new Student[5];

        // Input details
        for (int i = 0; i < 5; i++) {

            students[i] = new Student();

            System.out.println("Student " + (i + 1));

            System.out.print("Roll Number: ");
            students[i].rollNo = sc.nextInt();

            System.out.print("Name: ");
            students[i].name = sc.next();

            System.out.println("Enter marks in 3 subjects:");

            for (int j = 0; j < 3; j++) {
                students[i].marks[j] = sc.nextInt();
            }

            System.out.print("Attendance: ");
            students[i].attendance = sc.nextDouble();

            System.out.println();
        }

        double highestAverage = 0;
        String highestStudent = "";

        // Calculate and display results
        for (int i = 0; i < 5; i++) {

            int total = 0;

            for (int j = 0; j < 3; j++) {
                total = total + students[i].marks[j];
            }

            double average = total / 3.0;

            String result = (average >= 50) ? "Pass" : "Fail";

            String scholarship =
                    (average >= 75 && students[i].attendance >= 80)
                    ? "Eligible" : "Not Eligible";

            String performance =
                    (average >= 85) ? "Excellent" : "Good";

            System.out.println("Student Roll Number: " + students[i].rollNo);
            System.out.println("Student Name: " + students[i].name);
            System.out.println("Total Marks: " + total);
            System.out.println("Average Marks: " + average);
            System.out.println("Result: " + result);
            System.out.println("Scholarship: " + scholarship);
            System.out.println("Performance: " + performance);
            System.out.println("---------------------------");

            if (average > highestAverage) {
                highestAverage = average;
                highestStudent = students[i].name;
            }
        }

        System.out.println("Highest Average Student: " + highestStudent);
        System.out.println("Highest Average: " + highestAverage);

        sc.close();
    }
}