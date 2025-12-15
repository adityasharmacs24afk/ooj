import java.util.Scanner;                   
class classbooks{
    Scanner sc = new Scanner(System.in);
    int a;
    String name;
    String author;
    int price;
    int num_pages;

    classbooks[] book;

    public void storebooks(){
        System.out.println("Enter the number of books");
        this.a=sc.nextInt();
        classbooks[] book=new classbooks[a];
        this.book=book;

    }
    void set(){
        for(int i=0;i<a;i++){
            book[i]=new classbooks();
            System.out.println("Enter the name of the book");
            book[i].name=sc.next();
            System.out.println("Enter the author of the book");
            book[i].author=sc.next();
            System.out.println("Enter the price of the book");
            book[i].price=sc.nextInt();
            System.out.println("Enter the number of pages in the book");
            book[i].num_pages=sc.nextInt();
            
            

        }

    }

    void get(){
        for(int j=0;j<a;j++)
        System.out.println(book[j].name+" "+book[j].author+" "+book[j].price+" "+book[j].num_pages);
    }

    public String toString(int a){
        return "The name of the book is "+book[a-1].name+"\nThe author of the book is "+book[a-1].author+"\nPrice of the book is "+book[a-1].price+"\nNumber of pages in the book are "+book[a-1].num_pages;
    }


}


public class prog2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        classbooks obj=new classbooks();
        obj.storebooks();
        obj.set();
        obj.get();
        System.out.println("type the book id of which you want the details of:");
        int num=sc.nextInt();
        System.out.println(obj.toString(num));
    }


}
