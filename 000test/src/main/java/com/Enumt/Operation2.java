package com.Enumt;
public enum Operation2 {
    PLUS{
        public double eval(double x,double y){
            return x + y;
        }
    },
    MINUS{
        public double eval(double x,double y){
            return x - y;
        }
    },
    TIMES{
        public double eval(double x,double y){
            return x * y;
        }
    },
    DIVIDE{
        public double eval(double x,double y){
            return x / y;
        }
    };
    public abstract double eval(double x,double y);
    public static void main(String[] args){
        System.out.println(Operation2.PLUS.eval(4,2));   //6.0
        System.out.println(Operation2.MINUS.eval(4,2));  //2.0
        System.out.println(Operation2.TIMES.eval(4,2));  //8.0
        System.out.println(Operation2.DIVIDE.eval(4,2)); //2.0
    }
}