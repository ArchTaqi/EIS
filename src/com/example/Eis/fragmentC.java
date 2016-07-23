package com.example.Eis;

import java.util.ArrayList;

import com.example.Eis.fragmentB.eventadapter;
import com.example.Eis.fragmentB.events;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;



public class fragmentC extends Fragment

{
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
	{
		
		
		return inflater.inflate(R.layout.fragment_c, container, false);
	}


	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);	
		Log.d("Eis", "array list made");
		ArrayList<article> nn = new ArrayList<article>();
		for(int i=0;i<25;i++)
		{
			Log.d("Eis", "itms added");
			nn.add(new article("article "+i ,"6/6/2014","power"));
		}
		Log.d("Eis", "listview created");
		
		ListView lv = (ListView) view.findViewById(R.id.listViewarticles);
		Log.d("Eis", "adapter initialize");
		articleAdapter t = new articleAdapter(getActivity().getApplicationContext(), R.layout.activity_customarticles, nn); 
		Log.d("Eis", "adapter set");
		lv.setAdapter(t);
	
	}
	
}

class article
{
	String articleheading;
	String articlecatagory;
	String articledate;
	
	
	
	article(String heading,String dat,String catagory)
	{
		this.articleheading=heading;
		this.articledate=dat;
		this.articlecatagory= catagory;
		
		
	}
}

class articleAdapter extends ArrayAdapter
{
Context c;
ArrayList<article> n;

	public articleAdapter(Context context, int resource,
			ArrayList<article> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
	c = context;
	n = objects;
	}
	
	@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
		
		article nn = n.get(position);
		
		LayoutInflater inflatorforrow = (LayoutInflater) c.getSystemService(c.LAYOUT_INFLATER_SERVICE);
		
		 convertView = inflatorforrow.inflate(R.layout.activity_customarticles, parent, false);
		
		 TextView tvarticleheader = (TextView) convertView.findViewById(R.id.textViewHeadingarticle);
		 tvarticleheader.setText(nn.articleheading);
		 TextView tvarticledate = (TextView) convertView.findViewById(R.id.textViewdatearticle);
		 tvarticledate.setText(nn.articledate);
		 TextView tvarticlecatagory = (TextView) convertView.findViewById(R.id.textViewcatagory);
		 tvarticlecatagory.setText(nn.articlecatagory);
		 
			return convertView;
		}
	
	
}
