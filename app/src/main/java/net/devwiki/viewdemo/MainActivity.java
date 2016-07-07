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

    private TextView stateTv;

    private RadioButton translationRb;
    private RadioButton scrollRb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text_view);
        textView.setOnClickListener(this);
        leftBtn = (Button) findViewById(R.id.btn_left);
        leftBtn.setOnClickListener(this);
        rightBtn = (Button) findViewById(R.id.btn_right);
        rightBtn.setOnClickListener(this);
        topBtn = (Button) findViewById(R.id.btn_top);
        topBtn.setOnClickListener(this);
        bottomBtn = (Button) findViewById(R.id.btn_bottom);
        bottomBtn.setOnClickListener(this);
        clearBtn = (Button) findViewById(R.id.btn_clear);
        clearBtn.setOnClickListener(this);
        translationRb = (RadioButton) findViewById(R.id.translation_rb);
        scrollRb = (RadioButton) findViewById(R.id.scroll_rb);
        stateTv = (TextView) findViewById(R.id.state_tv);
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
        switch (v.getId()) {
            case R.id.btn_left:
                clickLeft();
                showState();
                break;
            case R.id.btn_top:
                clickTop();
                showState();
                break;
            case R.id.btn_right:
                clickRight();
                showState();
                break;
            case R.id.btn_bottom:
                clickBottom();
                showState();
                break;
            case R.id.btn_clear:
                clickClear();
                showState();
                break;
        }
    }

    private void showState() {
        String state = "x:" + textView.getX() + ",y:" + textView.getY()
                + "\ntop:" + textView.getTop() + ",left:" + textView.getLeft() + ",bottom:" + textView.getBottom() + ",right:" + textView.getRight()
                + "\ntranslationX:" + textView.getTranslationX()
                + "\ntranslationY:" + textView.getTranslationY()
                + "\nscrollX:" + textView.getScrollX() + ",scrollY:" + textView.getScrollY();
        stateTv.setText(state);
    }

    private void clickLeft() {
        if (translationRb.isChecked()) {
            textView.setTranslationX(textView.getTranslationX() - 10);
        } else {
            textView.scrollBy(10, 0);
        }
    }

    private void clickRight() {
        if (translationRb.isChecked()) {
            textView.setTranslationX(textView.getTranslationX() + 10);
        } else {
            textView.scrollBy(-10, 0);
        }
    }

    private void clickTop() {
        if (translationRb.isChecked()) {
            textView.setTranslationY(textView.getTranslationY() - 10);
        } else {
            textView.scrollBy(0, 10);
        }
    }

    private void clickBottom() {
        if (translationRb.isChecked()) {
            textView.setTranslationY(textView.getTranslationY() + 10);
        } else {
            textView.scrollBy(0, -10);
        }
    }

    private void clickClear() {
        if (translationRb.isChecked()) {
            textView.setTranslationX(0);
            textView.setTranslationY(0);
        } else {
            textView.scrollTo(0,0);
        }
    }
}
