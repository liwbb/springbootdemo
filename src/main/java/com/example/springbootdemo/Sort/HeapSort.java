package com.example.springbootdemo.Sort;

import java.util.Arrays;

/**
 * @author D N
 * @create 2018-04-02 10:39
 **/
public class HeapSort {
    public static void main(String[] args) {
        //堆排序
        int[] a={3,1,5,6,2,4,9,7,10,8};
        System.out.println(Arrays.toString(a));
        for (int i=a.length/2-1;i>=0;i--){
            adjustHeap(a,i,a.length);
        }
        for (int j=a.length-1;j>=0;j--){
            swap(a,0,j);
            adjustHeap(a,0,j);
        }
        System.out.println(Arrays.toString(a));
    }

    private static void swap(int[] a, int i, int j) {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    private static void adjustHeap(int[] a, int i, int length) {
        int temp=a[i];
        for (int j=2*i+1;j<length;j=2*j+1){
            if(j+1<length&&a[j]<a[j+1]){
                j++;
            }
            if(temp<a[j]){
                a[i]=a[j];
                i=j;
            }else{
                break;
            }
        }
        a[i]=temp;
    }
}
