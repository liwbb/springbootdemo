package com.example.springbootdemo.Sort;

import java.util.Arrays;

/**
 * @author D N
 * @create 2018-04-02 10:39
 * 堆排序
 * 1、将数组排列成大堆顶，找出数组中最大序列的非叶子结点，非叶子结点与子叶中最大的数互换，依次到非叶子结点序列最小的
 * 2、将第一最大的数与最后一个互换，然后将数组从新排序成大椎顶，依次将最大的数从最大的序列倒叙放置。
 * 最大的复杂度O（nlog2n）平均的复杂度O（nlog2n）最小的复杂度O（nlog2n）空间O（1）
 **/
public class HeapSort {
    public static void main(String[] args) {
        //堆排序
        int[] a={4,6,9,7,8,9,10,11,12};
        System.out.println(Arrays.toString(a));
        for(int i=a.length/2-1;i>=0;i--){
            adjustHeap(a,i,a.length);
        }
        for (int j=a.length-1;j>=0;j--){
            System.out.println(Arrays.toString(a)+"====2.1");
            swap(a,0,j);
            System.out.println(Arrays.toString(a)+"====2.2");
            adjustHeap(a,0,j);
            System.out.println(Arrays.toString(a)+"====2.3");
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
            if (j+1<length&&a[j]<a[j+1]){
                j++;
            }
            if(a[j]>temp){
                a[i]=a[j];
                i=j;
            }else{
                break;
            }
        }
        a[i]=temp;
    }


}
