class Twitter {
    private static int timeStamp=0;

    private class User{
        int id;
        Set<Integer> followed;
        Tweet tweetHead;

        public User(int id){
            this.id=id;
            followed=new HashSet<>();
            followed.add(id);
            tweetHead=null;
        }
        public void follow(int id){
            followed.add(id);
        }

        public void unFollow(int id){
            if(followed.contains(id)){
                followed.remove(id);
            }
        }
        
        public void post(int id){
            Tweet tweet=new Tweet(id);
            tweet.next=tweetHead;
            tweetHead=tweet;
        }
    }

    private class Tweet{
        int id;
        int time;
        Tweet next;
        public Tweet(int id){
            this.id=id;
            this.time=timeStamp++;
            next=null;
        }
    }

    private Map<Integer, User> userMap;

    public Twitter() {
        userMap=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)){
            User user=new User(userId);
            userMap.put(userId,user);
        }

        userMap.get(userId).post(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> news=new ArrayList<>();
        if(!userMap.containsKey(userId)) return news;

        Set<Integer> followedList=userMap.get(userId).followed;
        
        Queue<Tweet> tweetHeap=new PriorityQueue<>((a,b) -> b.time - a.time);
        for(int user:followedList){
            Tweet tweet=userMap.get(user).tweetHead;
            if(tweet != null){
                tweetHeap.offer(tweet);
            }
        }


        while(!tweetHeap.isEmpty() && news.size() < 10){
            Tweet tweet=tweetHeap.poll();
            news.add(tweet.id);
            if(tweet.next != null){
                tweetHeap.offer(tweet.next);
            }
        }

        return news;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)){
            User user=new User(followerId);
            userMap.put(followerId,user);
        }
        if(!userMap.containsKey(followeeId)){
            User user=new User(followeeId);
            userMap.put(followeeId,user);
        }

        userMap.get(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(userMap.containsKey(followerId) && followerId != followeeId){
            userMap.get(followerId).unFollow(followeeId);
        } 
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */