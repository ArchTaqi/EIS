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

public class Activity_Sa_Constituency extends Activity
{
	

	
	 ListView listsa;
	    protected void onCreate(Bundle savedInstanceState) 
	    {
	    	try{
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_constituency_sa);
	        
	        
	        listsa = (ListView) findViewById(R.id.listView_sa);
	        listsa.setAdapter(new makingadaptersa(this));
	        listsa.setOnItemClickListener(new OnItemClickListener() {

  				@Override
  				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
  						long arg3) {
  					// TODO Auto-generated method stub
  					//Toast.makeText(Activity_Candidate.this, "mujy click kia :P", Toast.LENGTH_LONG).show();
  				
  				startActivity(new Intent(Activity_Sa_Constituency.this,Activity_Candidate.class));
  				
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
	class singlerowsa
	{
		
		String tittlesa;
		String Descriptionsa;
		public singlerowsa(String tittlesa,String Descriptionsa)
		{
			
			
			
			
			this.tittlesa =tittlesa;
			this.Descriptionsa =Descriptionsa;
			
		}
	
			
		
	}

		//end of previous class start of new class
	class makingadaptersa extends BaseAdapter
	{
		
		
	ArrayList<singlerowsa> listsa;
	Context context;///saving context because of inflator
	public makingadaptersa(Context c) 


	{
		try{
		context = c;
		listsa =new ArrayList<singlerowsa>();
		Resources res = c.getResources();
		String[] tittlessa =res.getStringArray(R.array.SA_description);
		String[] Descriptionsa =res.getStringArray(R.array.SA_tittle);
		for (int i=0;i<28;i++)
		{
		singlerowsa s	= new singlerowsa( tittlessa[i],Descriptionsa[i]);
			listsa.add(s);
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
			return listsa.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return listsa.get(position);
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
			View rowsa =inflatorforrow.inflate(R.layout.activity_consituency_names_tworows, parent,false);
		TextView tittlesa =	(TextView) rowsa.findViewById(R.id.twoline_single_row_textview_tittle);
		TextView descriptionsa = (TextView) rowsa.findViewById(R.id.twoline_single_row_textview_description);
		
		singlerowsa temp =listsa.get(position);
		tittlesa.setText(temp.tittlesa);
		
		descriptionsa.setText(temp.Descriptionsa);
		
			
			return rowsa;
		}

}
