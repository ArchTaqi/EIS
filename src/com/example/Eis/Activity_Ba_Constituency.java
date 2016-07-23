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

public class Activity_Ba_Constituency extends Activity
{

	
	 ListView listBa;
	    protected void onCreate(Bundle savedInstanceState) 
	    {
	    	try{
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_constituency_ba);
	        
	        
	        listBa = (ListView) findViewById(R.id.listView_ba);
	        listBa.setAdapter(new makingadapterBa(this));
	        listBa.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
						long arg3) {
					// TODO Auto-generated method stub
					//Toast.makeText(Activity_Candidate.this, "mujy click kia :P", Toast.LENGTH_LONG).show();
				
				startActivity(new Intent(Activity_Ba_Constituency.this,Activity_Candidate.class));
				
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
	class singlerowBa
	{
		
		String tittleBa;
		String DescriptionBa;
		public singlerowBa(String tittleBa,String DescriptionBa)
		{
			
			
			
			
			this.tittleBa =tittleBa;
			this.DescriptionBa =DescriptionBa;
			
		}
	
			
		
	}

		//end of previous class start of new class
	class makingadapterBa extends BaseAdapter
	{
		
		
	ArrayList<singlerowBa> listBa;
	Context context;///saving context because of inflator
	public makingadapterBa(Context c) 


	{
		try{
		context = c;
		listBa =new ArrayList<singlerowBa>();
		Resources res = c.getResources();
		String[] tittlesBa =res.getStringArray(R.array.BA_description);
		String[] DescriptionBa =res.getStringArray(R.array.BA_tittle);
		for (int i=0;i<23;i++)
		{
		singlerowBa s	= new singlerowBa( tittlesBa[i],DescriptionBa[i]);
			listBa.add(s);
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
			return listBa.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return listBa.get(position);
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
			View rowBa =inflatorforrow.inflate(R.layout.activity_consituency_names_tworows, parent,false);
		TextView tittleBa =	(TextView) rowBa.findViewById(R.id.twoline_single_row_textview_tittle);
		TextView descriptionBa = (TextView) rowBa.findViewById(R.id.twoline_single_row_textview_description);
		
		singlerowBa temp =listBa.get(position);
		tittleBa.setText(temp.tittleBa);
		
		descriptionBa.setText(temp.DescriptionBa);
		
			
			return rowBa;
		}

}
