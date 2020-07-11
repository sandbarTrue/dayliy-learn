package com.example.dayliy.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        GenerateParenthesesSolution generateParenthesesSolution=new GenerateParenthesesSolution();
        generateParenthesesSolution.generateParenthesis(3);

    }
}

class GenerateParenthesesSolution {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if(n == 0) {
            list.add("");
        }
        for(int i = 0; i < n; i++) {
            List<String> list1 = generateParenthesis(i);
            List<String> list2 = generateParenthesis(n - i - 1);
            for (String s1 : list1) {
                for (String s2 : list2) {
                    list.add("(" + s1 + ")" + s2);
                }
            }
        }
        return list;
    }
}
