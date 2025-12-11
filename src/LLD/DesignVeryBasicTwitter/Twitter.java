package LLD.DesignVeryBasicTwitter;

import java.util.*;

class Twitter {

    // Inner class representing a Tweet with its creation time and ID
    class Tweet {
        public int time;
        public int tweetId;

        Tweet(int time, int tweetId) {
            this.time = time;      // global timestamp to maintain order
            this.tweetId = tweetId;
        }
    }

    int time;   // global counter to simulate timestamps
    HashMap<Integer, List<Tweet>> mapping;   // userId -> list of tweets
    HashMap<Integer, Set<Integer>> follows;  // followerId -> set of followeeIds

    public Twitter() {
        time = 0;
        mapping = new HashMap<>();  // stores tweets of each user
        follows = new HashMap<>();  // stores follow relationships
    }

    // A user posts a tweet
    public void postTweet(int userId, int tweetId) {

        // if user has not tweeted before, create an empty list
        mapping.putIfAbsent(userId, new ArrayList<>());

        // add new tweet with increasing timestamp
        mapping.get(userId).add(new Tweet(time++, tweetId));
    }

    // Fetch the 10 most recent tweets in the user's news feed
    public List<Integer> getNewsFeed(int userId) {

        // Users whose tweets should appear: user itself + followees
        Set<Integer> users = new HashSet<>();
        List<Tweet> candidates = new ArrayList<>();

        users.add(userId);   // user sees their own tweets

        // add all followees of current user
        users.addAll(follows.getOrDefault(userId, new HashSet<>()));

        // For each relevant user, collect up to their last 10 tweets
        for (int usr : users) {

            List<Tweet> list = mapping.getOrDefault(usr, new ArrayList<>());

            int size = list.size();

            // Fetch only last 10 tweets — since they are most recent
            int start = Math.max(0, size - 10);

            for (int i = start; i < size; i++) {
                candidates.add(list.get(i));
            }
        }

        // Sort all tweets from all users by time DESC (latest first)
        candidates.sort((a, b) -> b.time - a.time);

        // Prepare the final list of max 10 tweet IDs
        List<Integer> recent = new ArrayList<>();
        for (int i = 0; i < Math.min(10, candidates.size()); i++) {
            recent.add(candidates.get(i).tweetId);
        }

        return recent;
    }

    // followerId starts following followeeId
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return; // cannot follow yourself

        // ensure follower entry exists in map
        follows.putIfAbsent(followerId, new HashSet<>());

        // add followee
        follows.get(followerId).add(followeeId);
    }

    // followerId stops following followeeId
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return; // cannot unfollow yourself

        if (follows.containsKey(followerId)) {
            follows.get(followerId).remove(followeeId);
        }
    }
}
