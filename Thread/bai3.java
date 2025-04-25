 class bai3 {
    public static void main(String[] args) {
        thucan th = new thucan();
        daubep db = new daubep(th);
        khachhang kh = new khachhang(th);
        Thread t1 = new Thread(db);
        Thread t2 = new Thread(kh);
        t1.start();
        t2.start();
    }
}
class thucan {
    private int thucan = 0;

    public synchronized void nauan() {
        if (thucan <5) {
            thucan++;
            System.out.println("dang nau thuc an , thuc an con " +thucan);
            
            }
        }

    

    public synchronized void anuong() {

            if (thucan >0) {
                thucan--;
                System.out.println("khach hang dang an , thuc an con " + thucan);
                
                
            }


    }
}
class daubep implements Runnable{
    thucan th ;
    public  daubep(thucan th){
        this.th=th;
    }
    @Override
    public void run() {
        while(true){
            
        th.nauan();
        try{
                Thread.sleep(2000);
            }catch (InterruptedException e) {
                    e.printStackTrace();
            }
        }
    }
}
class khachhang implements Runnable{
    thucan th ;
public khachhang(thucan th){
    this.th=th;
}
    @Override
    public void run() {
        while(true){
            
        th.anuong();
        try{
                Thread.sleep(4000);
            }catch (InterruptedException e) {
                    e.printStackTrace();
            }
        }
    }
}