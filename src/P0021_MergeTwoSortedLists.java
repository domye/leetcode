import common.*;

public class P0021_MergeTwoSortedLists {
    // 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    // 示例 1：l1 = [1,2,4], l2 = [1,3,4] → [1,1,2,3,4,4]
    // 示例 2：l1 = [], l2 = [] → []
    // 示例 3：l1 = [], l2 = [0] → [0]
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0), tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail = tail.next = list1;
                list1 = list1.next;
            } else {
                tail = tail.next = list2;
                list2 = list2.next;
            }
        }
        // 接上剩余部分（两个中至多一个有剩余）
        tail.next = list1 != null ? list1 : list2;
        return dummy.next;
    }

    public static void main(String[] args) {
        P0021_MergeTwoSortedLists s = new P0021_MergeTwoSortedLists();
        T.eq(new int[] { 1, 1, 2, 3, 4, 4 },
                ListNode.toArraySafe(s.mergeTwoLists(ListNode.of(1, 2, 4), ListNode.of(1, 3, 4))), "示例1");
        T.eq(new int[] {},
                ListNode.toArraySafe(s.mergeTwoLists(ListNode.of(), ListNode.of())), "示例2 双空");
        T.eq(new int[] { 0 },
                ListNode.toArraySafe(s.mergeTwoLists(ListNode.of(), ListNode.of(0))), "示例3 单侧");
        T.summary();
    }
}
