import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

 class Bai5 {

    // Hàm ghi thông điệp vào file log
    public static void logMessage(String message) {
        try (FileWriter writer = new FileWriter("C:\\Users\\LENOVO\\Desktop\\logfile.txt", true)) {
            // Định dạng thời gian
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String timestamp = sdf.format(new Date());
            
            // Ghi thông điệp vào file
            writer.write(timestamp + " - " + message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Lớp Thread để ghi log liên tục
    static class LogThread extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    logMessage("Đây là thông điệp log.");
                    Thread.sleep(5000);  // Đợi 5 giây
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // Tạo và chạy thread ghi log
        LogThread logThread = new LogThread();
        logThread.setDaemon(true);  // Đảm bảo thread sẽ kết thúc khi chương trình chính kết thúc
        logThread.start();

        // Chương trình chính có thể thực hiện công việc khác, ví dụ chờ đợi
        try {
            Thread.sleep(60000);  // Chờ 60 giây trước khi kết thúc
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Chương trình kết thúc.");
    }
}
