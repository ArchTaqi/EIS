package com.example.Eis;
import java.util.ArrayList;
import java.util.zip.Inflater;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.EventLogTags.Description;
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

public class Screen_Na_Consituency extends Activity
{
	
	
	 ListView list;
	    protected void onCreate(Bundle savedInstanceState) 
	    {
	    	try{
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_consituency_list);
	        
	        
	        list = (ListView) findViewById(R.id.listView_na);
	        list.setAdapter(new makingadapter(this));
	        list.setOnItemClickListener(new OnItemClickListener() {

  				@Override
  				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
  						long arg3) {
  					
  				
  				startActivity(new Intent(Screen_Na_Consituency.this,Activity_Candidate.class));
  				
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
	class singlerow
	{
		String tittle;
		String Description;
		
		
		public singlerow(String tittleNa,String DescriptionNa) 
		{
			this.tittle =tittleNa;
			this.Description =DescriptionNa;
			
		}
	}

		//end of previous class start of new class
	class makingadapter extends BaseAdapter
	{
		
		
	ArrayList<singlerow> list;
	Context context;///saving context because of inflator
	public makingadapter(Context c) 


	{
		try{
		context = c;
		list =new ArrayList<singlerow>();
		Resources res = c.getResources();
		String[] tittles =res.getStringArray(R.array.NA_Tittle);
		String[] Description =res.getStringArray(R.array.Na_Description);
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
			View row =inflatorforrow.inflate(R.layout.activity_consituency_names_tworows, parent,false);
		TextView tittle =	(TextView) row.findViewById(R.id.twoline_single_row_textview_tittle);
		TextView description = (TextView) row.findViewById(R.id.twoline_single_row_textview_description);
		singlerow temp =list.get(position);
		tittle.setText(temp.tittle);
		description.setText(temp.Description);
			return row;
		}
	

}


