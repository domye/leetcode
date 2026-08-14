import common.*;

public class P0002_AddTwoNumbers {
    // 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
    // 请你将两个数相加，并以相同形式返回一个表示和的链表。
    // 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int jinwei = 0;
        ListNode a = new ListNode(0);
        ListNode b = a;
        while (l1 != null || l2 != null || jinwei != 0) {
            int sum = jinwei;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            jinwei = sum / 10;
            a = a.next = new ListNode(sum % 10);
        }
        return b.next;

    }

    public static void main(String[] args) {
        P0002_AddTwoNumbers s = new P0002_AddTwoNumbers();
        T.eq(new int[] { 7, 0, 8 }, s.addTwoNumbers(ListNode.of(2, 4, 3), ListNode.of(5, 6, 4)).toArray(),
                "示例1 342+465=807");
        T.eq(new int[] { 0 }, s.addTwoNumbers(ListNode.of(0), ListNode.of(0)).toArray(), "示例2 0+0");
        T.eq(new int[] { 8, 9, 9, 9, 0, 0, 0, 1 },
                s.addTwoNumbers(ListNode.of(9, 9, 9, 9, 9, 9, 9), ListNode.of(9, 9, 9, 9)).toArray(), "示例3 连续进位");
        T.summary();
    }
}
