package com.example.fhcoulibaly.fcoapplication_back;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CustomLstViewActivity extends Activity {


    private ArrayList<DataItem> data;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_lst_view);

        this.data=new ArrayList<DataItem>();
        this.data.add(new DataItem("John Smith","(555) 454-0002"));
        this.data.add(new DataItem("Markus Maxim","(555) 411-00148"));
        this.data.add(new DataItem("Bill Kim","(225) 084-03321"));
        this.data.add(new DataItem("Joe Budden","(225) 044-03589"));

        adapter=new CustomAdapter(this,data);
        ListView listView=(ListView) findViewById(R.id.listViewCustom);
        listView.setAdapter(adapter);

    }
}
