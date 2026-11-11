class Solution {


    public void conquer(int[] nums,int start, int mid,int end){
        int[] merged=new int[end-start+1];

        int idx1=start;
        int idx2=mid+1;
        int x=0;
        while(idx1 <=mid && idx2 <=end){
            if(nums[idx1] <= nums[idx2] ){
                merged[x++]=nums[idx1++];
            }else{
                merged[x++]=nums[idx2++];
            }
        }

        while(idx1 <=mid){
            merged[x++]=nums[idx1++];
        }
        while(idx2 <=end){
            merged[x++]=nums[idx2++];
        }


        for(int i=0,j=start;i<merged.length;i++,j++){
            nums[j]=merged[i];
        }
    }

    public void divide(int[] nums,int start,int end){
        if(start>=end) return;

        int mid=start+(end-start)/2;

        divide(nums,start,mid);
        divide(nums,mid+1,end);

        conquer(nums,start,mid,end);
    }


    public int[] sortArray(int[] nums) {
        divide(nums,0,nums.length-1);
        return nums;
    }
}