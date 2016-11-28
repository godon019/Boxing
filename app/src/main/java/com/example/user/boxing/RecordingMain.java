package com.example.user.boxing;

import android.view.View;
import android.widget.Button;

/**
 * Created by Godon on 2016-11-15.
 *
 *     <uses-permission android:name="android.permission.RECORD_AUDIO" />
 <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
 <uses-permission android:name="android.permission.LOCATION_HARDWARE" />
 */
public class RecordingMain extends StandardMain {
//todo make directory if it doesn't exist



    void perform(){

        Button recordBtn = (Button) activity.findViewById(R.id.recordBtn);
        Button recordStopBtn = (Button) activity.findViewById(R.id.recordStopBtn);
        Button playBtn = (Button) activity.findViewById(R.id.playBtn);
        Button playStopBtn = (Button) activity.findViewById(R.id.playStopBtn);

        recordBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });

        recordStopBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {



            }
        });


        playBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

            }
        });

        playStopBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

            }
        });
    }


}
