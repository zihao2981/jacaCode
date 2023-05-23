package com.StaticsTest;

import com.alibaba.fastjson.JSONObject;

public class AAAA {
    private static String aaa1="dada";
    protected static String aaa2="dada";
    protected static Integer aaa3=152;
    public static void main(String[] args) {

        String a = "{\n  \"reservationNo\": \"P2303160005\",\n  \"putNo\": \"A2303160002\",\n  \"putType\": \"ZD\",\n  \"noticeDate\": \"\",\n  \"noticeTemp\": \"\",\n  \"putTemp\": \"\",\n  \"modes\": \"\",\n  \"takeDate\": \"2023-03-15T16:58:00\",\n  \"tempNo\": \"\",\n  \"mailNo\": \"\",\n  \"code\": \"\",\n  \"orderList\": [\n    {\n      \"orderNo\": \"WF007-1678937709258\",\n      \"remake\": \"合格\",\n      \"warehouseNo\": \"SH01\"\n    }\n  ]\n}";
        JSONObject jsonArray = JSONObject.parseObject(a);

        System.out.println(JSONObject.parseObject(a));
        //BBB bbb = new BBB();
        //bbb.test();
        //System.out.println("================");
        //System.out.println(aaa2);
        //System.out.println(aaa3);
//        Solution solution = new Solution();
//
//
//        ListNode l1= new ListNode(2);
//        l1.next=new ListNode(4);
//        l1=l1.next;
//        l1.next=new ListNode(4);
//        l1=l1.next;
//
//        ListNode l2=new ListNode(5);
//        l1.next=new ListNode(6);
//        l1=l1.next;
//        l1.next=new ListNode(4);
//        l1=l1.next;
//        ListNode li=solution.addTwoNumbers(l1,l2);
//        System.out.println(li);
    }
}

 class ListNode {
     int val;
     ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode li = new ListNode(0);
        int carl= 0;
        while (l1!=null||l2!=null){
            li.next= new ListNode((l1.val+l2.val+carl)%10);
            li=li.next;
            carl=(l1.val+l2.val+carl)/10;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        if(carl==1){
            li.next=new ListNode(1);
        }
        return li;
    }
}