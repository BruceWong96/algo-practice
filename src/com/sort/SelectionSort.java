package com.sort;

public class SelectionSort {
    public int[] selectionSort(int[] a, int length){
        int n = length;
        if(n < 1) return a;

        for (int i = 0; i < n; i++) {
            int index = i;  //最小值的索引
            int minValue = a[i];  //暂时存储最小值
            boolean flag = false;   //交换位置标志

            for (int j = i + 1; j < n; j++) {  //找到最小值
                if(a[j] < minValue){
                    minValue = a[j];
                    index = j;   //获取最小值的索引下表
                    flag = true;   //需要交换位置
                }
            }
            if (flag){
                a = swap(a, i, index); //交换位置
            }

        }
        
        return a;
    }

    static int[] swap(int [] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
        return a;
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] a = {10, 2, 3, 5, 2, 111, 32};
        int[] b = selectionSort.selectionSort(a,a.length);

        for (int k : b) {
            System.out.print(k + " ");
        }
    }
}
