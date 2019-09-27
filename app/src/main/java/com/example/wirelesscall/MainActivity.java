package com.example.wirelesscall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageButton Btn_call;
    private EditText    ET_name;
    private TextView    testview_whosecall;

    public  Person      person = new Person();
    public  WiFi        device = new WiFi();
    private boolean isBtnPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 變數各自對應的物件
        Btn_call           = (ImageButton) findViewById(R.id.btn_call);
        ET_name            = (EditText) findViewById(R.id.editText);
        testview_whosecall = (TextView) findViewById(R.id.textview_whosecall);

        //未說話前，聽別人說話
        final Receiver wireless_listener = new Receiver();
        wireless_listener.startListening();

        //長按按鈕後
        Btn_call.setOnLongClickListener(new HoldListener());
        Btn_call.setOnTouchListener(new touchListener());

        testview_whosecall.setMovementMethod(new ScrollingMovementMethod());

//        //按鈕點擊後
//        Btn_call.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view)
//            {
//                // 設定說話者名稱以及其WIFI位址
////                person.setWifi_Addr(device, getApplicationContext());
//                person.setName(ET_name);
//                //要開始說話，需先切斷聆聽
//                wireless_listener.stopListening();
//
//                // 取得說話者的名稱及WIFI位址
//                String talker_name = person.getName();
////                String talker_addr = person.getWifi_Addr();
//
//                // 畫面顯示誰正在說話
//                testview_whosecall.setText(talker_name + " is talking...");
//
//                // 開始廣播說話
//                Talker wireless_caller = new Talker(person);
//                wireless_caller.Talking();
//            }
//        });
    }

    //監聽長按(detect long press)
    private class HoldListener implements View.OnLongClickListener
    {
        @Override
        public boolean onLongClick(View view) {
            // 按鈕已點下
            isBtnPressed = true;
            // 設定說話者名稱以及其WIFI位址
            person.setName(ET_name);
            // 取得說話者的名稱及WIFI位址
            String talker_name = person.getName();
            // 畫面顯示誰正在說話
            String text = "<font color='blue'>" + talker_name + " is talking..." + "</font><br>";
            testview_whosecall.append(Html.fromHtml(text));



            return true;
        }
    }

    //監聽放開按鈕(detect release button)
    private class touchListener implements View.OnTouchListener
    {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent)
        {
            // 放開按鈕後的動作
            if(motionEvent.getAction() == motionEvent.ACTION_UP)
            {
                if(isBtnPressed)
                {
                    // 取得說話者的名稱及WIFI位址
                    String talker_name = person.getName();
                    // 畫面顯示誰正在說話
                    String text = "<font color='red'>" + talker_name + " stop talking..." + "</font><br>";
                    testview_whosecall.append(Html.fromHtml(text));
                    isBtnPressed = false;
                }
            }
            return false;
        }
    }
}
