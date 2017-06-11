package com.example.fhcoulibaly.myapps_code128;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button scanBtn;
    private TextView formatTxt,contentTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scanBtn=(Button)findViewById(R.id.btnScanBar);
        formatTxt=(TextView)findViewById(R.id.Txtscan_format);
        contentTxt=(TextView)findViewById(R.id.Txtscan_content);

        scanBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
                 if(v.getId()==R.id.btnScanBar){

                     IntentIntegrator scanIntegrator=new IntentIntegrator(this);
                     scanIntegrator.initiateScan();

                 }
    }

    public void onActivityResult(int requestCode,int resultCode,Intent intent)
    {
           IntentResult scanimgResult=IntentIntegrator.parseActivityResult(requestCode,resultCode,intent);
        if(scanimgResult!=null)
        {
                   String scanContent=scanimgResult.getContents();
                   String scanFormat=scanimgResult.getFormatName();
            formatTxt.setText("Format :"+scanFormat);
            contentTxt.setText("Content :"+scanContent);
        }
        else
        {
            Toast toast=Toast.makeText(getApplicationContext(),"No scan data received",Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
