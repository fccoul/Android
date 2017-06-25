package com.example.fhcoulibaly.fcoapplication_back;

import android.app.ActionBar;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

//public class FragmentHosted extends AppCompatActivity {
public class FragmentHosted extends FragmentActivity {


    private static final String TAG="Tab Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_hosted);


        /*
        SimplePagerAdapter adapter=new SimplePagerAdapter(getSupportFragmentManager());
        ViewPager pager=(ViewPager)findViewById(R.id.fragmentPager);
        pager.setAdapter(adapter);
        */


        final ViewPager pager=(ViewPager)findViewById(R.id.fragmentPager);

        final ActionBar actionBar=getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
         ActionBar.TabListener tabListener=new ActionBar.TabListener() {
             @Override
             public void onTabSelected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {
                 pager.setCurrentItem(tab.getPosition());

                 Log.d(TAG,"swipe Tab OK");
             }

             @Override
             public void onTabUnselected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {

             }

             @Override
             public void onTabReselected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {

             }

         };




        actionBar.addTab(actionBar.newTab().setText("Home").setTabListener(tabListener));

        actionBar.addTab(actionBar.newTab().setText("Articles").setTabListener(tabListener));

        pager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener()
        {
            public void onPageSelected(int position)
            {
                actionBar.setSelectedNavigationItem(position);
               
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present
        //getMenuInflater().inflate(R.menu.);
        return true;
    }

    public static class SimplePagerAdapter extends FragmentPagerAdapter {

        public SimplePagerAdapter(FragmentManager fragmentManager)
        {super(fragmentManager);

        }
        @Override
        public Fragment getItem(int position) {
            switch (position)
            {
                case 0: return new HomeFragment();
                case 1 : return  new ArticleFragment();
                default: return  null;
            }

        }

        @Override
        public int getCount() {
            return 2;
        }
    }


}
