package pl.devcrowd.logic;

import pl.devcrowd.model.Tweet;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Singleton
public class Tweeter {

    private List<Tweet> tweets = Collections.synchronizedList(new ArrayList<Tweet>());

    public void addTweet(Tweet tweet) {
        tweets.add(tweet);
    }

    public List<Tweet> getTweets() {
        return Collections.unmodifiableList(tweets);
    }
}
