import java.io.*;
class Bai1 extends Thread{
    public static void main(String[] args) {
        Bai1 t=new Bai1();
        t.start();
    }
    public void run(){
        String fileInput = "C:\\Users\\LENOVO\\Desktop\\input1.txt";
         try  {
            BufferedReader reader = new BufferedReader(new FileReader(fileInput));
            String line;

            while((line=reader.readLine())!=null) {
                System.out.println(line);
            

            }

        } catch(IOException  e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}
//