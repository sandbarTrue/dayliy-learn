package com.example.dayliy.learn.leetcode;



import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null){
            return 0;
        }
        char[] sarr=s.toCharArray();
        int result=0;
        String ss="111";
        Integer.parseInt(ss);
        Set<Character> set=new HashSet<Character>();
        for(int i=0;i<sarr.length;i++){
            set.add(sarr[i]);
            for(int j=i+1;j<sarr.length;j++){
                if(set.contains(sarr[j])){
                    if(result<set.size()){
                        result=set.size();
                    }
                    break;
                }
                set.add(sarr[j]);
            }
            if(result<set.size()){
                result=set.size();
            }
            set.clear();
        }
        return result;
    }
}

public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            int ret = new Solution().lengthOfLongestSubstring(s);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}