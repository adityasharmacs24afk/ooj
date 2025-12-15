import java.util.Scanner;
class student{
    Scanner sc=new Scanner(System.in);
    String usn;
    String name;
    int [] marks=new int[5];
    int [] credits = new int[5];
    int sum;
    int sumc;

    public void student(String usn , String name) {

        this.usn=usn;
        this.name=name;
        this.marks=marks;
        this.credits=credits;

        for(int j=0;j<5;j++){
            System.out.println("Type your subjects marks");
            this.marks[j]=sc.nextInt();
            System.out.println("Type your subjects credit");
            this.credits[j]=sc.nextInt();                                           
        }
    }

    void cal(){

        for(int i=0;i<5;i++){
            sum=sum+(marks[i]*credits[i]);
            sumc=sumc+credits[i];

        }

        System.out.println("the sgpa is : "+(sum/sumc)/10);
    }




    

    


}




public class prog1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        System.out.println("type your name");
        String name=sc.next();
        System.out.println("type your usn");
        String usn=sc.next();
        student s1=new student();
        s1.student(usn, name);
        s1.cal();


    }
}