package com.example.teamproject;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeThumbnailView;

public class HelpfulLinksScreen extends YouTubeBaseActivity {
    YouTubePlayerView mYoutubePlayerView;
    Button btnPlay;
    YouTubePlayerView mYoutubePlayerView_2;
    Button btnPlay_2;
    YouTubePlayer.OnInitializedListener mOnInitilializedListener;
    YouTubePlayer.OnInitializedListener mOnInitilializedListener_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.helpful_links_screen);

        btnPlay = (Button) findViewById(R.id.YoutubePlayBtn);
        mYoutubePlayerView = (YouTubePlayerView) findViewById(R.id.YoutubePlay);
        mYoutubePlayerView_2 = (YouTubePlayerView) findViewById(R.id.YoutubePlay_2);
        btnPlay_2 = (Button) findViewById(R.id.YoutubePlayBtn_2);

        mOnInitilializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("agdpFsKGdOE");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        mOnInitilializedListener_2 = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("V8wTyfKd-M0");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mYoutubePlayerView.initialize(YoutubeConfig.getAPIKey(), mOnInitilializedListener);
            }
        });

        btnPlay_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mYoutubePlayerView_2.initialize(YoutubeConfig.getAPIKey(), mOnInitilializedListener_2);
            }
        });
    }
}
