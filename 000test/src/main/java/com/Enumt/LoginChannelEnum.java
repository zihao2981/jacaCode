package com.Enumt;
public enum LoginChannelEnum {
    SUN, MON, TUE, WED, THU, FRI, SAT;

    public static void main(String[] args) {
        System.out.println(LoginChannelEnum.THU.ordinal());
    }
}