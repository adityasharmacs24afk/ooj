class WrongAgeException extends Exception {
    WrongAgeException(String msg) {
        super(msg);
    }
}


class father{
    int age;

    father (int age) throws  WrongAgeException {
        this.age = age;
        if (age < 0) {
            throw new WrongAgeException("Invalid age for father: " + age);
        }
    }
}



class son {
    int sage;
    son (int fatherage,int sage) throws WrongAgeException {
        
        
        if (sage < 0 || sage > fatherage) {
            throw new WrongAgeException("Invalid age for son: " + sage);
        }
    }
}

public class prog5 {
public static void main(String[] args) {
    try{
        father f= new father (50);
        son s = new son (50,60);
    }catch(WrongAgeException e){
        System.out.println(e.getMessage());
    }finally{
        System.out.println("End of Program");
    }
}
}
