class Bucket {
    private List<Integer> container;

    public Bucket() {
        container = new LinkedList<>();
    }

    public void insert(int value) {
        int idx = container.indexOf(value);

        if (idx == -1) {
            container.addFirst(value);
        }
    }

    public void remove(int value) {
        int idx = container.indexOf(value);
        
        if(idx != -1){
            container.remove(idx);
        }
    }

    public boolean contains(int value){
        return container.indexOf(value) == -1 ? false : true;
    }
}

class MyHashSet {
    int numBuckets = 769;
    
    Bucket[] buckets;
    public MyHashSet() {
        buckets=new Bucket[numBuckets];

        for(int i=0;i<numBuckets;i++){
            buckets[i]=new Bucket();
        }
    }
    
    private int getIndex(int key){
        return key%numBuckets;
    }
    public void add(int key) {
        int idx=getIndex(key);

        buckets[idx].insert(key);
    }

    public void remove(int key) {
        int idx=getIndex(key);
        buckets[idx].remove(key);
    }

    public boolean contains(int key) {
        int idx=getIndex(key);
        return buckets[idx].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */