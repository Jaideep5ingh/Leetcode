package com.company.dataStructures.implementations;

public class MyCircularQueue {
    int[] circularQueue;
    int head;
    int tail;
    int size;

    public MyCircularQueue(int k) {
        this.circularQueue = new int[k];
        this.head = -1;
        this.tail = -1;
        this.size = k;
    }

    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        if(isEmpty()){
            head = 0;
        }
        tail = (tail+1) % size;
        circularQueue[tail] = value;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        if(head == tail){
            head = -1;
            tail = -1;
            return true;
        }
        head = (head+1) % size;
        return true;
    }

    public int Front() {
        if(isEmpty()) return -1;
        return circularQueue[head];
    }

    public int Rear() {
        if(isEmpty()) return -1;
        return circularQueue[tail];
    }

    public boolean isEmpty() {
        if (head == -1 && tail == -1) return true;
        return false;
    }

    public boolean isFull() {
        return ((tail + 1) % size) == head;
    }
}
