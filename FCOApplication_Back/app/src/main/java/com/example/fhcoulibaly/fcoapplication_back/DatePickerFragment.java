package com.example.fhcoulibaly.fcoapplication_back;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;

import android.os.Bundle;

import java.util.Calendar;

/**
 * Created by FHCOULIBALY on 6/24/2017.
 */

//--calsse representatnt la boite de dialog qui va heberger le datepickerDialor-->le calendrier
public class DatePickerFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //Create and return the date picker dialog
        final Calendar c= Calendar.getInstance();
        int year=c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH);
        int day=c.get(Calendar.DAY_OF_MONTH);

        PickerActivity context=(PickerActivity)getActivity();
        // The first parameter should be the host Activity, and the second one is the listener object,
        // which should implement the OnDateSetListener interface
        return new DatePickerDialog(context,context,year,month,day);
    }
}
