class Solution {
    public String reverseWords(String s) {
        ArrayList<String> arr=new ArrayList<>();

        StringBuilder str=new StringBuilder();

        for(char c:s.toCharArray()){
            if(c == ' ' && str.length() == 0){
                continue;
            }
            if(c == ' '){
                arr.add(str.toString());
                str=new StringBuilder();
                continue;
            }

            str.append(c);
        }

        if(str.length() > 0){
            arr.add(str.toString());
        }

        str= new StringBuilder();
        for(int  i =arr.size()-1;i>=0;i--){
            str.append(arr.get(i));
            if(i != 0){
                str.append(' ');
            }
        }

        return str.toString();
    }
}