class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        ArrayList<Integer> arr=new ArrayList<>();

        int first=0;
        int second=0;

        while(first < m && second < n){
            if(nums1[first] <= nums2[second]){
                arr.add(nums1[first]);
                first++;
            }else{
                arr.add(nums2[second]);
                second++;
            }
        }

        while(first<m){
            arr.add(nums1[first]);
            first++;
        }
        while(second<n){
            arr.add(nums2[second]);
            second++;
        }

        for(int i=0;i<nums1.length;i++){
            nums1[i]=arr.get(i);
        }
    }
}