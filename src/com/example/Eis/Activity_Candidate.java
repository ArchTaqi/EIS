package com.example.Eis;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ListAdapter;
import android.widget.Toast;


public class Activity_Candidate extends Activity

{

	
    ListView listCand;
    protected void onCreate(Bundle savedInstanceState) 
    {
    	try{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate);
        
        
        listCand = (ListView) findViewById(R.id.listView_candidate);
        listCand.setAdapter(new makingadapterCand (this));
        listCand.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) 
			{
							
			startActivity(new Intent(Activity_Candidate.this,Tabmain.class));
			
			}
		
		});
    	}
    	catch(Exception e)
    	{
    		Log.d("Exception", "exception is"+e , e);
    	}
    	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
//end of previous class start of new class
class singlerowCand
{
	String tittle;
	String Description;
	int image;
	
	public singlerowCand(String tittle,String Description) 
	{
		this.tittle =tittle;
		this.Description =Description;
		
	}
}

	//end of previous class start of new class
class makingadapterCand extends BaseAdapter
{
	
	
ArrayList<singlerow> list;
Context context;///saving context because of inflator
public makingadapterCand (Context c) 


{
	try{
	context = c;
	list =new ArrayList<singlerow>();
	Resources res = c.getResources();
	String[] tittles =res.getStringArray(R.array.Cand_tittle);
	String[] Description =res.getStringArray(R.array.Candidate_Description);
	for (int i=0;i<22;i++)
	{
	singlerow s	= new singlerow( tittles[i],Description[i]);
		list.add(s);
	}
	}
	catch (Exception e)
	{
		
	}
	

}

	@Override
	public int getCount() 
	{
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position)///method used for populating data from databases
	{
		
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		LayoutInflater inflatorforrow = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		View row =inflatorforrow.inflate(R.layout.activity_candidates_piclist, parent,false);
	TextView tittle =	(TextView) row.findViewById(R.id.single_row_description_Candidate);
	TextView description = (TextView) row.findViewById(R.id.single_row_tittle_Candidate);
	
	singlerow temp =list.get(position);
	tittle.setText(temp.tittle);
	
	description.setText(temp.Description);
	
		
		return row;
	}

//class clicklist extends Activity implements OnItemClickListener
//	
//	{
//
//		@Override
//		public void onItemClick(AdapterView<?> Adapter, View v, int position,long arg3)
//		
//		{
//			
//			startActivity(new Intent(clicklist.this, Screen_Na_Consituency.class));
//			
//		}
//
//		
//			
//		}
		
	}


