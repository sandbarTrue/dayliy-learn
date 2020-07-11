package com.example.dayliy.learn.leetcode;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            boolean ret = new ValidParenthesesSolution().isValid(s);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}

class ValidParenthesesSolution {
    private static Map<Character, Character> map=new HashMap<>();
    static {
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
    }
    public boolean isValid(String s) {
        Stack<Character> stack =new Stack<Character>();
        if(s==null){
            return true;
        }
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(map.get(c)!=null){
                if(stack.empty()){
                    return false;
                }
                char c1=stack.pop();
                if(c1==map.get(c)){
                    continue;
                }
                else{
                    return  false;
                }
            }
            else{
                stack.push(c);
            }
        }
        return true;
    }
}
