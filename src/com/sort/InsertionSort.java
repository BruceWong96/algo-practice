package com.sort;

public class InsertionSort {
    public int[] insertionSort(int[] a, int length){
        int n = length;
        if(n < 1) return a;

        //查找插入位置
        for(int i=0 ; i < n; i++){
            int value = a[i];
            int j = i - 1;

            //查找插入位置
            for (; j >= 0; j--) {  //数据移动
                if(a[j] > value){
                    a[j+1] = a[j];
                }else {
                    break;
                }
            }

            a[j+1] = value;  //插入数据
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {10,2,3,5,6,3,2,1,0};
        InsertionSort insertionSort = new InsertionSort();
        int[] b = insertionSort.insertionSort(a, a.length);
        for (int k : b) {
            System.out.print(k + " ");
        }
    }
}
