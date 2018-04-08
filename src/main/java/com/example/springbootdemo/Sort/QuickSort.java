package com.example.springbootdemo.Sort;

import java.util.Arrays;

/**
 * @author D N
 * @create 2018-04-02 15:50
 * 1、先比较数组的第一个中间的一个最后一个，一次由小到大，将中间的数字与最后一个数的前一个数互换
 * 2、获取最后一个数的前一个数一次从左边获取第一个比该数的大，后边获取比该数的值小，讲左右两个数互换
 * 3、只至找到2中不存在数的那个小标，如果i<right,就想当前数与最后一个数的前一个数互换
 * 4、递归（2、3）找出左边的值到当前值前一个值的，当前值下一个值到最后一个值
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
            int privot=right-1;
            int i=left;
            int j=right-1;
            while (true){
                while (arr[++i]<arr[privot]){

                }
                while (j>left&&arr[--j]>arr[privot]){

                }
                if (i<j){
                    swap(arr,i,j);
                }else {
                    break;
                }
            }
            if (i<right){
                swap(arr,i,right-1);
            }
            quickSort(arr,left,i-1);
            quickSort(arr,i+1,right);
        }
    }

    private static void dealPivot(int[] arr, int left, int right) {
        int mid=(left+right)/2;
        if(arr[left]>arr[mid]){
            swap(arr,left,mid);
        }
        if(arr[left]>arr[right]){
            swap(arr,left,right);
        }
        if (arr[mid]>arr[right]){
            swap(arr,mid,right);
        }
        swap(arr,mid,right-1);
    }

    private static void swap(int[] arr, int a, int b) {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }


}
