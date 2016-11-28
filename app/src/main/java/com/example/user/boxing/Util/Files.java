package com.example.user.boxing.Util;

import android.util.Log;

import java.io.File;

/**
 * Created by user on 2016-11-27.
 */
public class Files {

    public static void getFiles(String path) {
        System.out.println("getFiles()");
        Log.d("Files", "Path: " + path);
        File directory = new File(path);
        File[] files = directory.listFiles();
        Log.d("Files", "Size: " + files.length);
        for (int i = 0; i < files.length; i++) {
            Log.d("Files", "FileName:" + files[i].getName());
        }
    }
}
