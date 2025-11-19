package SEE;

import CIE.Personal;

public class External extends Personal {
    public int[] seeMarks = new int[5];

    public void readMarks(java.util.Scanner sc) {
        System.out.println("Enter SEE Marks for 5 courses:");
        for (int i = 0; i < 5; i++) {
            seeMarks[i] = sc.nextInt();
        }
    }
}