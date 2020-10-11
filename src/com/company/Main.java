package com.company;

import java.util.*;

public class Main {

    public static Stack<Integer> ReverseStack(Stack<Integer> i){
        Stack<Integer> stack=new Stack<>();
        while (!i.empty()){
            stack.push(i.peek());
            i.pop();
        }
        return stack;
    }
    public static Queue<Integer> ReverseQueue(Queue<Integer> i){
        Queue<Integer> queue=new LinkedList<>();
        while (i.peek() !=null){
            queue.offer(i.peek());
            i.remove();
        }
        return queue;
    }
    public static void main(String[] args) {
        //упражнение 1
        Stack<Integer> first=new Stack<>();
        Stack<Integer> second=new Stack<>();
        Stack<Integer> firstGrave=new Stack<>();
        Stack<Integer> secondGrave= new Stack<>();
        int[] c1 =new int[]{1, 3, 5, 7, 9};
        int[] c2 =new int[]{2, 4, 6, 8, 0};
        int n=0;
        for(int i=4; i!=-1; i--){
            if (c1[i]==0) first.push(10);
            else first.push(c1[i]);
            if (c2[i]==0) second.push(10);
            else second.push(c2[i]);
        }
        boolean flag=true;
        while (flag){

            var f= first.peek();
            var s= second.peek();
            n++;
            if (f<s){
                first.pop();
                second.pop();
                secondGrave.push(s);
                secondGrave.push(f);
            }
            else {
                second.pop();
                first.pop();
                firstGrave.push(f);
                firstGrave.push(s);
            }
            if (first.isEmpty()){
                first=ReverseStack(firstGrave);
                if (first.isEmpty()) flag=false;
            }
            if (second.isEmpty()){
                second=ReverseStack(secondGrave);
                if (second.isEmpty()) flag=false;
            }
            if (n==106) {
                flag=false;
                System.out.println("botva");
            }
        }
        if (first.isEmpty()) System.out.println("second "+n);
        if (second.isEmpty()) System.out.println("first "+n);


        //упражнение 2
        Queue <Integer> first2 = new LinkedList<>();
        Queue <Integer> second2 = new LinkedList<>();
        Queue <Integer> secondGrave2 = new LinkedList<>();
        Queue <Integer> firstGrave2 = new LinkedList<>();
        for(int i=4; i!=-1; i--){
            if (c1[i]==0) first2.offer(10);
            else first2.offer(c1[i]);
            if (c2[i]==0) second2.offer(10);
            else second2.offer(c2[i]);
        }
        n=0;
        boolean flag2=true;
        while (flag2){

            var f= first2.poll();
            var s= second2.poll();
            n++;
            if (f<s){
                secondGrave2.offer(s);
                secondGrave2.offer(f);
            }
            else {
                firstGrave2.offer(f);
                firstGrave2.offer(s);
            }
            if (first2.isEmpty()){
                first2=ReverseQueue(firstGrave2);
                if (first2.isEmpty()) flag2=false;
            }
            if (second2.isEmpty()){
                second2=ReverseQueue(secondGrave2);
                if (second2.isEmpty()) flag2=false;
            }
            if (n==106) {
                flag2=false;
                System.out.println("botva");
            }
        }
        if (first2.peek()==null) System.out.println("second "+n);
        if (second2.peek()==null) System.out.println("first "+n);



        //упражнение 3
        Deque <Integer> first3 = new ArrayDeque<>();
        Deque <Integer> second3 = new ArrayDeque<>();
        for(int i=4; i!=-1; i--){
            if (c1[i]==0) first3.addFirst(10);
            else first3.addFirst(c1[i]);
            if (c2[i]==0) second3.addFirst(10);
            else second3.addFirst(c2[i]);
        }

       n=0;
        while (!first3.isEmpty() && !second3.isEmpty() && n<106){
            n++;
            if (first3.getFirst()<second3.getFirst()){
                second3.addLast(second3.pollFirst());
                second3.addLast(first3.pollFirst());
            }
            else {
                first3.addLast(first3.pollFirst());
                first3.addLast(second3.pollFirst());
            }
        }
        if (n==106) System.out.println("botva");
        if (first3.isEmpty()) System.out.println("second "+n);
        if (second3.isEmpty()) System.out.println("first "+n);



        //упражнение 4(3)
        DoublyLinkedList first4 = new DoublyLinkedList();
        DoublyLinkedList second4 = new DoublyLinkedList();
        for(int i=4; i!=-1; i--){
            if (c1[i]==0) first4.addFront(10);
            else first3.addFirst(c1[i]);
            if (c2[i]==0) second4.addFront(10);
            else second3.addFirst(c2[i]);
        }
        while (!first4.isEmpty() && !second4.isEmpty() && n<106){
            n++;
            if ((int)first4.getFront()<(int)second4.getFront()){
                second4.addEnd(second4.getFront());
                second4.addEnd(first4.getFront());
                second4.remove((int)second4.getFront());
                first4.remove((int)first4.getFront());
            }
            else {
                first4.addEnd(first4.getFront());
                first4.addEnd(second4.getFront());
                first4.remove((int)first4.getFront());
                second4.remove((int)second4.getFront());
            }
        }
        if (n==106) System.out.println("botva");
        if (first4.isEmpty()) System.out.println("second "+n);
        if (second4.isEmpty()) System.out.println("first "+n);

    }

}
