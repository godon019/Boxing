package com.example.user.boxing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class RecordingActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recording);

        initialize();

        perform();


    }

    void initialize(){

    }

    void perform(){

        RecordingMain recordingMain = new RecordingMain();
        recordingMain.setActivity(RecordingActivity.this);
        recordingMain.performThread();

    }



}
