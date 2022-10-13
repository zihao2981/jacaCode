package com.TCP.demo02文件上传;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {


    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("E:\\learnNote\\images\\dwada.jpg");
        Socket socket =new Socket("127.0.0.1",8888);
        OutputStream os = socket.getOutputStream();;
        int len =0;
        byte[] bytes=new byte[1024];
        while ((len= fis.read(bytes))!=-1){
            os.write(bytes,0,len);
        }
        InputStream is = socket.getInputStream();
        while ((len= fis.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
        fis.close();
        socket.close();
    }
}
