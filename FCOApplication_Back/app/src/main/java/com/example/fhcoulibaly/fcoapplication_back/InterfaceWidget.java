package com.example.fhcoulibaly.fcoapplication_back;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class InterfaceWidget extends AppCompatActivity {

    private static final String TAG="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface_widget);

        /*
        ImageView img=(ImageView)findViewById(R.id.idImageSnd);
        Resources resources=getResources();
        Drawable image=resources.getDrawable(R.drawable.dbencrypt);
        img.setImageDrawable(image);

        Button btn=(Button)findViewById(R.id.btnImg);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View sender)
            {
                Button senderAsButton=(Button)sender;
                String title=senderAsButton.getText().toString();
               Log.d(TAG,String.format("You clicked the '%s' button",title));
                //Log.d(TAG,"kpleus");
            }
        });
        */
        EditText _editText=(EditText)findViewById(R.id.txtEditFinish);
        _editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            //--cette methode signale au système que l'utilisateur a fini sa saisi ,en clickakntsur le clavier ici "Send"
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                //ce params :actionId permet de verifier le type action effectué par le client "send-done-search...)
               if(actionId== EditorInfo.IME_ACTION_SEND)
                   // if(actionId== EditorInfo.IME_ACTION_DONE)
                {
                    String input=v.getText().toString();
                    Log.d(TAG,String.format("Processing Kpleus input : %s",input));
                }
                else
               {
                   Log.d(TAG,String.format("Kpleus No send"));
               }
                return false;
            }
        });
    }
}
