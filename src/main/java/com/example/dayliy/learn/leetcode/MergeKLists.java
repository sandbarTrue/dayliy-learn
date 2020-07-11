package com.example.dayliy.learn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhoujun
 */
public class MergeKLists {
    public static void main(String[] args) {
        ListNode[] lists=new ListNode[2];
        ListNode l1=new ListNode(1);
        ListNode l1next=l1.next=new ListNode(4);
        l1next.next=new ListNode(5);
        lists[0]=l1;
        ListNode l2=new ListNode(2);
        l2.next=new ListNode(6);
        lists[1]=l2;
        new MergeKListsSolution1().mergeKLists(lists);
    }

}

class MergeKListsSolution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length<=0){
            return null;
        }
        if(lists.length<2){
            return lists[0];
        }
        ListNode temp=null;
        temp=merge2Lists(lists[0],lists[1]);
        for(int i=2;i<lists.length;i++){
            temp=merge2Lists(temp,lists[i]);
        }
        return  temp;
    }
    private ListNode merge2Lists(ListNode l1,ListNode l2){
        ListNode temp1=l1;
        ListNode temp2=l2;
        ListNode temp=null;
        if(temp1.val<=temp2.val){
            temp=new ListNode(temp1.val);
            temp1=temp1.next;
        }
        else{
            temp=new ListNode(temp2.val);
            temp2=temp2.next;
        }

        while(temp1!=null && temp2!=null){
            if(temp1.val<=temp2.val){
                temp.next=new ListNode(temp1.val);
                temp1=temp1.next;
            }
            else{
                temp.next=new ListNode(temp2.val);
                temp2=temp2.next;
            }
        }
        if(temp1!=null){
            while(temp1!=null){
                temp.next=new ListNode(temp1.val);
                temp1=temp1.next;
            }
        }
        if(temp2!=null){
            while(temp2!=null){
                temp.next=new ListNode(temp2.val);
                temp2=temp2.next;
            }
        }
        return temp;
    }
}

class MergeKListsSolution1 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length<=0){
            return null;
        }
        ListNode result=null;
        List<ListNode> list1= Arrays.asList(lists);
        List<ListNode> arrList = new ArrayList<ListNode>(list1);
        buildResult(arrList,result);
        return result;
    }

    private void buildResult(List<ListNode> lists, ListNode listNode){
        if(lists==null || lists.size()<=0){
            return ;
        }
        ListNode min=lists.get(0);
        int minIndex=0;
        for(int i=1;i<lists.size();i++){
            if(lists.get(i).val<min.val){
                min=lists.get(i);
                minIndex=i;
            }
        }
        listNode=new ListNode(min.val);
        if(min.next==null){
            lists.remove(minIndex);
        }
        else{
            lists.remove(minIndex);
            lists.add(minIndex, min.next);
        }
        buildResult(lists,listNode.next);
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
