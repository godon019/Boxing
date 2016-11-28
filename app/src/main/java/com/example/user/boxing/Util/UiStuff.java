package com.example.user.boxing.Util;

import android.app.Activity;

import java.util.concurrent.Callable;

/**
 * Created by Godon on 2016-11-07.
 */
public class UiStuff {

    static Activity activity;

    public UiStuff(Activity activity) {
        this.activity = activity;
    }

    public static void runFunctionAsParameter(Callable<Void> myFunc) {
        try {
            myFunc.call();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static class FunctionAsParameterClass implements Callable<Void> {    //todo replace this with bellows in 'testingMavenWithLotteryProgram'

        public void overrideThis() throws Exception {

        }

        /**
         * runUiThred and wait for it to be finished so that it can continue without any errors
         */
        @Override
        public Void call() throws Exception {

            final boolean[] finished = {false};

            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        overrideThis();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    finished[0] = true;
                }
            });

            while (finished[0] == false) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }

    }

    public static class DoingUIStuffAndWaitForFinish extends FunctionAsParameterClass {

        public void overrideThis() throws Exception {

        }

        @Override
        public Void call() throws Exception {

            final boolean[] finished = {false};

            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        overrideThis();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    finished[0] = true;
                }
            });

            while (finished[0] == false) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }
    }


    public static class DoingUIStuffAndNotWaitForFinish extends FunctionAsParameterClass {

        public void overrideThis() throws Exception {

        }

        @Override
        public Void call() throws Exception {

            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        overrideThis();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            return null;
        }
    }
}
