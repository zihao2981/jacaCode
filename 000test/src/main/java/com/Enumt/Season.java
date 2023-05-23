package com.Enumt;
public enum Season {

    SPRING,SUMMER,FALL,WINTER;
    public void test(Season s){
        switch(s)
        {
            case SPRING:
                System.out.println("春天到了");
                break;
            case SUMMER:
                System.out.println("夏天到了");
                break;
            case FALL:
                System.out.println("秋天到了");
                break;
            default:
                System.out.println("冬天到了");
        }
    }
}
