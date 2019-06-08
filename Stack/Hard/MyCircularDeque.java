import java.util.*;


public class MyCircularDeque {
 int[] data;
    int front;
    int size;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        
        this.data = new int[k];
        this.front = 0;
        this.size = 0;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
            
        if(this.size == this.data.length){
            return false;
        }

        if(this.size == 0){
            this.data[front] = value;
        }else{
            
            if(this.front == 0){
                this.front = this.data.length - 1;
            }else{

                this.front = (this.front - 1) % this.data.length;
                this.data[front] = value;
            }
        }
        
        this.size++;

        return true;

    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        
        if(this.size == this.data.length){
            return false;
        }

        this.data[(this.front + this.size) % this.data.length] = value;
        this.size++;
        
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        
        if(this.size == 0){
            return false;
        }

        int x = this.data[this.front];
        this.front = (this.front + 1) % this.data.length;
        this.size--;
    
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        
        if(this.size == 0){
            return false;
        }

        this.size--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        
        if(this.size == 0){
            return -1;
        }

        int x = this.data[this.front];
        return x;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        
        if(this.size == 0){
            return -1;
        }

        return this.data[(this.front + this.size - 1) % this.data.length];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        
        return this.size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        
        return this.size == this.data.length;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */