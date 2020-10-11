package com.company;

import java.util.NoSuchElementException;

public class DoublyLinkedList<Integer> {
    private ListNode<Integer> front;
    private int size;

    public DoublyLinkedList() {
        front = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFront(Integer x) {
        if (isEmpty())
            front = new ListNode<Integer>(x);
        else {
            ListNode<Integer> temp = front;
            front = new ListNode<Integer>(null, x, temp);
            front.next.prev = front;
        }
        size++;
    }

    public void addEnd(Integer x) {
        if (isEmpty())
            front = new ListNode<Integer>(x);
        else {
            ListNode<Integer> temp = front;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode<Integer>(temp, x, null);
        }
        size++;
    }
    public Integer getFront(){
        return front.data;
    }
    public void remove(int x) {
        if (isEmpty())
            throw new NoSuchElementException("Element not found");

        // Removing front element
        if (front.data.equals(x)) {
            front = front.next;
            return;
        }
        ListNode<Integer> current = front;

        // Looping through until found
        while (current != null && !current.data.equals(x))
            current = current.next;

        // If null, not found
        if (current == null)
            throw new NoSuchElementException("Element not found");

        // It has a next pointer, so not the last node.
        if (current.next != null)
            current.next.prev = current.prev;

        current.prev.next = current.next;

        size--;
    }
}
