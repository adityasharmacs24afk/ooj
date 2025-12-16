/*package CIE;*/

import java.util.Scanner;

/* -------- Personal Class -------- */
class Personal {

    int usn;
    String name;
    int sem;

    static int num;                 
    Scanner sc = new Scanner(System.in);

    Personal[] pdetails;

    public void Plist() {
        System.out.println("Enter the number of students");
        num = sc.nextInt();
        pdetails = new Personal[num];
    }

    public void info() {
        for (int i = 0; i < num; i++) {

            pdetails[i] = new Personal();

            System.out.println("Enter the USN");
            pdetails[i].usn = sc.nextInt();

            System.out.println("Enter the Name");
            pdetails[i].name = sc.next();

            System.out.println("Enter the Semester");
            pdetails[i].sem = sc.nextInt();
        }
    }
}

/* -------- Internal Class -------- */
class Internal extends Personal {

    int marks1, marks2, marks3, marks4, marks5;
    Internal[] marksdetails;

    public void marksinfo() {

        marksdetails = new Internal[num];

        for (int i = 0; i < num; i++) {

            marksdetails[i] = new Internal();

            System.out.println("Enter marks of subject 1");
            marksdetails[i].marks1 = sc.nextInt();

            System.out.println("Enter marks of subject 2");
            marksdetails[i].marks2 = sc.nextInt();

            System.out.println("Enter marks of subject 3");
            marksdetails[i].marks3 = sc.nextInt();

            System.out.println("Enter marks of subject 4");
            marksdetails[i].marks4 = sc.nextInt();

            System.out.println("Enter marks of subject 5");
            marksdetails[i].marks5 = sc.nextInt();
        }
    }
}

/* -------- Main Class -------- */
public class prog4 {

    public static void main(String[] args) {

        Personal p = new Personal();
        p.Plist();
        p.info();

        Internal i = new Internal();
        i.marksinfo();
    }
}
