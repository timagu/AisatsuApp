package jp.techacademy.yamazawa.kouta.aisatsuapp;

import android.content.DialogInterface;
import android.app.TimePickerDialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import  android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //UI部品(Button)を取得
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            showTimePickerDialog(); //時間設定
        }
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                //時刻を設定した時にonTimeSetメソッドが呼ばれる
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                    TextView textView = (TextView) findViewById(R.id.textView); //UI部品(textView)を取得

                    //適切な挨拶をする。
                    if (2 <= hourOfDay && hourOfDay <= 9) {
                        textView.setText("おはよう");
                    } else if (10 <= hourOfDay && hourOfDay <= 17) {
                        textView.setText("こんにちは");
                    } else //if (18 <= hourOfDay || hourOfDay <= 1)
                    {
                        textView.setText("こんばんは");
                    }
                }
        }, 13, 0, true);
        timePickerDialog.show();//TimePickerDialogを表示
    }
}