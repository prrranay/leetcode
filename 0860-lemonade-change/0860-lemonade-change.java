class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] wallet=new int[2];

        for(int bill:bills){
            if(bill == 5){
                wallet[0]++;
            }else if(bill == 10){
                if(wallet[0] >= 1){
                    wallet[0]--;
                    wallet[1]++;
                }else{
                    return false;
                }
            }else{
                if(wallet[1] >= 1){
                    if(wallet[0] >= 1){
                        wallet[1]--;
                        wallet[0]--;
                        continue;
                    }
                }

                if(wallet[0] >= 3){
                    wallet[0]-=3;
                }else{
                    return false;
                }
            }
        }

        return true;
    }
}