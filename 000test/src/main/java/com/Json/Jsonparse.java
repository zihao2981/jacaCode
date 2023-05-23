package com.Json;

import com.alibaba.fastjson.JSONObject;

public class Jsonparse {
    public static void main(String[] args) {
        String n = "{\n" +
                "    \"ExtendInfo\":\"{\\n  \\\"reservationNo\\\": \\\"P2305190004\\\",\\n  \\\"putNo\\\": \\\"A2305190062\\\",\\n  \\\"putType\\\": \\\"ZD\\\",\\n  \\\"noticeDate\\\": \\\"2023-05-19\\\",\\n  \\\"noticeTemp\\\": \\\"21\\\",\\n  \\\"putTemp\\\": \\\"21\\\",\\n  \\\"modes\\\": \\\"自配到库\\\",\\n  \\\"takeDate\\\": \\\"2023-05-19T17:06:00\\\",\\n  \\\"tempNo\\\": \\\"\\\",\\n  \\\"mailNo\\\": \\\"\\\",\\n  \\\"code\\\": \\\"\\\",\\n  \\\"orderList\\\": [\\n    {\\n      \\\"orderNo\\\": \\\"06028-1684462315616\\\",\\n      \\\"remake\\\": \\\"合格\\\",\\n      \\\"warehouseNo\\\": \\\"SH01\\\"\\n    }\\n  ],\\n  \\\"contact\\\": \\\"CS\\\"\\n}\"\n" +
                "}" ;
        JSONObject parse = JSONObject.parseObject(JSONObject.parseObject(n).getString("ExtendInfo"));

        System.out.println(parse);
    }
}
