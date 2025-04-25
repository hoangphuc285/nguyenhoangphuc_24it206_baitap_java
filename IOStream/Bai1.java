import java.io.*;
class Bai1{
    public static void main(String[] args) {
        String fileInput = "C:\\Users\\LENOVO\\Desktop\\input1.txt";
        String fileOutput="C:\\Users\\LENOVO\\Desktop\\output1.txt";
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