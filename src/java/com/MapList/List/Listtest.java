package com.MapList.List;
import java.util.*;

public class Listtest {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
//        赋值，
        a.add(0,"null");
        a.add(1, "string");
        a.add(2, "int");
        for (String t : a) {
            System.out.println(t);
        }
       System.out.println("-----------------");
        //迭代器遍历
        Iterator<String> it= a.iterator();
        for (;it.hasNext();) {
            System.out.println(it.next());
        }
        //List转为array##这种方法会丢失类型信息，所以实际应用很少
      System.out.println("-----------------");
        Object[] dc=a.toArray();

        for (int i = 0; i < dc.length; i++) {
            System.out.println(dc[i]);
//            System.out.println(dc[i].getClass());
        }
        //方式二List.of是java9的方法
////        List<Integer> list = List.of(12, 34, 56);
        List<Integer> list =  Arrays.asList(1,2,3);
        System.out.println(list);
//        Integer[] array = list.toArray(Integer[]::new);
//        for (Integer n : array) {
//            System.out.println(n);
//        }
//        方式三是List接口定义的T[] toArray(IntFunction<T[]> generator)方法：
//取值
        System.out.println(list.get(2)+"取值操作");
//        删除
        //这是由Arrays.asList() 返回的是Arrays的内部类ArrayList， 而不是java.util.ArrayList。
        // Arrays的内部类ArrayList和java.util.ArrayList都是继承AbstractList，
        // remove、add等方法AbstractList中是默认throw UnsupportedOperationException而且不作任何操作。
        // java.util.ArrayList重新了这些方法而Arrays的内部类ArrayList没有重新，所以会抛出异常。解决方法如下：
        List<Integer> b = new ArrayList(list);
        b.remove(2);
        System.out.println("删除一个后");
        System.out.println(b);
        for (Integer t : b) {
            System.out.println(t);
        }
        b.removeAll(b);
        System.out.println("删除全部后");
        for (Integer t : b) {
            System.out.println(t);
        }
//        删除，





    }
}
