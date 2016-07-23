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

public class Activity_Kpk_Constituency extends Activity
{
	

	 ListView listKpka;
	    protected void onCreate(Bundle savedInstanceState) 
	    {
	    	try{
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_constituency_kpk);
	        
	        
	        listKpka = (ListView) findViewById(R.id.listView_kpk);
	        listKpka.setAdapter(new makingadapterKpka(this));
	        listKpka.setOnItemClickListener(new OnItemClickListener() {

	  				@Override
	  				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
	  						long arg3) {
	  					// TODO Auto-generated method stub
	  					//Toast.makeText(Activity_Candidate.this, "mujy click kia :P", Toast.LENGTH_LONG).show();
	  				
	  				startActivity(new Intent(Activity_Kpk_Constituency.this,Activity_Candidate.class));
	  				
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
	class singlerowKpka
	{
		
		String tittleKpka;
		String DescriptionKpka;
		public singlerowKpka(String tittleKpka,String DescriptionKpka)
		{
			
			
			
			
			this.tittleKpka =tittleKpka;
			this.DescriptionKpka =DescriptionKpka;
			
		}
	
			
		
	}

		//end of previous class start of new class
	class makingadapterKpka extends BaseAdapter
	{
		
		
	ArrayList<singlerowKpka> listKpka;
	Context context;///saving context because of inflator
	public makingadapterKpka(Context c) 


	{
		try{
		context = c;
		listKpka =new ArrayList<singlerowKpka>();
		Resources res = c.getResources();
		String[] tittlesKpka =res.getStringArray(R.array.KPK_description);
		String[] DescriptionKpka =res.getStringArray(R.array.KPK_tittle);
		for (int i=0;i<23;i++)
		{
		singlerowKpka s	= new singlerowKpka( tittlesKpka[i],DescriptionKpka[i]);
			listKpka.add(s);
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
			return listKpka.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return listKpka.get(position);
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
			View rowKpka =inflatorforrow.inflate(R.layout.activity_consituency_names_tworows, parent,false);
		TextView tittleKpka =	(TextView) rowKpka.findViewById(R.id.twoline_single_row_textview_tittle);
		TextView descriptionKpka = (TextView) rowKpka.findViewById(R.id.twoline_single_row_textview_description);
		
		singlerowKpka temp =listKpka.get(position);
		tittleKpka.setText(temp.tittleKpka);
		
		descriptionKpka.setText(temp.DescriptionKpka);
		
			
			return rowKpka;
		}


}
