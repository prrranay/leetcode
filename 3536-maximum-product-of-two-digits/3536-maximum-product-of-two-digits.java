class Solution {
    Queue<Integer> arr;
    public int maxProduct(int n) {
       arr=new PriorityQueue<>(Collections.reverseOrder());
       numArr(n);
       return arr.poll()*arr.poll();
    }
    public void numArr(int n){
        if(n == 0){
            return;
        }
        arr.offer(n%10);
        numArr(n/10);
    }
}