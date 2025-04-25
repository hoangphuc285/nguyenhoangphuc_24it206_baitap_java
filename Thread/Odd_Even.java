import java.lang.Thread;
class Printer {
    
    private boolean ok=false;
    synchronized void printEven(int number){
        while(!ok){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(number);
        ok=false;
        notify();
    }
    synchronized void printOdd(int number){
        while(ok){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(number);
        ok=true;
        notify();
    }
    
}
class Odd implements Runnable{
    private  int max;
    private  String name;
    private  Printer printer;
     Odd(String name,Printer printer, int max) {
        this.name=name;
        this.printer = printer;
        this.max = max;
    }
    public String getName(){
        return this.name;
    }
    public void run(){
        for(int i=1;i<=max;i+=2){
            
            printer.printOdd(i);
        }
    }
}
class Even implements Runnable{
    private  int max;
    private  String name;
    private  Printer printer;
     Even(String name,Printer printer, int max) {
        this.name=name;
        this.printer = printer;
        this.max = max;
    }
    public String getName(){
        return this.name;
    }
    public void run(){
    for(int i=2;i<=max;i+=2){
        
        printer.printEven(i);
    }
    }
}
class Odd_Even{
    public static void main(String[] args) {
        Printer print=new Printer();
        Odd odd=new Odd("Con 1: ",print,10);
        Even even=new Even("Con 2: ",print,10);
        Thread oddThread=new Thread(odd);
        Thread evenThread=new Thread(even);
        
        evenThread.start();
        oddThread.start();
    }
}
