class A extends Thread{
    public void run (){
        while(true){
            System.out.println("BMS");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
            }
        }
    }
}

class B extends Thread{
    public void run (){
        while(true){
            System.out.println("CSE");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
        }
    }
}

public class prog6 {
    public static void main(String[] args) {
        A t1=new A();
        B t2=new B();
        t1.start();
        t2.start();
    }

}
