package com.example.fhcoulibaly.fcoapplication_back;

import android.provider.ContactsContract;

/**
 * Created by FHCOULIBALY on 6/14/2017.
 */

public class DataItem {

    String Name;
    String phoneNumber;

    public DataItem(String Name,String PhoneNumber) {
       this.Name=Name;
        this.phoneNumber=PhoneNumber;
    }
}
