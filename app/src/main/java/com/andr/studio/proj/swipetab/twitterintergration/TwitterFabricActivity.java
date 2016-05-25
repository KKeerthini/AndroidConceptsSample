package com.andr.studio.proj.swipetab.twitterintergration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;

import com.andr.studio.proj.swipetab.R;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.services.StatusesService;
import com.twitter.sdk.android.tweetui.CompactTweetView;
import com.twitter.sdk.android.tweetui.LoadCallback;
import com.twitter.sdk.android.tweetui.TweetUtils;

import java.util.Arrays;
import java.util.List;

import io.fabric.sdk.android.Fabric;

/**
 * Created by CIPL0310 on 5/24/2016.
 */
public class TwitterFabricActivity extends AppCompatActivity {

    private static final String TWITTER_KEY = "";
    private static final String TWITTER_SECRET = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);

        Fabric.with(this, new Twitter(authConfig));
        setContentView(R.layout.activity_main);

        final LinearLayout myLayout = (LinearLayout) findViewById(R.id.tweets);

        final List<Long> tweetIds = Arrays.asList(531132223265992704L, 20L);

        TweetUtils.loadTweets(tweetIds, new LoadCallback<List<Tweet>>() {
            @Override
            public void success(List<Tweet> tweets) {
                for (Tweet tweet : tweets) {
                    Log.v("tweet", tweet.toString());
                    myLayout.addView(new CompactTweetView(TwitterFabricActivity.this, tweet));
                }
            }

            @Override
            public void failure(TwitterException exception) {
                Log.v("hi", exception.getMessage());
            }
        });
    }
}
