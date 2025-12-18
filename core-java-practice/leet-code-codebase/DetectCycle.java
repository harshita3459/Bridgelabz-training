package leet_code_codebase;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DetectCycle {

    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;         
            fast = fast.next.next;    

            if (slow == fast) {
                return true;        
            }
        }
        return false;              
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        // Create a cycle
        head.next.next.next.next = head.next;

        System.out.println(hasCycle(head)); 
    }
}
