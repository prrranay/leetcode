class Solution {
    static class Point{
        int index;
        int distance;

        Point(int index,int distance){
            this.index=index;
            this.distance=distance;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        boolean[] visited= new boolean[n]; 
        Queue<Point> q=new PriorityQueue<>((a,b) -> a.distance - b.distance);

        q.offer(new Point(0,0));

        int cost=0;
        int pointsConnected=0;
        while(pointsConnected < n){
            Point current=q.poll();
            if(visited[current.index]) continue;
            visited[current.index]=true;
            cost+=current.distance;
            pointsConnected++;

            for(int i=0;i<n;i++){
                if(!visited[i]){
                    int distance= Math.abs(points[current.index][0]-points[i][0])+Math.abs(points[current.index][1]-points[i][1]);
                    q.offer(new Point(i,distance));
                }
            }
        }
        return cost;
    }
}