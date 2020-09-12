package com.example.dayliy.learn.link;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import lombok.Data;
import org.omg.CORBA.OBJECT_NOT_EXIST;

import java.util.*;

@Data
public class MyLink {
    Node head=new Node();
    //build link
    int size;
    public void addNode(Node node){
        size++;
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=node;
    }

    //head ---node 画图
    public static void main(String[] args) {
        MyLink myLink= new MyLink();
        Node node=new Node();
        node.data="1";
        myLink.addNode(node);
        Node node2=new Node();
        node2.data="2";
        myLink.addNode(node2);
        Node node3=new Node();
        node3.data="3";
        myLink.addNode(node3);
        Node node4=new Node();
        node4.data="4";
        myLink.addNode(node4);
        MyLink myLink1= new MyLink();
        Node node5=new Node();
        node5.data="5";
        myLink1.addNode(node5);
        Node node6=new Node();
        node6.data="6";
        myLink1.addNode(node6);
        mergeLink(myLink,myLink1);
        Node temp=myLink.head;
        while(temp.next!=null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        //双向循环链表
        Map<String, Object> map=new HashMap<>();
        map.put("lin1",new MyLink());
        map.put("lin2",new MyLink());
         Node node1=(Node)map.get("code");

        class test{
          Node  key ;
            List key2;
        }
        {
           key:aadedf123@123,
            data:[{
            id:
            name:
            call:{
                no:
            }
        }]
        }
        {
            "key":{
              data:"11"
                next:
            }
            "key2":[1,23,42,4]
        }

        return Node();

        {
            data:"test1",
            next:{
            data:
            next:{
                data:
                next:{

                }
            }
        },

        }
    }


    public static  void mergeLink(Map<String,Object> map){
        ((MyLink)map.get("lin1")).addNode(((MyLink)map.get("lin2")).head.next);

    }
    public static  void mergeLink(MyLink link,MyLink link1){
        link.addNode(link1.head.next);
    }
}


class Node{

    public Object data;

    public Node next;
}