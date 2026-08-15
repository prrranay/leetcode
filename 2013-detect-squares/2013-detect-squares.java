class DetectSquares {

    private Map<Integer, Map<Integer,Integer>> counts;
    public DetectSquares() {
        counts=new HashMap<>();
    }
    
    public void add(int[] point) {
        int x=point[0];
        int y=point[1];

        counts.putIfAbsent(x,new HashMap<>());
        counts.get(x).put(y,counts.get(x).getOrDefault(y,0)+1);
    }
    
    public int count(int[] point) {
        int x1=point[0],y1=point[1];
        int total=0;
        if(!counts.containsKey(x1)) return total;

        for(Map.Entry<Integer,Integer> entry:counts.get(x1).entrySet()){
            int y2=entry.getKey();
            int county2= entry.getValue();

            if(y2 == y1) continue;

            int side=Math.abs(y2-y1);

            total += countSquare(x1,y1,x1-side,y1,y2,county2);
            total += countSquare(x1,y1,x1+side,y1,y2,county2);
        }
        return total;
    }

    private int countSquare(int x1, int y1, int x3, int y3, int y2, int county2){
        if(counts.containsKey(x3)){
            Map<Integer,Integer> x3Points= counts.get(x3);

            return x3Points.getOrDefault(y1,0) * x3Points.getOrDefault(y2,0) * county2;
        }
        return 0;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */