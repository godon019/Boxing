package com.example.user.boxing.RecordAudioStuff;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by user on 2016-11-27.
 */
public class Recording {

    MediaPlayer player;
    MediaRecorder recorder;

    int playbackPosition = 0;

    Activity activity;
    public Recording(Activity activity){
        this.activity = activity;
    }

    public void record(String fileNameWithPath){
        if(recorder != null){
            recorder.stop();
            recorder.release();
            recorder = null;
        }// TODO Auto-generated method stub
        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
        recorder.setOutputFile(fileNameWithPath);
        try{
            Toast.makeText(activity.getApplicationContext(),
                    "녹음을 시작합니다.", Toast.LENGTH_LONG).show();
            recorder.prepare();
            recorder.start();
        }catch (Exception ex){
            Log.e("SampleAudioRecorder", "Exception : ", ex);
        }
    }

    public void stop(){
        if(recorder == null)
            return;

        recorder.stop();
        recorder.release();
        recorder = null;

        Toast.makeText(activity.getApplicationContext(),
                "녹음이 중지되었습니다.", Toast.LENGTH_LONG).show();
        // TODO Auto-generated method stub
    }

    public void play(String fileNameWithPath){
        try{
            playAudio(fileNameWithPath);

            Toast.makeText(activity.getApplicationContext(), "음악파일 재생 시작됨.", Toast.LENGTH_SHORT).show();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void stopPlay(){
        if(player != null){
            playbackPosition = player.getCurrentPosition();
            player.pause();
            Toast.makeText(activity.getApplicationContext(), "음악 파일 재생 중지됨.",Toast.LENGTH_SHORT).show();
        }
    }

    private void playAudio(String url) throws Exception{
        killMediaPlayer();

        player = new MediaPlayer();
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);
        player.setDataSource(url);
        player.prepare();
        player.start();
        while (player.isPlaying()){
            Thread.sleep(500);
        }
        killMediaPlayer();
    }

    private void killMediaPlayer() {
        if(player != null){
            try {
                player.release();
            } catch(Exception e){
                e.printStackTrace();
            }
        }

    }


}
