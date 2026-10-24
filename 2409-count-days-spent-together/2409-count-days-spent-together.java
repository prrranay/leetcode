class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        int prefix[]= new int[months.length+1];
        for(int i=1;i<months.length+1;i++){
            prefix[i]=prefix[i-1]+months[i-1];
        }
        
        int arriveAliceDay = calc(arriveAlice, prefix);
        int leaveAliceDay = calc(leaveAlice, prefix);
        int arriveBobDay = calc(arriveBob, prefix);
        int leaveBobDay = calc(leaveBob, prefix);
        return Math.max(
            0,
            Math.min(leaveAliceDay, leaveBobDay) -
                Math.max(arriveAliceDay, arriveBobDay) +
                1
        );
    }

    public int calc(String date, int[] pre){
        int month= Integer.parseInt(date.substring(0, 2));
        int dat= Integer.parseInt(date.substring(3));
        return pre[month-1]+dat;
    }
}