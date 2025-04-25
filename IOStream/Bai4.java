import java.io.*;
import java.util.*;

class Bai4{
    public static void main(String[] args) {
        String fileInput="C:\\Users\\LENOVO\\Desktop\\output4.txt";
        String fileOutput="C:\\Users\\LENOVO\\Desktop\\output4.txt";

        Scanner sc=new Scanner(System.in);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileInput, true))) { // Mở file ở chế độ ghi tiếp (append = true)
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

        try  {
            BufferedReader reader = new BufferedReader(new FileReader(fileOutput));
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