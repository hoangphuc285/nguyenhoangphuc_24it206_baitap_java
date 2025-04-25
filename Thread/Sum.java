import java.util.Random;

class S1 extends Thread{
    private int n;
    private int result=1;
    
    public S1(int n) {
        this.n=n;
    }
    public void run(){
        for (int i = 1; i <= n; i++) {
                result*= i;
            }
    }
    public static int getResult(){
        return result;
    }
}
class S2 extends Thread{
    private int n;
    private int result=1;
    
    public S1(int n) {
        this.n=n;
    }
    public void run(){
        for (int i = 1; i <= n; i++) {
                result+= i;
            }
    }
    public static int getResult(){
        return result;
    }
}
class S3 extends Thread{
    private int n;
    private int result=1;
    
    public S1(int n) {
        this.n=n;
    }
    public void run(){
        for (int i = 1; i <= n; i++) {
                if(i%2==0) result+= i;
            }
    }
    public static int getResult(){
        return result;
    }
}
class Sum {
    public static void main(String[] args) {
        System.out.println("Nhap n");
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        S1 s1=new S1(n);
        S2 s2=new S2(n);
        S3 s3=new S3(n);
        s1.start;
        s2.start;
        s3.start;

        s1.join();
        s2.join();
        s3.join();

        System.out.println("Ket qua: "+(s1.getResult+s2.getResult+s3.getResult));
        
    }
    
}