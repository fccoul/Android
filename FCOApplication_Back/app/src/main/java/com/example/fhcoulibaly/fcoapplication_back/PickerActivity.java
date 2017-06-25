package com.example.fhcoulibaly.fcoapplication_back;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PickerActivity extends FragmentActivity implements DatePickerDialog.OnDateSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker);
    }

    @Override//**par rapport aux entrees/selection d el'utilisateur...
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        // Process the selected date (month is zero-indexed)
        TextView text=(TextView)findViewById(R.id.txtPicker);
        String message=String.format("Seleted date : %d/%d/%d",month+1,dayOfMonth,year);

        text.setText(message);
    }

    //-----Affiachge du calendrier (dtaepicker depuis boite de dialog)
    public void showDatePickerDialog(View v)
    {
        DialogFragment picker=new DatePickerFragment();
        picker.show(this.getFragmentManager(),"datePicker");
    }
}
