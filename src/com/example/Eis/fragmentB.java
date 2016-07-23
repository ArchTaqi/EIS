package com.example.Eis;

import java.util.ArrayList;

import com.example.Eis.Activity_Constituency_Search.events;



import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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



public class fragmentB extends Fragment
{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) 
	{
		
		return inflater.inflate(R.layout.fragment_b, container,false);
		
	}
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);
		ArrayList<events> ee = new ArrayList<events>();
		for(int j=0;j<24;j++)
		{
			ee.add(new events("heading", "date", "location"+j));
		}
		ListView lv = (ListView) view.findViewById(R.id.listViewevents);
		 eventadapter ed = new eventadapter(getActivity().getApplicationContext(), R.layout.activity_eventslist, ee);
		lv.setAdapter(ed);
		ed.notifyDataSetChanged();
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				//events ee = (events) ed.getItem(arg2);
				//Toast.makeText(getActivity().getApplicationContext(), ee.headingevent, Toast.LENGTH_LONG).show();
				//Intent in = new Intent(fragmentB.this,Activity_Eventform.class);
			//	in.putExtra("he", ee.headingevent);
				//startActivity(in);
				// TODO Auto-generated method stub
				
			}
		});
		
		
	}
	class events
	{
		String headingevent,dateevent,locationevet;
		Bitmap picevent;
		
		events(String heading,String date,String location/*,Bitmap pic*/)
		{
			this.dateevent=date;
			this.headingevent=heading;
			//this.picevent=pic;
			this.locationevet=location;
			
		}
		}
	public class eventadapter extends ArrayAdapter
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
			convertView = inflaterow.inflate(R.layout.activity_eventslist,parent,false);
			
			TextView tvhead = (TextView) convertView.findViewById(R.id.textView_eventheading);
			TextView tvdate= (TextView) convertView.findViewById(R.id.textView4);
			TextView tvloc= (TextView) convertView.findViewById(R.id.textView2);
			ImageView imgcan=(ImageView) convertView.findViewById(R.id.imageView1);
			
			tvhead.setText(ee.headingevent);
			tvdate.setText(ee.dateevent);
			tvloc.setText(ee.locationevet);
			//imgcan.setImageBitmap(ee.picevent);
			return convertView;
			}
		}
			

}
