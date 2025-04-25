import java.io.*;
class Bai3 extends Thread{
    public static void main(String[] args) {
        Bai3 thread=new Bai3();
        thread.start();
    }
    public void run(){
        String fileInput = "C:\\Users\\LENOVO\\Desktop\\input1.txt";
        String fileOutput="C:\\Users\\LENOVO\\Desktop\\output3.txt";
         try  {
            BufferedReader reader = new BufferedReader(new FileReader(fileInput));
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutput));
            String line;

            while((line=reader.readLine())!=null) {
                writer.write(line);
                writer.newLine(); // Xuống dòng
            

            }
            writer.flush();

            System.out.println("Sao chép file thành công!");


        } catch(IOException  e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}
//