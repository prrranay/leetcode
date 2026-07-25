class Solution {
    List<Integer> arr;
    public int maxProduct(int n) {
       arr=new ArrayList<>();
       numArr(n);
       arr.sort(Comparator.reverseOrder());
    //    if(arr.size() == 1){
    //     return arr.get(0);
    //    }
       return arr.get(0)*arr.get(1);
    }
    public void numArr(int n){
        if(n == 0){
            return;
        }
        arr.add(n%10);
        numArr(n/10);
    }
}