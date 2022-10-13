package com.MapList.IOFile;
import java.io.*;

public class File {
    public static void main(String[] args) throws IOException {
        //创建一个文件并向文件中写数据。
        byte  os[] = {3,2,1,4,5,6,7};
        //构建一个文件输出流对象
        OutputStream f = new FileOutputStream("hello.txt");
//        构建OutputStreamWriter对象,参数可以指定编码,默认为操作系统默认编码,windows上是gbk
        OutputStreamWriter bd=new OutputStreamWriter(f,"UTF-8");
        for (int i = 0; i < os.length; i++) {
            bd.write(os[i]);
            System.out.println(os[i]);
        }
        bd.append("中文输入");
        bd.close();
//        关闭文件
        f.close();
        //创建一个输入流对象来读取文件：
        System.out.println("=========");
        FileInputStream fip = new FileInputStream("hello.txt");
        // 构建FileInputStream对象

        InputStreamReader reader = new InputStreamReader(fip, "UTF-8");
        // 构建InputStreamReader对象,编码与写入相同

        StringBuffer sb = new StringBuffer();
        while (reader.ready()) {
            sb.append((char) reader.read());
            // 转成char加到StringBuffer对象中
        }
        System.out.println(sb.toString());
        reader.close();
        // 关闭读取流

        fip.close();
        // 关闭输入流,释放系统资源
        System.out.println("============");
//        try {
//
//            InputStream e = new FileInputStream("hello.txt");
//            InputStreamReader b = new InputStreamReader(e,"UTF-8");
//            StringBuffer sb = new StringBuffer();
//            while (b.ready()) {
//                sb.append((char) b.read());
//                // 转成char加到StringBuffer对象中
//            }
//            System.out.println(sb.toString());
//            b.close();
//            // 关闭读取流
//            System.out.println(e.toString());
//            for (int i = 0; i < e.available(); i++) {
//                System.out.println(e.read());
//                System.out.println(i);
//            }
//            System.out.println("方法已经调用");
//            e.close();
//        } catch (FileNotFoundException ex) {
//            ex.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
