class LRUCache {
    private class Node {
        Node prev;
        Node next;
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private int cap;
    private Node right;
    private Node left;
    private Map<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.right = new Node(0, 0);
        this.left = new Node(0, 0);
        this.cap = capacity;

        this.right.prev = left;
        this.left.next = right;
    }

    private void remove(Node node){
        Node next=node.next;
        Node prev=node.prev;
        prev.next=next;
        next.prev=prev;
    }

    private void insert(Node node){
        Node mru=this.right.prev;
        mru.next=node;
        node.prev=mru;
        node.next=this.right;
        this.right.prev=node;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
            Node newNode = new Node(key, value);
            insert(newNode);
            cache.put(key, newNode);
            return;
        }

        if (cache.size() == cap) {
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
        Node newNode = new Node(key, value);
        insert(newNode);
        cache.put(key, newNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */