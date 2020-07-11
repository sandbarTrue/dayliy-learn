package com.example.dayliy.learn.leetcode;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RegularExpressionMatching2 {
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

                boolean ret = new RegularExpressionMatching2Solution().isMatch(s, p);

                String out = booleanToString(ret);

                System.out.print(out);
            }
        }
}

enum Result {
    TRUE, FALSE
}

class RegularExpressionMatching2Solution {
    Boolean[][] temps=null;
    public boolean isMatch(String text, String pattern) {
         temps=new Boolean[text.length()+1][pattern.length()+1];
        return db(0,0,text,pattern);
    }
    public boolean db(int i, int j, String text, String pattern){
        if(temps[i][j]!=null){
            return temps[i][j]==true;
        }
        boolean temp=false;
        if(j>=pattern.length()){
            temp=i<text.length()?false:true;
        }
        else{
            boolean firstMatch=(i<text.length() &&(text.charAt(i)=='.'|| text.charAt(i)==pattern.charAt(j)));
            if(j+1<pattern.length() && pattern.charAt(j+1)=='*'){
                temp= db(i,j+2,text,pattern) || (firstMatch && db(i+1,j,text,pattern));
            }
            else{
                temp=db(i+1,j+1,text,pattern);
            }
        }
        temps[i][j]=temp;
        return temp;
    }
    private boolean isEmpty(String s){
        if(s==null || s.length()==0){
            return true;
        }
        return false;
    }
}