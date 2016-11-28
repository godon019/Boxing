package com.example.user.boxing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        perform();

    }

    /**Overide this*/
    void initialize(){
    }

    /**Overide this*/
    void perform(){
    }
}
