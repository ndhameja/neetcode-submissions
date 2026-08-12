class LRUCache {

    int capacity;
    HashMap<Integer, Node> map;
    Node head, tail;
    

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.prev=null;
        tail.next=null;
        this.capacity=capacity;
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node==null)
            return -1;
        moveToTail(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node!=null){
            node.value=value;
            moveToTail(node);
        }else{
            node = new Node();
            node.key=key;
            node.value=value;
            if(map.size()==capacity){
                popFromHead();
            }
            addToTail(node);
            map.put(key,node);
        }
        
    }

    private void moveToTail(Node node){
        removeNode(node);
        addToTail(node);
    }
    private void removeNode(Node node){
        Node prev= node.prev;
        Node next = node.next;
        prev.next=next;
        next.prev=prev;
        node.prev=null;
        node.next=null;
    }
    private void addToTail(Node node){
        Node temp = tail.prev;
        temp.next=node;
        node.prev=temp;
        node.next=tail;
        tail.prev=node;
    }

    private void popFromHead(){
        Node node = head.next;
        removeNode(node);
        map.remove(node.key);
    }

    class Node{
        Node prev, next;
        int key, value;
    }
}
