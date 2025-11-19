import java.util.Scanner;
import CIE.*;
import SEE.*;

public class FinalMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        External[] students = new External[n];
        Internals[] internalData = new Internals[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1) + ":");
            students[i] = new External();
            internalData[i] = new Internals();

            students[i].readDetails(sc);
            internalData[i].readMarks(sc);
            students[i].readMarks(sc);
        }

        System.out.println("\nFinal Marks of Students:");
        for (int i = 0; i < n; i++) {
            students[i].displayDetails();
            System.out.println("Course-wise Final Marks:");
            System.out.println("Cie marks:");
            for (int j = 0; j < 5; j++) {
                int finalMark = internalData[i].internalMarks[j];
                System.out.println("Course " + (j + 1) + ": " + finalMark);
            }
            System.out.println("See marks:");
            for (int j = 0; j < 5; j++) {
                int finalMark = students[i].seeMarks[j];
                System.out.println("Course " + (j + 1) + ": " + finalMark);
            }
            
            System.out.println();
        }

        sc.close();
    }
}