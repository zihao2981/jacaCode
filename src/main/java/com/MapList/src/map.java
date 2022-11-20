package com.MapList.src;
import java.util.HashMap;
import java.util.Map;
public class map {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            map.put(i,i+5);
        }

        //增强for循环遍历
        for (Integer ks :
                map.values()) {
            System.out.println(ks);
        }
    }

}
