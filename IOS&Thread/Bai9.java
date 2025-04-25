import java.io.*;
import java.util.*;

class Bai9 extends Thread{
    public static void main(String[] args) {
        Bai9 thread=new Bai9();
        thread.start();
    }
    public void run(){
        String fileInput="C:\\Users\\LENOVO\\Desktop\\input1.txt";
        String fileOutput="C:\\Users\\LENOVO\\Desktop\\output9.txt";

        int count=0;
         try  {
            BufferedReader reader = new BufferedReader(new FileReader(fileInput));
            String line;
            while((line=reader.readLine())!=null) {
            count += line.length();                
            }

        } catch(IOException  e){
            System.out.println("Error");
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutput, true))) { // Mở file ở chế độ ghi tiếp (append = true)

                writer.write(""+count); // Ghi dòng vào file
                writer.flush(); // Đẩy dữ liệu xuống file ngay lập tức
            
            System.out.println("Ghi vào file thành công!");

        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file!");
            e.printStackTrace();
        } 
    }
}