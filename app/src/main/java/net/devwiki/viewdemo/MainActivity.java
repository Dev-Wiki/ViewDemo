package net.devwiki.viewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "MainActivity";

    private TextView textView;
    private Button leftBtn;
    private Button topBtn;
    private Button rightBtn;
    private Button bottomBtn;
    private Button clearBtn;

    private RadioButton translationRb;
    private RadioButton scrollRb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text_view);
        leftBtn = (Button) findViewById(R.id.btn_left);
        rightBtn = (Button) findViewById(R.id.btn_right);
        topBtn = (Button) findViewById(R.id.btn_top);
        bottomBtn = (Button) findViewById(R.id.btn_bottom);
        clearBtn = (Button) findViewById(R.id.btn_clear);
        translationRb = (RadioButton) findViewById(R.id.translation_rb);
        scrollRb = (RadioButton) findViewById(R.id.scroll_rb);
        textView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i(TAG, "onTouch: top:" + textView.getTop() + ",left:" + textView.getLeft()
                        + ",bottom:" + textView.getBottom() + ",right:" + textView.getRight());
                Log.i(TAG, "onTouch: getX():" + event.getX());
                Log.i(TAG, "onTouch: getY():" + event.getY());
                Log.i(TAG, "onTouch: getRawX():" + event.getRawX());
                Log.i(TAG, "onTouch: getRawY():" + event.getRawY());
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
