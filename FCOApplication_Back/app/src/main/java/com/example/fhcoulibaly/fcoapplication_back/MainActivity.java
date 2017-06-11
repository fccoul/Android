package com.example.fhcoulibaly.fcoapplication_back;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {

    private static final String TAG="MainActivity";
    public static final String EXTRA_MESSAGE="com.Kpleus.androidHello.Message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void nextPage(View view)
    {
       /* Log.e(String tag, String msg) – Log an error message.
        Log.w(String tag, String msg) – Log a warning message.
        Log.i(String tag, String msg) – Log an informational message*/
        // Log.d(String tag, String msg) : Log a debug message.
        //Log.d(TAG,"Switching to next page...");
        Intent intent=new Intent(this,SecondActivity.class);
        Button button=(Button)view;
        String message=button.getText().toString();
        //Log.d(TAG,message);
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }
}
