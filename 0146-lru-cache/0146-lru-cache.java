class LRUCache {

    private List<int[]> list;
    private int cap;
    public LRUCache(int capacity) {
        this.list=new ArrayList<>();
        this.cap=capacity;
    }
    
    public int get(int key) {
        for(int i=0;i<list.size();i++){
            if(list.get(i)[0] == key){
                int[] temp=list.remove(i);
                list.add(temp);
                return temp[1];
            }
        }
        return -1;
    }
    
    public void put(int key, int value) {
        for(int i=0;i<list.size();i++){
            if(list.get(i)[0] == key){
                int[] temp=list.remove(i);
                temp[1]=value;
                list.add(temp);
                return;
            }
        }

        if(cap == list.size()){
            list.remove(0);
        }

        list.add(new int[]{key,value});
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */