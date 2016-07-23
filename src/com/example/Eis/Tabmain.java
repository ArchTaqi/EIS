package com.example.Eis;


import android.app.ActionBar;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.Toast;

public class Tabmain extends FragmentActivity implements ActionBar.TabListener

{
	
	
String canname;

    ViewPager viewPager=null;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_tab);
        viewPager= (ViewPager) findViewById(R.id.pager1);
        


        final ActionBar actionBar=getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        addTabs(actionBar);
        canname = getIntent().getStringExtra("CanName");
        
        
        Toast.makeText(this, canname, Toast.LENGTH_LONG).show();
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) 
            {
                Log.d("tabs","onPageScrolled "+i+" "+v+" "+i2);
            }

            @Override
            public void onPageSelected(int i) {
                actionBar.setSelectedNavigationItem(i);
                Log.d("tabs","onPageSelected "+i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {
                if(i==ViewPager.SCROLL_STATE_IDLE)
                Log.d("tabs","onPageScrollStateChanged scroll state idle "+i);
                if(i==ViewPager.SCROLL_STATE_DRAGGING)
                    Log.d("tabs","onPageScrollStateChanged scroll state dragging "+i);
                if(i==ViewPager.SCROLL_STATE_SETTLING)
                    Log.d("tabs","onPageScrollStateChanged scroll state settling "+i);
            }
        });

        }
    private void addTabs(ActionBar actionBar)
    {
    	try{
        ActionBar.Tab tab1=actionBar.newTab();
        tab1.setText("Notification");
        tab1.setTabListener(this);

        ActionBar.Tab tab2=actionBar.newTab();
        tab2.setText("Events");
        tab2.setTabListener(this);

        ActionBar.Tab tab3=actionBar.newTab();
        tab3.setText("Articles");
        tab3.setTabListener(this);
        
        ActionBar.Tab tab4=actionBar.newTab();
        tab4.setText("Videos");
        tab4.setTabListener(this);

        actionBar.addTab(tab1);
        actionBar.addTab(tab2);
        actionBar.addTab(tab3);
        actionBar.addTab(tab4);
    }
    	catch (Exception e)
    	
    	{
    		
    		Log.d("Exception", "exception is", e);
    	}
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) 
    {
        viewPager.setCurrentItem(tab.getPosition());

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft)
    {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) 
    {

    }
}

class MyAdapter extends FragmentStatePagerAdapter
{

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) 
    {
        Fragment fragment=null;
        if(i==0)
        {
            fragment=new fragmentA();
        }
        if(i==1)
        {
            fragment=new fragmentB();
        }
        if(i==2)
        {
            fragment=new fragmentC();
        }
        if(i==3)
        {
            fragment=new fragmentD();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
