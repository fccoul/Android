package com.example.fhcoulibaly.gpsplotter;

import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends FragmentActivity implements GooglePlayServicesClient.ConnectionCallbacks,
        com.google.android.gms.location.LocationListener,
        GooglePlayServicesClient.OnConnectionFailedListener {


    private GoogleMap myMap;//object reference for the map
    private LocationClient myLocationClient;
    private static final LocationRequest REQUEST=LocationRequest.create().setInterval(5000)//5sec
                                                                         .setFastestInterval(16)//16ms
                                                                         .setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getMApReference();

    }

    /**
     *      Get a map object reference if none exits and enable blue arrow icon on map
     */
    private void getMApReference() {
        if(myMap==null){
            myMap=((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
        }
        if(myMap!=null)
        {
            myMap.setMyLocationEnabled(true);
        }
    }


    /**
     *
     * @param bundle
     *      LocationClient is connected
     */
    @Override
    public void onConnected(Bundle bundle) {

        myLocationClient.requestLocationUpdates(REQUEST,this);// LocationListener
    }

    @Override
    public void onDisconnected() {

    }

    /**
     *
     * @param location - Location object with all the information about location
     *                 Callback from LocationClient every time our location is changed
     */
    @Override
    public void onLocationChanged(Location location) {

        gotoMyLocation(location.getLatitude(), location.getLongitude());

    }

    /**
     *
     * @param latitude - latitude of the location to move the camera to
     * @param longitude - longitude of the location to move the camera to
     *            Prepares a CameraUpdate object to be used with  callbacks
     */
    private void gotoMyLocation(double latitude, double longitude) {
        changeCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(new LatLng(latitude, longitude))
                        .zoom(15.5f)
                        .bearing(0)
                        .tilt(25)
                        .build()
        ), new GoogleMap.CancelableCallback() {

            @Override
            public void onFinish() {

            }

            @Override
            public void onCancel() {

            }
        });
    }

    private void changeCamera(CameraUpdate cameraUpdate, GoogleMap.CancelableCallback cancelableCallback) {
        myMap.moveCamera(cameraUpdate);
    }


    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    /**
     *     Activity's lifecycle event.
     *     onResume will be called when the Activity receives focus
     *     and is visible
     */
    @Override
    protected  void onResume()
    {

        super.onResume();

        getMApReference();
        wakeUpLocationClient();
        myLocationClient.connect();

    }

    /**
     *      Activity's lifecycle event.
     *      onPause will be called when activity is going into the background,
     */
    @Override
    protected void onPause()
    {

       super.onPause();

        if(myLocationClient!=null)
        {
            myLocationClient.disconnect();
        }

    }

    /**
     *      When we receive focus, we need to get back our LocationClient
     *      Creates a new LocationClient object if there is none
     */
    private void wakeUpLocationClient() {

         if(myLocationClient==null)
         {
             myLocationClient=new LocationClient(getApplicationContext(),
                     this,// Connection Callbacks
                     this);// OnConnectionFailedListener
         }
    }
}
