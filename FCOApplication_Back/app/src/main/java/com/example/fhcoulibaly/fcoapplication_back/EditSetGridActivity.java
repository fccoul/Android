package com.example.fhcoulibaly.fcoapplication_back;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;

public class EditSetGridActivity extends Activity {

    private ArrayList<String> data;
    private ArrayAdapter<String> adapter;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_set_grid);

        this.data=new ArrayList<String>();
        this.data.add("Item 1");
        this.data.add("Item 2");
        this.data.add("Item 3");
        this.count=3;

        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        GridView gridView=(GridView)findViewById(R.id.griViewSet);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                data.remove(position);
                //refresh gridView after suppression...
                adapter.notifyDataSetChanged();
            }
        });
    }

    public void addItem(View v)
    {
        count++;
        String newItem=String.format("Item %d",count);
        this.data.add(newItem);
        //refresh gridView after ajout...
        this.adapter.notifyDataSetChanged();
    }
}
