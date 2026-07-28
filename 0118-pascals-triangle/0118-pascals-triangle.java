class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans= new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.get(0).add(1);

        for(int row=1; row<numRows ; row++){
            List<Integer> curr=new ArrayList<>();
            List<Integer> prev=ans.get(row-1);

            curr.add(1);
            for(int i=1; i<row;i++){
                curr.add(prev.get(i-1)+prev.get(i));
            }
            curr.add(1);
            ans.add(curr);
        }

        return ans;
    }
}