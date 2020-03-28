package com.sort;

/**
 * 冒泡排序法
 */
public class BubbleSort {
    private int[]  bubbleSort(int[] a, int n){
        if(n <= 1){
            return a;
        }

        for(int i = 0; i < n; i++){
            boolean flag = false;   // 提前退出冒泡循环的标志位
            for (int j = 0; j < n - i - 1; j++){
                if(a[j] > a[j+1]){   // 交换
                    int tmp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = tmp;
                    flag = true;   // 表示有数据交换
                }
            }
            if(!flag){   // 没有数据交换，提前退出
                break;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {4, 4, 5, 6, 7, 8, 1, 2, 3};
        BubbleSort bubbleSort = new BubbleSort();
        int[] b = bubbleSort.bubbleSort(a, a.length);
        for (int k: b) {
            System.out.print(k + " ");
        }
    }
}
