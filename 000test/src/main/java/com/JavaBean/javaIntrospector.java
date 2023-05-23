package com.JavaBean;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

public class javaIntrospector {
    /**
     * Introspector.getBeanInfo(Person.class) 可以获取一个类的所有bean属性
     */

    public static void main(String[] args) throws Exception {
        BeanInfo info = Introspector.getBeanInfo(Persontest.class);
        System.out.println("outing +++");
        int i =1;
        for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
            System.out.println(i+"sout++++++++++++++++");
            System.out.println(pd.getName());
            System.out.println("  " + pd.getReadMethod());
            System.out.println("  " + pd.getWriteMethod());
            System.out.println("  "+pd.getPropertyEditorClass());
            System.out.println("  "+pd.getDisplayName());
            System.out.println("  "+pd.getShortDescription());
            System.out.println("  "+pd.getPropertyType());
            System.out.println("  "+pd.getValue("name"));
            i++;
        }
    }

}
class Persontest {
    private String Rname;
    private int Rage;

    public String getRname() {
        return Rname;
    }

    public void setRname(String rname) {
        Rname = rname;
    }

    public int getRage() {
        return Rage;
    }

    public void setRage(int rage) {
        Rage = rage;
    }
}