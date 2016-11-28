package com.example.user.boxing;

import android.app.Activity;

/**
 * Created by Godon on 2016-11-14.
 */
public class StandardMain {

    protected Activity activity;

    public void setActivity(Activity activity) {
        this.activity = activity;
    }


    public void performThread() {
        System.out.println("standrard main performThread start");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
               perform();
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    /**Override this*/
    void perform(){

    }


}
