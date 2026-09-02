class Solution {
    public boolean uniformArray(int[] nums1) {
        int n=nums1.length;
        int nums2[]=new int[n];
        boolean odd = false;
        for(int i=0;i<n;i++){
            nums2[i]=nums1[i];
            if(nums1[i]%2==1){
                odd=true;
            }
        }


        for(int i=0;i<n;i++){
            if(nums2[i]%2==0 && i==n-1){
                return true;
            }
            if(nums2[i]%2 == 0 || odd){
                continue;
            }
            break;
        }

        for(int i=0;i<n;i++){
            if(nums2[i]%2==1 && i==n-1){
                return true;
            }
            if(nums2[i]%2 == 1 || odd){
                continue;
            }
            break;
        }
        return false;
    }
}