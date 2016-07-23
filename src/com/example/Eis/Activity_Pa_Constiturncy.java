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
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class Activity_Pa_Constiturncy extends Activity
{
	
	
	 ListView listpa;
	    protected void onCreate(Bundle savedInstanceState) 
	    {
	    	try{
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_constituency_pa);
	        
	        
	        listpa = (ListView) findViewById(R.id.listView_pa);
	        listpa.setAdapter(new makingadapterPa(this));
	        listpa.setOnItemClickListener(new OnItemClickListener() {

  				@Override
  				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
  						long arg3) {
  					// TODO Auto-generated method stub
  					//Toast.makeText(Activity_Candidate.this, "mujy click kia :P", Toast.LENGTH_LONG).show();
  				
  				startActivity(new Intent(Activity_Pa_Constiturncy.this,Activity_Candidate.class));
  				
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
	class singlerowPa
	{
		
		String tittlepa;
		String Descriptionpa;
		public singlerowPa(String tittlePa,String DescriptionPa)
		{
			
			
			
			
			this.tittlepa =tittlePa;
			this.Descriptionpa =DescriptionPa;
			
		}
	
			
		
	}

		//end of previous class start of new class
	class makingadapterPa extends BaseAdapter
	{
		
		
	ArrayList<singlerowPa> listpa;
	Context context;///saving context because of inflator
	public makingadapterPa(Context c) 


	{
		try{
		context = c;
		listpa =new ArrayList<singlerowPa>();
		Resources res = c.getResources();
		String[] tittlespa =res.getStringArray(R.array.PA_Description);
		String[] Descriptionpa =res.getStringArray(R.array.PA_tittle);
		for (int i=0;i<28;i++)
		{
		singlerowPa s	= new singlerowPa( tittlespa[i],Descriptionpa[i]);
			listpa.add(s);
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
			return listpa.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return listpa.get(position);
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
			View rowpa =inflatorforrow.inflate(R.layout.activity_consituency_names_tworows, parent,false);
		TextView tittlepa =	(TextView) rowpa.findViewById(R.id.twoline_single_row_textview_tittle);
		TextView descriptionpa = (TextView) rowpa.findViewById(R.id.twoline_single_row_textview_description);
		
		singlerowPa temp =listpa.get(position);
		tittlepa.setText(temp.tittlepa);
		
		descriptionpa.setText(temp.Descriptionpa);
		
			
			return rowpa;
		}

}
