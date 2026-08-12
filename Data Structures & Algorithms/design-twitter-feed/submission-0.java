class Twitter {
    private static int timestamp = 0;
    private Map<Integer, User> userMap;

    public Twitter() {
        userMap = new HashMap<>();
    }
    private void createUserIfAbsent(int userId) {
        userMap.putIfAbsent(userId, new User(userId));
    }
    
    public void postTweet(int userId, int tweetId) {
        createUserIfAbsent(userId);
        userMap.get(userId).post(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        if (!userMap.containsKey(userId)) {
            return feed;
        }

        Set<Integer> followedUsers = userMap.get(userId).followed;
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time);

        // Put the head tweet of each followed user into the heap
        for (int followeeId : followedUsers) {
            User followee = userMap.get(followeeId);
            if (followee != null && followee.tweetHead != null) {
                maxHeap.add(followee.tweetHead);
            }
        }

        // Retrieve up to 10 most recent tweets
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            Tweet curr = maxHeap.poll();
            feed.add(curr.id);
            count++;
            
            // If this user has more tweets, put the next one into the heap
            if (curr.next != null) {
                maxHeap.add(curr.next);
            }
        }

        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        createUserIfAbsent(followerId);
        createUserIfAbsent(followeeId);
        userMap.get(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        createUserIfAbsent(followerId);
        createUserIfAbsent(followeeId);
        userMap.get(followerId).unfollow(followeeId);
    }
    private class Tweet {
        int id;
        int time;
        Tweet next;

        Tweet(int id) {
            this.id = id;
            this.time = timestamp++;
            this.next = null;
        }
    }

    private class User {
        int id;
        Set<Integer> followed;
        Tweet tweetHead; // Head of user's linked list of tweets (most recent)

        User(int id) {
            this.id = id;
            this.followed = new HashSet<>();
            follow(id); // A user always follows themselves to see their own tweets
            this.tweetHead = null;
        }

        void follow(int id) {
            followed.add(id);
        }

        void unfollow(int id) {
            // A user cannot unfollow themselves
            if (id != this.id) {
                followed.remove(id);
            }
        }

        void post(int tweetId) {
            Tweet newTweet = new Tweet(tweetId);
            newTweet.next = tweetHead; // Prepend to make it O(1) insertion
            tweetHead = newTweet;
        }
    }
}
