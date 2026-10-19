class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();

        for(int i=0;i<strs.length;i++){
            int[] occ=new int[26];
            String str=strs[i];
            for(int j=0;j<str.length();j++){
                char c=str.charAt(j);
                occ[c-'a']++;
            }

            StringBuilder sb=new StringBuilder("");
            for(int j=0;j<26;j++){
                sb.append("#");
                sb.append(occ[j]);
            }
            String key=sb.toString();
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(str);
        }

        List<List<String>> ans=new ArrayList<>();

        for(String key:map.keySet()){
            ans.add(map.get(key));
        }

        return ans;
    }
}