class Node{

    int data;
    Node next;

    public Node(int x){ this.data = x; }
}

public class MyLinkedList {

    Node head;
    Node tail;
    int size = 0;

    /** Initialize your data structure here. */
    public MyLinkedList() {

        this.head = new Node(0);
        this.tail = new Node(0);
        this.size = 0;
        
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= this.size){
            return -1;
        }

        Node temp = this.head;

        for(int i = 0;i < index;i++){
    
            System.out.println(temp.data);
            temp = temp.next;
        }

        return temp.data;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        
        Node nn = new Node(val);
        if(this.size == 0){

            this.head = nn;
            this.tail = nn;
        }else{

            nn.next = this.head;
            this.head = nn;
        }

        this.size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        
        Node nn = new Node(val);

        if(this.size == 0){
            this.head = nn;
            this.tail = nn;
        }else{

            this.tail.next = nn;
            this.tail = nn;
        }

        this.size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        
        if(index < 0 || index > this.size){
            return;
        }
        
        if(index == 0){

            addAtHead(val);
        }else if(index == size - 1){
            addAtTail(val);
        }else{

            Node temp = this.head;
            Node nn = new Node(val);
            for(int i = 0;i < index - 1;i++){
                temp = temp.next;
            }
            Node save = temp.next;
            temp.next = nn;
            temp.next = nn;
            nn.next = save;
            
           
            this.size++;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        
        if(index < 0 || index >= this.size){
            return;
        }

        if(index == 0){
            this.head = this.head.next;
        }

        Node temp = this.head;

        for(int i =  0;i < index - 1;i++){
            temp = temp.next;
        }

        if(index == this.size - 1){
            temp.next = null;
        }else{

            Node save = temp.next;
            temp.next = temp.next.next;
        }

        this.size--;
    }
}