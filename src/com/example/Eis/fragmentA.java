package com.example.Eis;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;



import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class fragmentA extends Fragment
{
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) 
	{
	     
		
		return inflater.inflate(R.layout.fragment_a,container,false);
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);
		
		ArrayList<notification> nn = new ArrayList<notification>();
		String text="This is the part where we place our notification.For instance we can say that this statement of line is to notify that the part where we put messege is shown staticley";
		for(int i=0;i<25;i++)
		{
			nn.add(new notification(text, "6/6/2014","10:45 PM","notification"+i));
		}
		ListView lv = (ListView) view.findViewById(R.id.listViewNotifications);
	    notifyAdapter t = new notifyAdapter(getActivity().getApplicationContext(), R.layout.activity_notification, nn); 
		lv.setAdapter(t);
	
	}
	
}

class notification
{
	String notification;
	String notificationheading;
	String date;
	String time;
	
	
	notification(String notificat,String dat,String tim,String notihead)
	{
		this.notification=notificat;
		this.notificationheading=notihead;
		this.date= dat;
		this.time =tim;
		
	}
}

class notifyAdapter extends ArrayAdapter
{
Context c;
ArrayList<notification> n;

	public notifyAdapter(Context context, int resource,
			ArrayList<notification> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
	c = context;
	n = objects;
	}
	
	@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
		
		notification nn = n.get(position);
		
		LayoutInflater inflatorforrow = (LayoutInflater) c.getSystemService(c.LAYOUT_INFLATER_SERVICE);
		
		 convertView = inflatorforrow.inflate(R.layout.activity_notification, parent, false);
		
		 TextView tvnot = (TextView) convertView.findViewById(R.id.textView_notificationtext);
		 tvnot.setText(nn.notification);
		 TextView tvdate = (TextView) convertView.findViewById(R.id.textView_notification_date);
		 tvdate.setText(nn.date);
		 TextView tvtime = (TextView) convertView.findViewById(R.id.textView_notification_time);
		 tvtime.setText(nn.time);
		 TextView tvnothead = (TextView) convertView.findViewById(R.id.textView_notification_heading);
		 tvnothead.setText(nn.notificationheading);
		
			return convertView;
		}
	
}




