package com.example.fhcoulibaly.fcoapplication_back;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class InterfaceWidget extends AppCompatActivity {

    private static final String TAG="MainActivity";

    private boolean isGreen;
    private boolean isBold;
    private boolean isBig;

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


        this.isGreen=true;
        this.isBold=false;
        this.isBig=false;
        synchronizeCheckBox();
        synchronizeTextView();
        */

        RadioButton serif=(RadioButton)findViewById(R.id.rdbSerif);
        serif.setChecked(true);
        radioButtonClicked(null);
    }

    public void radioButtonClicked(View v) {

        RadioGroup rdbGroup=(RadioGroup)findViewById(R.id.rdGroup);
        String typeface="";
        switch (rdbGroup.getCheckedRadioButtonId())
        {
            case R.id.rdbSans: typeface="sans";
                                break;
            case R.id.rdbSerif: typeface="serif";
                                break;
            case R.id.rdbMonoSpace: typeface="monospace";
                                break;
            default:typeface="default";
        }

        //update Textview
        TextView text=(TextView)findViewById(R.id.txtRdb);
        text.setTypeface(Typeface.create(typeface,Typeface.BOLD_ITALIC));
    }

    /*
    private void synchronizeTextView() {

        TextView text=(TextView)findViewById(R.id.chkText);
        if(this.isGreen)
        {
            text.setTextColor(Color.parseColor("#FF009900"));
        }
        else
        {
            text.setTextColor(Color.parseColor("#FF000000"));
        }
        if(this.isBold)
        {
            text.setTypeface(Typeface.create("default",Typeface.BOLD));
        }
        else
        {
            text.setTypeface(Typeface.create("default",Typeface.NORMAL));
        }
        if(this.isBig)
        {
            text.setTextSize(TypedValue.COMPLEX_UNIT_SP,30);
        }
        else
        {
             text.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
        }
    }

    private void synchronizeCheckBox() {

        CheckBox green=(CheckBox)findViewById(R.id.chkGreen);
        CheckBox bold=(CheckBox)findViewById(R.id.chkBold);
        CheckBox big=(CheckBox)findViewById(R.id.chkBig);

        green.setChecked(this.isGreen);
        bold.setChecked(this.isBold);
        big.setChecked(this.isBig);

    }

    public void CheckBoxClicked(View view)
    {
        CheckBox chk=(CheckBox)view;
        boolean isChecked=chk.isChecked();
        switch(view.getId())
        {
            case  R.id.chkGreen:this.isGreen=isChecked;
                                 break;
            case R.id.chkBold:this.isBold=isChecked;
                                 break;
            case R.id.chkBig:this.isBig=isChecked;
                                break;
        }
        synchronizeTextView();
    }

    */
}
