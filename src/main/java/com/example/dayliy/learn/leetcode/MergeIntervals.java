package com.example.dayliy.learn.leetcode;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeIntervals {

        public static int[] stringToIntegerArray(String input) {
            input = input.trim();
            input = input.substring(1, input.length() - 1);
            if (input.length() == 0) {
                return new int[0];
            }

            String[] parts = input.split(",");
            int[] output = new int[parts.length];
            for(int index = 0; index < parts.length; index++) {
                String part = parts[index].trim();
                output[index] = Integer.parseInt(part);
            }
            return output;
        }

        public static int[][] stringToInt2dArray(String input) {
            JsonArray jsonArray = JsonArray.readFrom(input);
            if (jsonArray.size() == 0) {
                return new int[0][0];
            }

            int[][] arr = new int[jsonArray.size()][];
            for (int i = 0; i < arr.length; i++) {
                JsonArray cols = jsonArray.get(i).asArray();
                arr[i] = stringToIntegerArray(cols.toString());
            }
            return arr;
        }

        public static String int2dArrayToString(int[][] array) {
            if (array == null) {
                return "null";
            }
            if (array.length == 0) {
                return "[]";
            }

            StringBuilder sb = new StringBuilder("[");
            for (int[] item : array) {
                sb.append(intArrayToString(item));
                sb.append(",");
            }

            sb.setCharAt(sb.length() - 1, ']');
            return sb.toString();
        }
        public static String intArrayToString(int [] array){
            if (array == null) {
                return "null";
            }
            if (array.length == 0) {
                return "[]";
            }

            StringBuilder sb = new StringBuilder("[");
            for (int item : array) {
                sb.append(Integer.toString(item));
                sb.append(",");
            }
            sb.setCharAt(sb.length() - 1, ']');
            return sb.toString();
        }
        public static void main(String[] args) throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while ((line = in.readLine()) != null) {
                int[][] intervals = stringToInt2dArray(line);

                int[][] ret = new MergeIntervalsSolution().merge(intervals);

                String out = int2dArrayToString(ret);

                System.out.print(out);
            }
        }

}

class MergeIntervalsSolution {
    public int[][] merge(int[][] intervals) {
        quickSort(intervals,0,intervals.length-1);
        int[][] result=new int[intervals.length][2];
        int resultIndex=0;
        result[0]=intervals[0];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>result[resultIndex][1]){
                resultIndex++;
                result[resultIndex]=intervals[i];
            }
            else{
                result[resultIndex][1]=intervals[i][1];
            }
        }
        return result;
    }

    private void quickSort(int [][] intervals,int left,int right){
        if(left>=right){
            return ;
        }
        int tempLeft=left;
        int tempRight=right;
        int[] temp=intervals[left];
        while(tempLeft<tempRight){
            while(tempLeft<tempRight && isBigThenTemp(temp,intervals[tempRight])){
                tempRight--;
            }
            intervals[tempLeft]=intervals[tempRight];
            while(tempLeft<tempRight && isSmallThenTemp(temp,intervals[tempLeft])){
                tempLeft++;
            }
            intervals[tempRight]=intervals[tempLeft];
        }
        intervals[tempRight]=temp;
        quickSort(intervals,left,tempLeft-1);
        quickSort(intervals,tempLeft+1,right);
    }
    private boolean isBigThenTemp(int[] temp,int [] interval){
        if(temp[0]<=interval[0]){
            return true;
        }
        return false;
    }
    private boolean isSmallThenTemp(int[] temp,int[] interval){
        if(temp[0]>=interval[0]){
            return true;
        }
        return  false;
    }
}
