import java.util.*;
public class Cycle {
    public static class Node{
        int data;
        Node next;
        public Node (int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head = null;

    public static boolean isCycle(){
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow =slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
public static void main(String args[])
{
    head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(5);
    head.next.next.next.next.next = head.next;

    System.out.println(isCycle());

   

}

}
