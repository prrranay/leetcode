class Bucket {
    class Pair {
        public int key;
        public int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    List<Pair> container;

    public Bucket() {
        container = new LinkedList<>();
    }

    public int get(int key) {
        for (Pair i : container) {
            if (i.key == key) {
                return i.value;
            }
        }
        return -1;
    }

    public void put(int key, int value) {
        for (Pair i : container) {
            if (i.key == key) {
                i.value=value;
                return;
            }
        }
        container.addFirst(new Pair(key, value));
    }

    public void remove(int key) {
        for (Pair i : container) {
            if (i.key == key) {
                container.remove(i);
                return;
            }
        }
    }
}

class MyHashMap {
    int numBuckets=769;
    Bucket[] buckets;

    public MyHashMap() {
        buckets=new Bucket[numBuckets];
        
        for(int i=0;i<numBuckets;i++){
            buckets[i]=new Bucket();
        }
    }

    public int getIndex(int key){
        return key%numBuckets;
    }

    public void put(int key, int value) {
        int idx=getIndex(key);

        buckets[idx].put(key,value);
    }

    public int get(int key) {
        int idx=getIndex(key);
        return buckets[idx].get(key);
    }

    public void remove(int key) {
        int idx=getIndex(key);
        buckets[idx].remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */