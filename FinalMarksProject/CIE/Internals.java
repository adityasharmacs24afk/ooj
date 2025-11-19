package CIE;

public class Internals {
    public int[] internalMarks = new int[5];

    public void readMarks(java.util.Scanner sc) {
        System.out.println("Enter Internal Marks for 5 courses:");
        for (int i = 0; i < 5; i++) {
            internalMarks[i] = sc.nextInt();
        }
    }
}