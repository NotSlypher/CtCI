package Ch02_Linked_Lists;

import Lib.LinkedListNode;

public class Q1_Partition {
    static LinkedListNode Part(LinkedListNode head1, int part){
        LinkedListNode head = head1 ,tail = head1, node = head1;
        while (node != null){
            LinkedListNode next = node.next;
            if(node.data < part){
                node.next = head;
                head = node;
            }
            else{
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;
        return head;
    }

    public static void main(String[] args) {
        int length = 20;
        LinkedListNode[] nodes = new LinkedListNode[length];
        for (int i = 0; i < length; i++) {
            nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
        }

        for (int i = 0; i < length; i++) {
            if (i < length - 1) {
                nodes[i].setNext(nodes[i + 1]);
            }
            if (i > 0) {
                nodes[i].setPrevious(nodes[i - 1]);
            }
        }

        LinkedListNode head = nodes[0];
        System.out.println(head.printForward());

        LinkedListNode h = Part(head, 8);
        System.out.println(h.printForward());
    }
}
