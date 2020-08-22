package com.example.dayliy.learn.collection;

import java.util.*;

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
       Vector<Integer> vector=new Vector<>();
       vector.add(1);
       vector.add(2);
       //迭代器
       itr(arrayList.iterator());
       itr(vector.iterator());
       LinkedList<Integer> linkedList=new LinkedList<>();
       for(int i=0;i<arrayList.size();i++){

       }
       Map<Integer,String> map=new HashMap<>();
       //增
       map.put(1,"s");
       //删
       map.remove(1);
       //清空map
       map.clear();
       //改
       map.put(1,"2");
       //查
       map.put(2,"2");
       map.get(2);
       //应用场景  枚举 1 2 3 4  男 女 变性人 双性
       map.put(1,"男");
       map.put(1,"女");
       // sex=1
       map.get(1);
       List<Integer> list=new ArrayList();

   }

   public static  int add(int i,int j){
       return i+j;
   }
   public static  void test(int value){
       System.out.println(value);
   }

   public static  void ff(Collection<String> list){
        for(int i=0;i<list.size();i++){

        }
   }

   public static void itr(Iterator iterator){
       while(iterator.hasNext()){
           System.out.println("diedaiqi"+iterator.next());
       }
   }
}
