package com.example.fhcoulibaly.fcoapplication_back;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class GridLayoutActivity extends AppCompatActivity {

    private static final String TAG="GridLayoutActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout);

        String []data=new String[]{"Item 1","Item 2","Item 3","Item 4","Item 5","Item 6","Item 7","Item 8","Item 9"};

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        GridView gridView=(GridView)findViewById(R.id.gridView);
        gridView.setAdapter(adapter);

        //Handle Event Click
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // parameters: the parent AdapterView,
            // the View item that was clicked,
            // its position in the data set,
            // and its row id.
                   public void onItemClick(AdapterView<?> parent, View v, int position, long id)
                   {
                       TextView selectedView=(TextView)v;
                       Log.d(TAG,String.format("You clicked : %s",selectedView.getText()));
                   }
        });
    }
}
