/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode prev = head;
        ListNode current = head.next;
        prev.next = null;

        // 为什么结束条件是这个？current、pre一次往后移动一个，一定会在某个时刻，current移出去了，这时候就返回pre（pre在里面）
        // 为什么不是pre.next? pre.next指向的是前面的那个，通过上一次循环的连接，上次的current.next一定不是null
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    /*public ListNode reverseList(ListNode head) {
      if (head == null) {
         return null;
      }
        // 1 -> 2 -> 3 -> 4 -> 5
        //prev = 1
        // current = 2;
      ListNode prev = head;
      ListNode current = head.next;
        // 1  2 -> 3 -> 4 -> 5
        // prev = 1
        // current = 2;
      prev.next = null;
      while (current != null) {
          // First time
          *//*
          next = 3
          1  <- 2  3 -> 4 -> 5
          prev = 2
          current = 3
          *//*
          // Second time
          *//*
          next = 4
          1  <- 2 <- 3  4 -> 5
          prev = 3
          current = 4
          *//*
          // third time
          *//*
          next = 5
          1  <- 2 <- 3 <- 4 5
          prev = 4
          current = 5
          *//*
          // fourth time
          *//*
          next = null
          1  <- 2 <- 3 <- 4 <-5
          prev = 5
          current = null
          *//*
          ListNode next = current.next;
          current.next = prev;
          prev = current;
          current = next;
      }
        //exit
        //return prev = 5
      return prev;
    }*/
}