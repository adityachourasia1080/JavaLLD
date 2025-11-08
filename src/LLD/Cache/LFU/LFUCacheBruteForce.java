package LLD.Cache.LFU;

import java.util.HashMap;

//Brute force method where at time of insertion we do an insertion sort kind of thing in LL and insert
//it into that place
class LFUCacheBruteForce {
    class Node{
        int counter;
        int key;
        int value;
        Node next;
        Node prev;
        Node(int key,int value,int counter){
            this.counter=counter;
            this.key=key;
            this.value= value;
            this.next= null;
            this.prev=null;
        }
    }

    HashMap<Integer,Node> mp;
    int capacity;
    Node head;
    Node tail;


    public LFUCacheBruteForce(int capacity) {
        this.capacity= capacity;
        this.mp = new HashMap<>();
        head= new Node(-1,-1,Integer.MAX_VALUE);
        tail= new Node(-1,-1,0);
        head.next=tail;
        tail.prev=head;

    }

    public int get(int key) {
        if (mp.containsKey(key)){
            Node temp1= mp.get(key);
            int value= temp1.value;
            int counter= temp1.counter + 1;
            deleteNode(temp1);
            Node temp = tail;
            while(temp.counter <= counter) temp = temp.prev;
            addNode(key, value, counter, temp);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        int counter = 1;
        if (mp.containsKey(key)){
            Node curr= mp.get(key);
            counter = curr.counter + 1;
            deleteNode(curr);
        }
        else if (mp.size() == capacity){
            deleteNode(tail.prev);
        }

        Node temp = tail;
        while(temp.counter <= counter) temp = temp.prev;
        addNode(key, value, counter, temp);
    }


    private void deleteNode(Node curr){
        Node prev= curr.prev;
        Node next= curr.next;
        prev.next= next;
        next.prev= prev;
        mp.remove(curr.key);
    }

    private void addNode(int key,int value,int counter,Node temp){
        Node curr= new Node(key,value,counter);
        Node next= temp.next;
        temp.next=curr;
        curr.prev=temp;
        curr.next=next;
        next.prev=curr;
        mp.put(key,curr);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
