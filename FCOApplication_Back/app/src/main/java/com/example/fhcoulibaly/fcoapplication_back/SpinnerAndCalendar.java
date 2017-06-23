package com.example.fhcoulibaly.fcoapplication_back;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class SpinnerAndCalendar extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_and_calendar);

        /*
        ArrayList<String> colors=new ArrayList<String>();
        colors.add("Red");
        colors.add("Orange");
        colors.add("Yellow");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Violet");

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,colors);
         */
        //---en utilisant les ressources pour faciliter l'internationalisation...
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,
                R.array.spinnerColors,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner=(Spinner)findViewById(R.id.colorSpinner);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectColor=(String)parent.getItemAtPosition(position);
                setTextColor(selectColor);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                  //called when selection disappears...
            }

        });
    }

    private void setTextColor(String color)
    {
          String hexColor="#FF000000";
        if(color.equals("Red"))
        {
            hexColor="#FFAA0000";
        }
        else if(color.equals("Orange"))
        {
             hexColor="#FFCC6600";
        }
        else if(color.equals("Yellow"))
        {
            hexColor="#FFCCAA00";
        }
        else if(color.equals("Green"))
        {
            hexColor="#FF00AA00";

        }
        else if(color.equals("Blue"))
        {
            hexColor="#FF0000AA";
        }
        else if(color.equals("Violet"))
        {
            hexColor="#FF6600AA";
        }

        TextView text=(TextView)findViewById(R.id.spinnerText);
        text.setTextColor(Color.parseColor(hexColor));
    }
}
