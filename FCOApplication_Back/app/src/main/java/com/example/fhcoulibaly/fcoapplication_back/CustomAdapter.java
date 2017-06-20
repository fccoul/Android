package com.example.fhcoulibaly.fcoapplication_back;

/**
 * Created by FHCOULIBALY on 6/15/2017.
 */

import java.util.ArrayList;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.BaseAdapter;

public class CustomAdapter extends BaseAdapter {

    ArrayList<DataItem> data;
    Context context;
    private static LayoutInflater inflater=null;

    public CustomAdapter(Context context, ArrayList<DataItem> data)
    {
        this.context=context;
        this.data=data;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // See if the view needs to be inflated
        View view=convertView;
        if(view==null) {
            //--notre templae listView
            view = inflater.inflate(R.layout.list_item, null);
        }

        // Extract the desired views
        TextView nameText=(TextView)view.findViewById(R.id.nameValue);
        TextView phoneText=(TextView)view.findViewById(R.id.phoneValue);

        // Get the data item
        DataItem item=data.get(position);

        // Display the data item's properties
        nameText.setText(item.Name);
        phoneText.setText(item.phoneNumber);

        return  view;
    }

}
