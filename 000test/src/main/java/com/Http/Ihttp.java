package com.Http;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class Ihttp {
    public static void main(String[] args) throws IOException {
        HttpURLConnection conn = null;// http特定功能类
        OutputStream out = null;// 输出流
        URL url = null;
        try {
            url = new URL("http://127.0.0.1:80/service/路径");// 地址
            conn = (HttpURLConnection) url.openConnection();// 打开连接
            conn.setRequestMethod("POST");// 设置请求方式
            conn.setRequestProperty("Content-Type","application/json");// 设置通用属性
            conn.setDoOutput(true);// 设置输出
            conn.setDoInput(true);// 设置读入
            conn.connect();// 连接
            out = conn.getOutputStream();// 获取输出流
//            JSONObject data=new  JSONObject();// 参数
//            data.put("A",0);
//            data.put("B","0001");
//            data.put("C","1005");
//            System.out.println(data.toString());	// 查看参数
//            out.write(data.toString().getBytes("utf-8"));
            out.flush();// 刷新缓存
            out.close();// 关闭流
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line = "";// 每一次读取
            String result = "";// 读取的结果集
            while ((line = in.readLine()) != null) {
                result = line + "\n" + result;
            }
            in.close();// 断开连接
            System.out.println(result);// 输出结果
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
