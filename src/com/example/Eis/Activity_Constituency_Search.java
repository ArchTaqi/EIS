package com.example.Eis;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_Constituency_Search extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_constituency);
		String name=getIntent().getStringExtra("conName");
		Log.d("Eis", "name is"+name);
		Toast.makeText(this, name, Toast.LENGTH_LONG).show();
		
	
		ArrayList<events> ee = new ArrayList<events>();
		for(int j=0;j<24;j++)
		{
			ee.add(new events("Nawaz Shrif", "PMLN"));
		}
		ListView lv = (ListView) findViewById(R.id.listViewcon_cand);
		final eventadapter ed = new eventadapter(getApplicationContext(), R.layout.activity_eventslist, ee);
		lv.setAdapter(ed);
		ed.notifyDataSetChanged();
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				events ee = (events) ed.getItem(arg2);
				Toast.makeText(getApplicationContext(), ee.Candidatename, Toast.LENGTH_LONG).show();
				Intent in = new Intent(Activity_Constituency_Search.this,Tabmain.class);
				in.putExtra("he", ee.Candidatename);
				startActivity(in);
			}
		});
	}
	class events
	{
		String Candidatename,candidateparty;
		Bitmap picevent;
		
		events(String cand_name,String party/*,Bitmap pic*/)
		{
			this.Candidatename=cand_name;
			this.candidateparty=party;
			//this.picevent=pic;
			
			
		}
		}
	class eventadapter extends ArrayAdapter
	{
		Context con;
		ArrayList<events> arrayevent;

		public eventadapter(Context context, int resource,ArrayList<events>objects)
		{
			super(context, resource,objects);
			// TODO Auto-generated constructor stub
			
			con=context;
			arrayevent=objects;
			}
		public View getView(int position,View convertView,ViewGroup parent)
		
		{
			events ee = arrayevent.get(position);
			LayoutInflater inflaterow= (LayoutInflater) con.getSystemService(con.LAYOUT_INFLATER_SERVICE);
			convertView = inflaterow.inflate(R.layout.activity_candidates_piclist,parent,false);
			
			TextView tvcandname = (TextView) convertView.findViewById(R.id.single_row_description_Candidate);
			TextView tvcandparty= (TextView) convertView.findViewById(R.id.single_row_tittle_Candidate);
			ImageView imgcan=(ImageView) convertView.findViewById(R.id.imageView1_Candidate);
			
			tvcandname.setText(ee.Candidatename);
			tvcandparty.setText(ee.candidateparty);
			
			//imgcan.setImageBitmap(ee.picevent);
			return convertView;
			}
		}
			

}



