import common.*;

public class P0019_RemoveNthFromEnd {
    //    给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
    //    示例 1：head = [1,2,3,4,5], n = 2 → [1,2,3,5]
    //    示例 2：head = [1], n = 1 → []
    //    示例 3：head = [1,2], n = 1 → [1]
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        // fast 先走 n+1 步，使 slow 与 fast 之间间隔 n 个节点
        for (int i = 0; i <= n; i++)
            fast = fast.next;
        // 双指针同步后移，fast 到底时 slow 恰好指向待删节点的前一个
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next; // 跳过待删节点
        return dummy.next;
    }

    public static void main(String[] args) {
        P0019_RemoveNthFromEnd s = new P0019_RemoveNthFromEnd();
        T.eq(new int[]{1, 2, 3, 5},
                ListNode.toArraySafe(s.removeNthFromEnd(ListNode.of(1, 2, 3, 4, 5), 2)), "示例1 n=2");
        T.eq(new int[]{},
                ListNode.toArraySafe(s.removeNthFromEnd(ListNode.of(1), 1)), "示例2 删到空");
        T.eq(new int[]{1},
                ListNode.toArraySafe(s.removeNthFromEnd(ListNode.of(1, 2), 1)), "示例3 n=1");
        T.summary();
    }
}
