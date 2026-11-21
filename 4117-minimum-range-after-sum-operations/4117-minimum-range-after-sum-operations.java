class Solution {
    public int minRange(int a, int b, int c) {
        int max=Math.max(a,Math.max(b,c));
        int min=Math.min(a,Math.min(b,c));

        int mid=0;
        if((min == a && max== c) || (max == a && min == c) ){
            mid=b;
        }else if((max == b && min==c )|| (max == c && min == b)){
            mid=a;
        }else{
            mid=c;
        }


        if(min+mid >= max){
            return max-min;
        }

        return minRange(min,mid,min+mid);
    }
}