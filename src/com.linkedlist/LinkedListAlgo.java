package com.linkedlist;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

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
     * 1.单链表的反转
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

    /**
     * 3.两个有序的链表合并
     */
    public static Node mergeTwoLists(Node list1, Node list2){
        Node soldier = new Node(0,null);  //设置哨兵链表
        Node p = soldier;  //设置工作指针指向哨兵

        while(list1 != null && list2 != null){   //只要有一个链表遍历完 就结束循环
            if(list1.data < list2.data){  //若链表1的值较小
                p.next = list1;            //将链表1的节点放入p链表
                list1 = list1.next;     //链表1后移一个节点
            }else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;   //移动工作指针
        }
        //结束循环后，链表1还有多余的节点，则此时p的指针域指向链表1
        if (list1 != null){
            p.next = list1;
        }
        //结束循环后，链表2还有多余的节点，则此时p的指针域指向链表2
        if (list2 != null){
            p.next = list2;
        }
        //返回哨兵节点的下一个节点即为结果（因为第一个节点为0）
        return soldier.next;

    }

    /**
     * 测试两个有序的链表合并
     */
    @Test
    public void testMergeTwoLists(){
        Node node9 = new Node(9, null);
        Node node7 = new Node(7, node9);
        Node node5 = new Node(5, node7);
        Node node3 = new Node(3, node5);
        Node node1 = new Node(1, node3);

        Node node10 = new Node(10, null);
        Node node8 = new Node(8, node10);
        Node node6 = new Node(6, node8);
        Node node4 = new Node(4, node6);
        Node node2 = new Node(2, node4);

        System.out.print("合并前的链表1：");
        LinkedListAlgo.printAll(node1);
        System.out.print("合并前的链表2：");
        LinkedListAlgo.printAll(node2);
        Node mergedTwoLists = LinkedListAlgo.mergeTwoLists(node1, node2);
        System.out.print("合并后的新链表：");
        LinkedListAlgo.printAll(mergedTwoLists);
    }

    /**
     * 4.删除链表倒数第n个结点
     */
    public static Node removeLastKth(Node head, int n){
        Node soldier = new Node(0,head);   //设置哨兵协助

        Node first = soldier, second = soldier;   //设置第一个节点

        for (int i = 0 ; i <= n; i ++){   //使first指针-second指针 = n+1
            first = first.next;
        }

        while (first != null){          //一旦first移动到了尾节点的null指针域，就结束
            first = first.next;         //移动first
            second = second.next;       //移动second
        }   //这样是为了使second移动到要删除节点的上一个节点

        //删除节点操作
        second.next = second.next.next;

        //返回去除虚拟头节点的链表即可
        return soldier.next;
    }

    /**
     * 测试删除链表倒数第n个结点
     */
    @Test
    public void testRemoveLastKth(){
        Node node9 = new Node(9, null);
        Node node7 = new Node(7, node9);
        Node node5 = new Node(5, node7);
        Node node3 = new Node(3, node5);
        Node node1 = new Node(1, node3);

        System.out.print("删除前的链表：");
        LinkedListAlgo.printAll(node1);

        Node newNode1 = LinkedListAlgo.removeLastKth(node1,3);
        System.out.print("删除后的链表：");
        LinkedListAlgo.printAll(newNode1);

    }
}
