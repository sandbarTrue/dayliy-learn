package com.example.dayliy.learn.leetcode;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ImplementStrSt {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String haystack = stringToString(line);
            line = in.readLine();
            String needle = stringToString(line);

            int ret = new ImplementStrStSolution().strStr(haystack, needle);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }


}

class ImplementStrStSolution {
    public int strStr(String haystack, String needle) {
        if(needle==null || needle.length()<=0){
            return 0;
        }
        int i=0;
        int j=0;
        int[] table=cacluteStep(needle);
        while(j<needle.length() && i<haystack.length()){
            if(needle.charAt(j)==haystack.charAt(i)){
                i++;
                j++;
            }
            else{
                if(j==0){
                    i++;
                }
                else{
                    j=table[j-1];
                }
            }
        }
        if(j==needle.length()){
            return i-j;
        }
        return -1;
    }
    private int[] cacluteStep(String needle){
        int length=needle.length();
        int [] table=new int[length];
        table[0]=0;
        int index=0;
        for(int i=1;i<length;){
            if(needle.charAt(i)==needle.charAt(index)){
                table[i]=index+1;
                index++;
                i++;
            }
            else{
                if(index>0){
                    index=table[index-1];
                }
                else{
                    table[i]=0;
                    i++;
                }
            }
        }
        return table;
    }
}
