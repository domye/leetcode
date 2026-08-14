package common;

import java.util.ArrayList;
import java.util.List;

/** 单链表节点，力扣 ListNode 同款。后续链表题共用。 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    /** 由数组构造链表，如 ListNode.of(2, 4, 3)。 */
    public static ListNode of(int... vals) {
        ListNode dummy = new ListNode(0), tail = dummy;
        for (int v : vals)
            tail = tail.next = new ListNode(v);
        return dummy.next;
    }

    /** 链表转数组，便于用 T.eq(int[], ...) 断言。 */
    public int[] toArray() {
        int n = 0;
        for (ListNode p = this; p != null; p = p.next) n++;
        int[] a = new int[n];
        int i = 0;
        for (ListNode p = this; p != null; p = p.next) a[i++] = p.val;
        return a;
    }

    /** null 安全版 toArray：结果可能为 null（如删空）时返回空数组，便于 T.eq(int[],...) 断言。 */
    public static int[] toArraySafe(ListNode node) {
        return node == null ? new int[0] : node.toArray();
    }

    /** 链表转字符串，便于直观查看。 */
    public String toString() {
        List<String> parts = new ArrayList<>();
        for (ListNode p = this; p != null; p = p.next) parts.add(String.valueOf(p.val));
        return String.join(" -> ", parts);
    }
}
