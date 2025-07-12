import java.util.List;

public class LinkedList {
    ListNode head;

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        };

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    
    private void print(ListNode head) {
        if (head == null) {
            System.out.println("NULL");
            return;
        }
        int count = 0;
        ListNode curr = head;
        System.out.print("HEAD -> ");
        while (curr != null && count++ <= 10) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        if(curr!=null) System.out.println("Cycle Possibility, TERMINATED");
        else System.out.println("END");
    }
    private int size(ListNode head) {
        if (head==null) return 0;
        int size = 0;
        ListNode curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        return size;
    }
    private ListNode traverse(int idx) {
        int count = 0;
        if (idx == 0 || head == null)
            return head;
        ListNode curr = head;
        while (count < idx && curr != null) {
            count++;
            curr = curr.next;
        }
        return curr;
    }
    private int search(int key) {
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            if (curr.val == key) {
                return count;
            }
            curr = curr.next;
            count++;
        }
        return -1;
    }

    private ListNode addFront(int val) {
        ListNode node = new ListNode(val);
        if (head == null) {
            head = node;
            return node;
        }
        node.next = head;
        head = node;
        return node;
    }
    private ListNode addLast(int val) {
        if (head == null) {
            return addFront(val);
        }
        ListNode node = new ListNode(val);
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = node;
        node.next = null;
        return node;
    }   
    private ListNode addMid(int val, int idx) { //provided index is within the size of LL
        if (idx == 0 || head==null) {
            return addFront(val);
        }
        int count = 0;
        ListNode curr = head;
        while (count < idx - 1 && curr.next != null) {
            curr = curr.next;
            count++;
        }

        ListNode node = new ListNode(val);
        node.next = curr.next;
        curr.next = node;

        return node;
    }
    
    private ListNode deleteFront() {
        if (head==null) return null;
        head = head.next;
        return head;
    }
    private ListNode deleteLast() {
        if (head == null || head.next == null) {
            head = null;
            return null;
        }
        ListNode curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
        return head;
    }
    private ListNode deleteMid(int idx) { //provided index is within range
        if (idx == 0 || head == null) {
            return deleteFront();
        }
        ListNode curr = traverse(idx - 1);
        curr.next = curr.next.next;
        return head;
    }

    private ListNode midNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head) {
        if (head == null || head.next==null)
            return head;
        ListNode prev = null;
        ListNode curr = head;
        while (curr!= null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    private boolean hasCycle() {
        if (head == null || head.next == null)
            return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }
    private ListNode removeCycle() {
        ListNode slow = head;
        ListNode fast = head;
        boolean flag = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            return null;
        }

        fast = head;
        ListNode prev = null;
        // start of cycle 
        while (fast != slow) {
            prev = slow;
            fast = fast.next;
            slow = slow.next;
        }

        // remove the cycle
        if (prev == null) {
            // cycle is at head, finding the last node in the cycle
            while (slow.next != fast) {
                slow = slow.next;
            }
            slow.next = null;
            return slow;
        }
        // if cycle start is not at head 
        prev.next = null;
        return slow; // returning the node point where the cycle was formed rather than the tail now
        }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode();
        ListNode counter = dummyNode;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                counter.next = list1;
                list1 = list1.next;
            } else {
                counter.next = list2;
                list2 = list2.next;
            }
            counter = counter.next;
        }
        
        counter.next = (list1 != null) ? list1 : list2;
        return dummyNode.next;
    }

    private ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode mid = midNode(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        
        return merge(left, right);
    }    

    private boolean isPalindrome() {
        if (head == null || head.next == null)
            return true;
        ListNode mid = midNode(head);
        ListNode second = reverse(mid);
        ListNode secondHead = second;
        ListNode firstHead = head;
        while (firstHead != null && secondHead != null) {
            if (firstHead.val != secondHead.val) {
                reverse(second);
                return false;
            }
            firstHead = firstHead.next;
            secondHead = secondHead.next;
        }
            
        reverse(second);
        return true;
    }

    private void zigZag() {
        if (head == null || head.next == null) return;
        ListNode second = reverse(midNode(head));
        ListNode firstHead = head;
        ListNode secondHead = second;
        while (firstHead != null && secondHead != null) {
            ListNode temp = firstHead;
            firstHead = firstHead.next;
            temp.next = secondHead;
            temp = secondHead;
            secondHead = secondHead.next;
            temp.next = firstHead;
        }
        if (firstHead != null)
        firstHead.next = null;
    }
    
    private void subReverse( int from, int to) {
        if (from == to)
            return;

        // storing the from - 1th node and the fromth node;
        ListNode prev=null;
        ListNode curr = head;
        for (int i = 0;curr!=null && i < from - 1; i++) {
            prev = curr;
            curr = curr.next;
        }
        ListNode newEnd = curr;
        ListNode last = prev;

        //now reversing the nodes "from" and "to";
        ListNode next = curr.next;
        for (int i = 0; curr != null && i < to - from + 1; i++) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null) {
                next = next.next;
            }
        }
        last.next = prev;
        newEnd.next = curr;

    }
    
    // private void reverseKgroups(ListNode head, int k) {
        
    //     ListNode prev = null;
    //     ListNode curr = head;
    //     for(int i=0)
    // }
    
    private void rotateLL(int k) {
        if (k<=0 || head == null || head.next == null)
            return;
        // getting to the last node as well as calculating the length 
        ListNode last = head;
        int len = 1;
        while (last.next != null) {
            len++;
            last = last.next;
        }
        last.next = head;

        //now goin to the node which will point to null(means k - 1th node)
        
        //for waste rotations;
        if (k > len) {
            k = k % len;
        }

        // traversing to that node
        ListNode newLast = head;
        for (int i = 0; i < len - k - 1; i++) {
            newLast = newLast.next;
        }
        head = newLast.next;
        newLast.next = null;

    }
    
    private ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null) return null;
        int size = size(head);
        if (n==1) {
            deleteLast();
            return head;
        }
        else if (n==size) {
            deleteFront();
            return head;
        }
        else{
            ListNode curr = head;
        for (int i = 0; i < size - n - 1; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
        }
        
    }
    
    
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);

        // ListNode a = new ListNode(1);
        // ListNode b = new ListNode(2);
        // ListNode c = new ListNode(3);
        // ListNode d = new ListNode(2);
        // ListNode e = new ListNode(1);
        // a.next = b;
        // b.next = c;
        // c.next = d;
        // d.next = e;
        // e.next = null;
        // ll.head = a;

        // ll.addMid(10, 2);
        // ll.deleteFront();
        // ll.deleteLast();
        // ll.deleteMid(2);
        // System.out.println(ll.traverse(2).val);
        // System.out.println(ll.size());
        // System.out.println(ll.search(3));
        // ll.reverse();
        // System.out.println(ll.hasCycle());
        // System.out.println(ll.removeCycle().val); // includes both cycle start and removing logic 
        // System.out.println(ll.isPalindrome());
        // ll.sortList();
        // ll.zigZag();
        // ll.subReverse(2,4);
        // ll.reverseKgroups();
        // ll.rotateLL(2);
        // ll.removeNthFromEnd(ll.head, 1);
        
        ll.print(ll.head);

    }

}


