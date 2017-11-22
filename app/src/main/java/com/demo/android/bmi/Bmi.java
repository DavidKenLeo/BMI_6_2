package com.demo.android.bmi;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class Bmi extends AppCompatActivity {

    Button button;
    EditText fieldHeight;
    EditText fieldWeight;
    public static final String TAG = "LifeCycle";

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"Bmi.onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"Bmi.onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"Bmi.onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"Bmi.onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"Bmi.onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"Bmi.onRestart");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"Bmi.onCreate");
        setContentView(R.layout.activity_bmi);
        findViews();
        setListeners();
    }

    void findViews(){
        button = (Button) findViewById(R.id.submit);
        fieldHeight = (EditText) findViewById(R.id.height);
        fieldWeight = (EditText) findViewById(R.id.weight);
    }

    void setListeners(){
        button.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent();
            intent.setClass(Bmi.this,Report.class);
            Bundle bundle = new Bundle();
            bundle.putString("KEY_HEIGHT",fieldHeight.getText().toString());
            bundle.putString("KEY_WEIGHT",fieldWeight.getText().toString());
            intent.putExtras(bundle);
            startActivity(intent);
        }
    };

    void openOptionsDialog(){
        Toast.makeText(Bmi.this,"顯示Toast訊息",Toast.LENGTH_LONG).show();

        final ProgressDialog progressDialog =
                ProgressDialog.show(Bmi.this, "處理中...", "請等一會，處理完畢會自動結束...");

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
//                    result.setTextColor(Color.BLUE);
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                progressDialog.dismiss();
            }
        };
        thread.start();
    }



}
