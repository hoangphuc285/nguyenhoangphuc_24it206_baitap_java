import java.io.*;
import java.util.*;

class Bai7 extends Thread{
    public static void main(String[] args) {
        Bai7 thread=new Bai7();
        thread.start();
    }
    public void run(){
        String filePath="C:\\Users\\LENOVO\\Desktop\\output7.txt";
        Scanner sc=new Scanner(System.in);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) { // Mở file ở chế độ ghi tiếp (append = true)
            System.out.println("Nhập nội dung để ghi vào file (Nhập 'exit' để kết thúc):");

            while (true) {
                String input = sc.nextLine(); // Đọc từ bàn phím
                
                if (input.equalsIgnoreCase("exit")) { // Nếu nhập 'exit' thì thoát
                    break;
                }
                
                writer.write(input); // Ghi dòng vào file
                writer.newLine(); // Xuống dòng
                writer.flush(); // Đẩy dữ liệu xuống file ngay lập tức
            }
            
            System.out.println("Ghi vào file thành công!");

        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file!");
            e.printStackTrace();
        } finally {
            sc.close(); // Đóng scanner
        }
    }
}