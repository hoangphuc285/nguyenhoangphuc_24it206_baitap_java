


class count extends Thread{
    public count(){}
    public static void main(String[] args) {
        count a=new count();
        
        a.start();
    }
    public void run(){
        for(int i=10;i>=0;i--) {
            System.out.println(i);
            try{
            Thread.sleep(1000);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
