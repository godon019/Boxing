package com.example.user.boxing.ListViewStuff;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.user.boxing.R;
import com.example.user.boxing.RecordAudioStuff.Recording;

import java.util.ArrayList;

/**
 * Created by user on 2016-11-27.
 */
public class ListViewBtnAdapter extends ArrayAdapter{

    Activity activity;
    String path = "";


    // 버튼 클릭 이벤트를 위한 Listener 인터페이스 정의.
    public interface ListBtnClickListener {
        void onListBtnClick(int position) ;
    }

    // 생성자로부터 전달된 resource id 값을 저장.
    int resourceId ;


    // ListViewBtnAdapter 생성자. 마지막에 ListBtnClickListener 추가.
    public ListViewBtnAdapter(Context context, int resource, ArrayList<ListViewBtnItem> list, Activity activity) {
        super(context, resource, list) ;

        // resource id 값 복사. (super로 전달된 resource를 참조할 방법이 없음.)
        this.resourceId = resource ;

        this.activity = activity;
        path = Environment.getExternalStorageDirectory().toString()+"/boxing/";

    }

    // 새롭게 만든 Layout을 위한 View를 생성하는 코드
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position ;
        final Context context = parent.getContext();

        // 생성자로부터 저장된 resourceId(listview_btn_item)에 해당하는 Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(this.resourceId/*R.layout.listview_btn_item*/, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)로부터 위젯에 대한 참조 획득
        final TextView textTextView = (TextView) convertView.findViewById(R.id.textView1);

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        final ListViewBtnItem listViewItem = (ListViewBtnItem) getItem(position);

        // 아이템 내 각 위젯에 데이터 반영
        textTextView.setText(listViewItem.getText());
        final Recording recording = new Recording(activity);
        // button1 클릭 시 TextView(textView1)의 내용 변경.
        Button btnRecord = (Button) convertView.findViewById(R.id.recordbtn);
        btnRecord.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(activity.getApplicationContext(),
                        textTextView.getText().toString()+" 녹음시작", Toast.LENGTH_LONG).show();

                recording.record(path + textTextView.getText().toString());

            }
        });

        // button1 클릭 시 TextView(textView1)의 내용 변경.
        Button btnStop = (Button) convertView.findViewById(R.id.stopbtn);
        btnStop.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(activity.getApplicationContext(),
                        textTextView.getText().toString()+" 정지", Toast.LENGTH_LONG).show();
                recording.stop();

            }
        });

        Button btnPlay = (Button) convertView.findViewById(R.id.playbtn);
        btnPlay.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(activity.getApplicationContext(),
                        textTextView.getText().toString()+" 재생", Toast.LENGTH_LONG).show();
                recording.play(path + textTextView.getText().toString());
            }
        });


        return convertView;
    }



}
