package com.example.springbootdemo.Sort;

import java.util.Arrays;

/**
 * @author D N
 * @create 2018-04-12 17:54
 * 折半插入有序数组
 **/
public class InsertBinary {
    public static void main(String[] args) {
        int[] intArrays={1,2,3,4,5,5,7,9,10,11,23,26};
        System.out.println(Arrays.toString(insertBinary(intArrays,5,0,intArrays.length-1)));
    }

    private static int[] insertBinary(int[] intArrays, int num,int left,int right) {
        int[] newArrys=new int[intArrays.length+1];
        if(left<right){
            int mid=(left+right)/2;
            if(intArrays[mid]<=num&&intArrays[mid+1]>num){
                for (int i=0;i<newArrys.length;i++){
                    if(i<mid+1){
                        newArrys[i]=intArrays[i];
                    }
                    if(i==mid+1){
                        newArrys[i]=num;
                    }
                    if(i>mid+1){
                        newArrys[i]=intArrays[i-1];
                    }
                }
            }else{
                if(intArrays[mid]>num){
                    return insertBinary(intArrays,num,left,mid);
                }
                if(intArrays[mid]<num){
                    return insertBinary(intArrays,num,mid,right);
                }
            }

        }
        return newArrys;

    }
}
