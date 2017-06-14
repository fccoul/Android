package com.example.fhcoulibaly.fcoapplication_back;

import android.app.Activity;
import android.support.annotation.StringDef;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListLayoutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_layout);

        String []data=new String[]{"Item 1","Item 2","Item 3","Item 4"};

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,data);
        ListView listView=(ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}
