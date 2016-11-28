package com.example.user.boxing;

import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import com.example.user.boxing.ListViewStuff.ListViewBtnAdapter;
import com.example.user.boxing.ListViewStuff.ListViewBtnItem;
import com.example.user.boxing.RecordAudioStuff.Recording;
import com.example.user.boxing.Util.UiStuff;

import java.util.ArrayList;

/**
 * Created by user on 2016-11-27.
 */
public class ListViewMain extends StandardMain{

    void perform(){


        new UiStuff(activity).runFunctionAsParameter(new UiStuff.DoingUIStuffAndWaitForFinish() {
            public void overrideThis() {

                ListView listview ;
                ListViewBtnAdapter adapter;
                ArrayList<ListViewBtnItem> items = new ArrayList<ListViewBtnItem>() ;

                // items 로드.
                loadItemsFromDB(items) ;

                // Adapter 생성
                adapter = new ListViewBtnAdapter(activity, R.layout.listview_item, items, activity) ;

                // 리스트뷰 참조 및 Adapter달기
                listview = (ListView) activity.findViewById(R.id.listview1);
                listview.setAdapter(adapter);

                Button randomPlay = (Button) activity.findViewById(R.id.random_play);
                randomPlay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startRandomPlay();
                    }
                });

                Button stopRandomPlay = (Button) activity.findViewById(R.id.random_play_stop);
                stopRandomPlay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        stopRandomPlay();
                    }
                });

            }
        });

        while(true){
            System.out.println("루프 play = " + play);
            if(play ==true){
                randomPlaying();
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }

    String[] boxingTechList = {"잽", "원투",  "잽잽원투", "원투원투", "잽잽투", "투원투", "뒤로갔다 원투", "투원", "원투원", "기습잽", "더블잽", "라이트 래프트 훅", "더미1", "더미2"};

    public boolean loadItemsFromDB(ArrayList<ListViewBtnItem> list) {
        if (list == null) {
            list = new ArrayList<ListViewBtnItem>() ;
        }

        for(int i=0; i<boxingTechList.length; i++){
            list.add(new ListViewBtnItem(boxingTechList[i]));
        }

        return true ;
    }

    public void randomPlaying(){
        Recording recording = new Recording(activity);

        int random = (int) (Math.random() * boxingTechList.length);
        System.out.println("random  : " + random);
        recording.play(Environment.getExternalStorageDirectory().toString() + "/boxing/" +boxingTechList[random]);
    }
    boolean play = false;

    public void startRandomPlay(){
        System.out.println("랜덤재생 시작");
        play = true;
    }

    public void stopRandomPlay(){
        System.out.println("랜덤재생 그만");
        play = false;
    }
}
