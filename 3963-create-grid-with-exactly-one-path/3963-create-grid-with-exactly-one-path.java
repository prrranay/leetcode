class Solution {
    public String[] createGrid(int m, int n) {
        List<String> list=new ArrayList<>();

        for(int i=0;i<m;i++){
            StringBuilder st=new StringBuilder();

            for(int j=0;j<n;j++){
                if(j == 0 ||  i == m-1){
                    st.append(".");
                }else{
                    st.append("#");
                }
            }
            list.add(st.toString());
        }

        return list.toArray(new String[0]);
    }
}