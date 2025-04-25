class Table {
    private int sum=0;
    private boolean ok=false;
    
    public Table(){}
    public synchronized void eat(){   
            try{
            while(sum==0){
            
                   
                wait();
            }
                
                sum--;
                System.out.println("Khach hang da an 1, con lai "+ sum);
                notify();
            
                
            }catch (InterruptedException e) {
                    e.printStackTrace();
            }
        
    }
    public synchronized void cook(){
        
            try{
                while(sum>=5){
                        
                wait();
                        
                }
            
                sum++;
                System.out.println("Da nau 1,con lai "+sum);
                notify();
            
                
            
            }catch (InterruptedException e) {
                    e.printStackTrace();
            }
        }
    
}
class Cook implements Runnable{
    Table table=new Table();
    public Cook(Table table){
        this.table=table;
    }
    public void run(){
        while (true){
            table.cook();
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e) {
                    e.printStackTrace();
            }
        }
            
        
    }
}
class Eat implements Runnable{
    Table table=new Table();
    public Eat(Table table){
        this.table=table;
    }
    public void run(){
        while(true){
            table.eat();
            try{
                Thread.sleep(4000);
            }catch (InterruptedException e) {
                    e.printStackTrace();
            }
        }
        
    }
}
class Main {
    public static void main(String[] args) {
        Table t=new Table();
        Thread e=new Thread(new Eat(t));
        Thread c=new Thread(new Cook(t));
        e.start();
        c.start();
    }
}