import java.util.*;

public class MyCircularQueue {

    int[] data;
    int size;
    int front;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        
        this.data = new int[k];
        this.size = 0;
        this.front = 0;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        
        if(this.size == this.data.length){
            return false;
        }

        this.data[(this.front + this.size) % this.data.length] = value;
        this.size++;

        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        
        if(this.size == 0){
            return false;
        }

        this.front = (this.front + 1) % this.data.length;
        this.size--;

        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        
        if(this.size == 0){
            return -1;
        }

        return this.data[this.front];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        
        if(this.size == 0){
            return -1;
        }

        return this.data[(this.front + this.size - 1) % this.data.length];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        
        return this.size == 0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        
        return this.size == this.data.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */