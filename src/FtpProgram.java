import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FtpProgram {
   static FtpUtils ftpUtils = new FtpUtils();
    public static void main(String[] args) {
         List<String> fileListAll = new ArrayList<>();
         fileListAll.add("aaa000");
        List<String> fileList = new ArrayList<>();
        try {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                fileList = ReadFileUtil.readFile("e:/a");
                for (String fileName :fileList) {
                    System.out.println(fileName);
                    for (int i =0;i<fileListAll.size();i++) {
                        if (fileName.equals(fileListAll.get(i)) ){
                            break;
                        } else {
                            if (i==fileListAll.size()-1){
                                fileListAll.add(fileName);
                                ftpUtils.uploadFile("/",fileName,"e:/a/"+fileName);
                                break;
                            }else {
                                continue;
                            }
                        }
                    }

                }
                System.out.println(fileListAll);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
