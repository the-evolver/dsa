class LRUCache {

    private static class Node{
        int key,value;
        Node prev,next;
        Node(int k,int v){
            this.key = k;
            this.value = v;
        }
    }

    private final int capacity;
    private HashMap<Integer,Node> mp = new HashMap<>();
    Node head = new Node(0,0);
    Node tail = new Node(0,0);


    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    public void remove(Node n){
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }
    public void addTop(Node n){
         n.prev = head;
         n.next = head.next;
         head.next.prev = n;
         head.next = n;

    }
    public int get(int key) {
         if(!mp.containsKey(key)) return -1;

         Node curr = mp.get(key);
         remove(curr);
         addTop(curr);
         return curr.value;
         // remove 
         // add to top
        
    }
    
    public void put(int key, int value) {
       if(mp.containsKey(key)){
            Node curr = mp.get(key);
            curr.value = value;
            mp.put(key,curr);
            remove(curr);
            addTop(curr);
            return;
       }

       if(mp.size() == capacity){
            Node Lru = tail.prev;
            remove(Lru);
            mp.remove(Lru.key);
       }

       Node newN = new Node(key,value);
       mp.put(key,newN);
       addTop(newN);

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */