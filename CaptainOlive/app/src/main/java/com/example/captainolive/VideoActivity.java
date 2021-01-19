package com.example.captainolive;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        videoView = findViewById(R.id.video_view);
        //String youtubeURL = getIntent().getStringExtra("youtubeURL");
        MediaController mediaController = new MediaController(this);
        //mediaController.setAnchorView(videoView);
        Uri uri = Uri.parse("https://animoto.com/make/cooking-videos");
        //videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        //videoView.setVideoPath("https://file-examples-com.github.io/uploads/2017/04/file_example_MP4_1280_10MG.mp4");
        //videoView.setVideoPath("http://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4");
        videoView.setMediaController(mediaController);
        videoView.requestFocus();
        videoView.start();
    }
}