import java.util.Scanner;
abstract class shape{
    Scanner sc=new Scanner(System.in);
    abstract void printarea();
}

class rectangle extends shape{
    int length;
    int breath;

    @Override
    void printarea() {
        System.out.println("entred the length of rectangle");
        this.length = sc.nextInt();
        System.out.println("entered the breadth of rectangle");
        this.breath = sc.nextInt();
        System.out.println("the area of rectangle is: "+length*breath);

    }
    
}

class circle extends shape{
    float radius;
    @Override
    void printarea(){
        System.out.println("enter the radius of circle");
        this.radius=sc.nextFloat();
        System.out.println("the area of circle is :"+3.14*2*this.radius);
    }
}

class triangle extends shape{
    int base;
    int height;
    @Override
    void printarea(){
        System.out.println("enter the base and height of triangle");
        this.base=sc.nextInt();
        this.height=sc.nextInt();
        System.out.println("the area of triangle is: "+this.base*this.height/2);
    }
}

public class prog3 {
    public static void main(String[] args) {
        triangle t=new triangle();
        t.printarea();
        circle c=new circle();
        c.printarea();
        rectangle r=new rectangle();
        r.printarea();
        
    }
}
