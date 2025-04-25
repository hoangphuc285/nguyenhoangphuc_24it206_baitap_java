import java.io.*;
import java.util.*;
class Thread1 extends Thread{
    String filePath;
    public Thread1(String filePath){ 
        this.filePath=filePath;
    }
    public void run(){
        try( BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));)  { // Mở file ở chế độ ghi tiếp (append = true)
            System.out.println("Nhập nội dung để ghi vào file (Nhập 'exit' để kết thúc):");
            writer.newLine(); // Xuống dòng
            for(int i=60;i<75;i++)  {
                String s ="";
                s+= i;
                writer.write(s); // Ghi dòng vào file
                writer.flush(); // Đẩy dữ liệu xuống file ngay lập tức
            }
            
            System.out.println("Ghi vào file thành công!");

        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file!");
            e.printStackTrace();
        } 
    }
}
class Thread2 extends Thread{
    String filePath;
    BufferedWriter writer;
    public Thread2(String filePath){ 
        this.filePath=filePath;
    }
    public void run(){
        try ( BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));) { // Mở file ở chế độ ghi tiếp (append = true)
            System.out.println("Nhập nội dung để ghi vào file (Nhập 'exit' để kết thúc):");
            writer.newLine(); // Xuống dòng
            for(int i=50;i<60;i++) {
                String s ="";
                s+= i;
                writer.write(s); // Ghi dòng vào file
                writer.flush(); // Đẩy dữ liệu xuống file ngay lập tức
            }
            
            System.out.println("Ghi vào file thành công!");

        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file!");
            e.printStackTrace();
        } 
    }
}
class Bai2 {
    public static void main(String[] args) {
        String filePath="C:\\Users\\LENOVO\\Desktop\\output2.txt";
           
        Thread1 t1=new Thread1(filePath);
        Thread2 t2=new Thread2(filePath);
        t1.start();
        try{
            t1.join();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        t2.start();
    }
}