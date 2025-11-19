package CIE;

public class Personal {
    public String usn;
    public String name;
    public int sem;

    public void readDetails(java.util.Scanner sc) {
        System.out.print("Enter USN: ");
        usn = sc.next();
        System.out.print("Enter Name: ");
        name = sc.next();
        System.out.print("Enter Semester: ");
        sem = sc.nextInt();
    }

    public void displayDetails() {
        System.out.println("USN: " + usn + ", Name: " + name + ", Semester: " + sem);
    }
}