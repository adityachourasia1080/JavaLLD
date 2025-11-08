package LLD.Cache.LRU;

import java.util.HashMap;

//VV IMPT
// head --------> tail
//new element i.e the most recent element are inserted at front and the element
// that has to be removed(LRU) is at last

class LRUCache {
    class Node{
        int key;
        int value;
        Node next;
        Node prev;
        Node(int key,int value){
            this.key=key;
            this.value= value;
            this.next= null;
            this.prev=null;
        }
    }

    HashMap<Integer,Node> mp;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity= capacity;
        head=new Node(-1,-1);
        tail= new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
        mp= new HashMap<>();
    }

    public int get(int key) {

        if (mp.containsKey(key)){
            Node temp= mp.get(key);
            int value= temp.value;
            deleteNode(key);
            addNode(key,value);
            return value;
        }

        return -1;

    }

    private void deleteNode(int key){
        Node curr= mp.get(key);
        Node prev= curr.prev;
        Node next= curr.next;
        next.prev=prev;
        prev.next=next;
        mp.remove(key);
    }

    private void addNode(int key,int value){
        Node temp= head.next;
        Node curr= new Node(key,value);
        head.next=curr;
        curr.prev=head;
        temp.prev=curr;
        curr.next=temp;
        mp.put(key,curr);
    }

    public void put(int key, int value) {
        if(mp.containsKey(key)){
            deleteNode(key);
            addNode(key,value);
        }else if (mp.size()==capacity){
            int leastUsed= mp.get(tail.prev.key).key;
            deleteNode(leastUsed);
            addNode(key,value);
        }
        else {addNode(key,value);}
    }
}
