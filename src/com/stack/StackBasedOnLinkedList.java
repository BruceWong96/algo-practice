package com.stack;

/**
 * 基于链表实现的栈
 */
public class StackBasedOnLinkedList {
    //初始化空栈
    private Node top = null;
    /**
     * 链表节点结构
     */
    private static class Node{
        private int data;
        private Node next;
        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
        public int getData(){
            return data;
        }
    }

    /**
     * 栈的push操作
     * @param x
     */
    public void push(int x){
        Node newNode = new Node(x, null);
        if (top == null){
            top = newNode;
        }else {
            newNode.next = top;
            top = newNode;
        }
    }

    /**
     * 栈的pop操作
     * @return
     */
    public int pop(){
        if (top == null){
            return -1;
        }
        int value = top.getData();
        top = top.next;
        return value;
    }

    /**
     * 打印输出所有节点
     */
    public void printAll(){
        Node p = top;
        if (p == null){
            System.out.println("Stack is empty!");
        }
        while (p != null){
            System.out.println(p.getData());
            p = p.next;
        }
        System.out.println();
    }
}
