package com.example.dayliy.learn.jvm;

import java.util.LinkedList;
import java.util.List;

public class HelloGC {

    public static void main(String[] args) {
        /*System.out.println("HelloGC!");
        List list = new LinkedList();
        for(;;) {
            byte[] b = new byte[1024*1024];
            list.add(b);
        }*/
        int n=4;
        String result="341";
        for(int i=1;i<=n;i++){
            if(!result.contains(""+i)){
                result=result+i;
                break;
            }
        }
        System.out.println(result);
    }

}
