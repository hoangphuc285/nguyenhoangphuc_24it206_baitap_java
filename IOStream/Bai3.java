import java.io.*;
class Bai3{
    public static void main(String[] args) {
        String filePath = "C:\\Users\\LENOVO\\Desktop\\input1.txt";
        int count=0;
         try  {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            int line;
            while((line=reader.read())!=-1) {
                if(line=='\n') count++;
            }

        } catch(IOException  e){
            System.out.println("Error");
            e.printStackTrace();
        }
        System.out.println(count);
    }
}