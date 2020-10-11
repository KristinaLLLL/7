package com.company;

public class ListNode<Integer> {
    Integer data;
    ListNode<Integer> next;
    ListNode<Integer> prev;

    ListNode(Integer data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
    ListNode(ListNode<Integer> prev,Integer data, ListNode<Integer> next) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
