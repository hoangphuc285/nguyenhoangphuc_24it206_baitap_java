import java.io.*;
import java.net.*;
import java.util.concurrent.*;

 class Bai10 {
    
    public static void main(String[] args) {
        String url = "http://example.com"; // Thay đổi URL theo yêu cầu
        String outputFile = "C:\\Users\\LENOVO\\Desktop\\output10.txt"; // Tên file lưu kết quả

        // Sử dụng ExecutorService để quản lý Thread
        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.submit(new DownloadTask(url, outputFile));
        
        // Dừng executor sau khi hoàn thành công việc
        executor.shutdown();
    }
}

class DownloadTask implements Runnable {
    private String url;
    private String outputFile;

    public DownloadTask(String url, String outputFile) {
        this.url = url;
        this.outputFile = outputFile;
    }

    @Override
    public void run() {
        try {
            // Tạo kết nối tới URL
            URL website = new URL(url);
            BufferedReader in = new BufferedReader(new InputStreamReader(website.openStream()));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            String inputLine;
            // Đọc dữ liệu từ URL và ghi vào file
            while ((inputLine = in.readLine()) != null) {
                writer.write(inputLine);
                writer.newLine();
            }

            // Đóng kết nối và file sau khi hoàn thành
            in.close();
            writer.close();
            
            System.out.println("Download hoàn tất và lưu vào file: " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
