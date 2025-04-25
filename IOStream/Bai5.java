import java.io.File;
 class Bai5 {
    public static void main(String[] args) {
        // Thay đường dẫn thư mục cần liệt kê
        String folderPath = "C:\\Users\\LENOVO\\Desktop";

        // Tạo đối tượng File trỏ đến thư mục
        File folder = new File(folderPath);

        // Kiểm tra xem folder có tồn tại không
        if (folder.exists() && folder.isDirectory()) {
            // Lấy danh sách tất cả các file và thư mục con
            File[] files = folder.listFiles();

            if (files != null && files.length > 0) {
                System.out.println("Danh sách file trong thư mục: " + folderPath);
                for (File file : files) {
                    if (file.isFile()) { // Chỉ liệt kê file (bỏ qua thư mục con)
                        System.out.println(file.getName());
                    }
                }
            } else {
                System.out.println("Thư mục trống hoặc không có quyền truy cập!");
            }
        } else {
            System.out.println("Thư mục không tồn tại!");
        }
    }
}