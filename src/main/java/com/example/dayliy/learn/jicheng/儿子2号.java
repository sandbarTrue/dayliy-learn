package com.example.dayliy.learn.jicheng;

public class 儿子2号 extends 父亲{


    public void 吃(){
        System.out.println("儿子2号用手吃");
    }

    public void 吃(String 工具){
        System.out.println("儿子用"+工具+"吃");
    }


    public String 跑(String 工具){

        System.out.println("儿子用"+工具+"吃");
        //跑完之后给你给一个回执单
        return "001";
    }

}
