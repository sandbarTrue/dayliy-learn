package com.example.dayliy.learn.leetcode;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RegularExpressionMatching1 {
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
                line = in.readLine();
                String p = stringToString(line);

                boolean ret = new RegularExpressionMatching1Solution().isMatch(s, p);

                String out = booleanToString(ret);

                System.out.print(out);
            }
        }
}

class RegularExpressionMatching1Solution {
    public boolean isMatch(String s, String p) {
        if(isEmpty(s) && isEmpty(p)){
            return  true;
        }
        if(isEmpty(s) && (p=="*" || p=="." || p=="*." || p==".*")){
            return true;
        }
        if(isEmpty(p) && !isEmpty(s)){
            return false;
        }
        int i;
        for(i=0;i<s.length();i++){
            char  c=s.charAt(i);
            if(i>=p.length()){
                char c1=p.charAt(p.length()-1);
                char c2=s.charAt(i-1);
                if(c1=='*' && c2==c){
                    continue;
                }
                else{
                    return false;
                }
            }
            char  c3=p.charAt(i);
            if(c3==c || c3=='*' || c3=='.'){
                continue;
            }
            else{
                p=p.substring(0);
            }
        }
        char last=p.charAt(p.length()-1);
        char last1=s.charAt(s.length()-1);
        if((last!='*' || last!='.') && last!=last1)
        {
            return false;
        }
        return true;
    }
    private boolean isEmpty(String s){
        if(s==null || s.length()==0){
            return true;
        }
        return false;
    }
}