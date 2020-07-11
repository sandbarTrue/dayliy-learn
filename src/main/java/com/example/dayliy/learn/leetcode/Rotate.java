package com.example.dayliy.learn.leetcode;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Rotate {
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
            sb.append(Arrays.toString(item));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[][] matrix = stringToInt2dArray(line);

            new RotateSolution().rotate(matrix);
            String out = int2dArrayToString(matrix);

            System.out.print(out);
        }
    }
}

class RotateSolution {

    public void rotate(int[][] matrix) {
        if (matrix.length <= 0) {
            return;
        }
        for (int i = 0; i < (matrix.length-1) / 2; ) {
            for (int j = 0; j < (matrix[i].length-1) / 2; ) {
                Calculation(matrix, i, j);
                if (i < (matrix.length-1) / 2) {
                    i++;
                } else if (j < (matrix[i].length-1) / 2) {
                    j++;
                } else {
                    break;
                }
            }
        }
    }
        public void Calculation(int[][] array,int startX,int startY){
            int endX=startY;
            int endY=array[startX].length-1-startX;
            int pre=array[startX][startY];
            while(!(endX==startX && endY==startY)){
                int current=array[endX][endY];
                array[endX][endY]=pre;
                int preEndY=endY;
                endY=array[endX].length-1-endX;
                endX=preEndY;
                pre=current;
            }
            array[endX][endY]=pre;
        }
}
