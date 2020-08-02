package com.example.dayliy.learn.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class ArrayListTest {

   public static  void main(String[] args) {
       //动态数组
       ArrayList<Integer> arrayList=new ArrayList();
       arrayList.add(new Integer(1).intValue());
       arrayList.add(2);
       arrayList.add(3);
       System.out.println(arrayList);
       //删除
       arrayList.remove(1);
       System.out.println(arrayList);
       //改
       arrayList.set(1,0);
       //查
       for(int i=0;i<arrayList.size();i++){
           System.out.println(arrayList.get(i));
       }
       for(Integer i:arrayList){
           System.out.println(i);
       }
       //迭代器
       Iterator<Integer> integerIterator=arrayList.iterator();
       while(integerIterator.hasNext()){
           System.out.println(integerIterator.next());
       }
    }
}
