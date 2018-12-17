package com.manikshakya.videodemo;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.VideoView;

public class MainActivity extends Activity{



    MediaPlayer myMedia;
    int length = 0;

    public void playMedia(View view){
        myMedia = MediaPlayer.create(this, R.raw.laughter);

        myMedia.seekTo(length);
        myMedia.start();



    }
    public void pauseMedia(View view){

        myMedia.pause();
        length = myMedia.getCurrentPosition();

    }



    SeekBar myBar;
    AudioManager volumeControl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        VideoView myVideo = (VideoView) findViewById(R.id.myVideo);

        myVideo.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video1);

        MediaController media = new MediaController(this);

        media.setAnchorView(myVideo);

        myVideo.setMediaController(media);

        myVideo.start();
        */

        myBar = (SeekBar) findViewById(R.id.progressBar);
        volumeControl = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int maxVolume = volumeControl.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentVolume = volumeControl.getStreamVolume(AudioManager.STREAM_MUSIC);

        myBar.setMax(maxVolume);
        myBar.setProgress(currentVolume);

        myBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //Log.i("Progress", Integer.toString(i));
                volumeControl.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);
            }
        });


    }





}
