package com.example.springbootdemo.Sort;

import java.util.Arrays;

/**
 * @author D N
 * @create 2018-04-02 15:50
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {6, 8, 7, 9, 5, 4, 3, 2, 1, 0};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序结果：" + Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        if(left<right){
            dealPivot(arr,left,right);
            System.out.println(Arrays.toString(arr)+"===>1");
            int privot=right-1;
            int i=left;
            int j=right-1;
            while (true){
                while (arr[++i]<arr[privot]){
                }
                while (j>left&&arr[--j]>arr[privot]){
                }
                if (i<j){
                    System.out.println(Arrays.toString(arr)+"===>1.1");
                    swap(arr,i,j);
                    System.out.println(Arrays.toString(arr)+"===>1.2");
                }else {
                    break;
                }
            }
            System.out.println(Arrays.toString(arr)+"===>1.5");
            System.out.println("======"+i+"================");
            if (i<right){
                swap(arr,i,right-1);
            }
            System.out.println(Arrays.toString(arr)+"===>1.6");
            System.out.println(Arrays.toString(arr)+"===>2");
            quickSort(arr,left,i-1);
            quickSort(arr,i+1,right);
        }
    }

    private static void dealPivot(int[] arr, int left, int right) {
        int mid=(right+left)/2;
        if(arr[mid]<arr[left]){
            swap(arr,left,mid);
        }
        if(arr[left]>arr[right]){
            swap(arr,left,right);
        }
        if(arr[mid]>arr[right]){
            swap(arr,mid,right);
        }
        swap(arr,right-1,mid);
    }

    private static void swap(int[] arr, int left, int right) {
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;

    }


}
