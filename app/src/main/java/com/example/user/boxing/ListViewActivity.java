package com.example.user.boxing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initialize();

        perform();


    }

    void initialize(){

    }

    void perform(){
        ListViewMain listViewMain = new ListViewMain();
        listViewMain.setActivity(ListViewActivity.this);
        listViewMain.performThread();

    }


}
