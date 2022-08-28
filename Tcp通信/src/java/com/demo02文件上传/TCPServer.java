package com.demo02文件上传;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args)throws IOException {

        ServerSocket server = new ServerSocket(8888);
        while (true){

            Socket socket = server.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                   try {
                       InputStream is = socket.getInputStream();
                       File file = new File("E:\\upload");
                       if(!file.exists()){
                           file.mkdir();
                       }
                       String FILEnName = "tzh"+System.currentTimeMillis()+".jpg";
                       FileOutputStream fos = new FileOutputStream(file+"\\"+FILEnName);
                       int len =0;
                       byte[] bytes=new byte[1024];
                       while ((len= is.read(bytes))!=-1){
                           fos.write(bytes,0,len);
                       }
                       socket.getOutputStream().write("shoudao".getBytes());
                       fos.close();
                       socket.close();
                   }catch (Exception e){
                       System.out.println(e);
                   }
                }
            }).start();
        }
    }
}
