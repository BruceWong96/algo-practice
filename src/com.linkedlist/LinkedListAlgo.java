package com.linkedlist;

import org.junit.Test;

/**
 * 1) 单链表反转
 * 2) 链表中环的检测
 * 3) 两个有序的链表合并
 * 4) 删除链表倒数第n个结点
 * 5) 求链表的中间结点
 */
public class LinkedListAlgo {
    /**
     * 节点结构
     */
    public static class Node{
        private int data;
        private Node next;

        //构造函数
        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }

        //获取data
        public int getData(){
            return data;
        }
    }

    /**
     * 创建节点
     */
    public static Node createNode(int data){
        return new Node(data, null);
    }

    /**
     * 打印所有节点
     */
    public static void printAll(Node list){
        Node p = list;
        while (p != null){
            System.out.print(p.getData() + " ");
            p = p.next;
        }
        System.out.println();
    }

    /**
     *   1.单链表的反转
     */
    public static Node reverse(Node list){
        Node curNode = list;   //curNode指向当前节点
        Node nextNode = null;
        Node preNode = null;
        while (curNode != null){
            nextNode = curNode.next; //nextNode 指向当前节点的下一个节点
            curNode.next = preNode;  //当前节点的next指向上一个节点
            preNode = curNode;  //pre指针后移
            curNode = nextNode; //当前指针后移
        }
        return preNode;
    }

    /**
     * 反转链表的测试
     */
    @Test
    public void testReverseList() {
        Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        System.out.println("反转之前的链表：");
        LinkedListAlgo.printAll(node1);

        System.out.println("反转之后的链表：");
        Node reversedList = LinkedListAlgo.reverse(node1);
        LinkedListAlgo.printAll(reversedList);
    }

    /**
     * 2.链表中环的检测
     */
    public static boolean checkCircle(Node list){
        if (list == null){   //链表为空则返回false
            return false;
        }
        Node slow = list;    //慢指针指向当前节点
        Node fast = list.next;  //快指针指向当前节点的下一个节点
        while (slow != fast){   //慢指针与快指针不相等，则继续循环
            if (slow == null || fast == null){      //如果快指针或者慢指针到达了null则表示遍历完毕，没有环
                return false;
            }
            slow = slow.next;       //慢指针每次移动1步
            fast = fast.next.next;  //快指针每次移动2步
        }
        return true;       //跳出循环则表示快指针与慢指针相等了，则表示有环
    }

    /**
     * 测试链表中环的检测
     */
    @Test
    public void testcCheckCircle() {
        Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);

        System.out.println("无环链表：");
        LinkedListAlgo.printAll(node1);
        Boolean flag = LinkedListAlgo.checkCircle(node1);
        System.out.println(flag);

        node5.next = node3;

        System.out.println("有环链表：");
        flag = LinkedListAlgo.checkCircle(node1);
        System.out.println(flag);
    }



}
