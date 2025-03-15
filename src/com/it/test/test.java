package com.it.test;

import java.util.Random;

public class test {
    public static void main(String[] args) {
        //需求：
        //把一个以为数组中的数据：0~15 打乱顺序
        //然后在按照4个一组的方式添加到二维数组中

        //1.定义一个数组
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        //2.打乱数组中的顺序
        Random r = new Random();

        for (int i = 0; i < arr.length; i++) {
            int index = r.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
        //遍历数组
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+", ");
        }
        System.out.println();


        //创建二维数组
        int[][] arr1 = new int[4][4];
        //方法1
        //遍历一维数组，将其把每个元素依次放进二维数组
        for (int i = 0; i < arr.length; i++) {
            arr1[i / 4][i % 4] = arr[i];
        }
        //遍历二维数组
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                System.out.print(arr1[i][j] + " ");

            }
            System.out.println();
        }

        //方法2
        //遍历二维数组，给里面的每个数据赋值
        int index1 = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                arr1[i][j] = arr[index1];
                index1++;
            }

        }
        //遍历二维数组
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                System.out.print(arr1[i][j] + " ");

            }
            System.out.println();
        }



    }
}
