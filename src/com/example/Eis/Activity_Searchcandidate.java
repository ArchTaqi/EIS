package com.example.Eis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_Searchcandidate extends Activity
{
	
	Button can,con;
	EditText candtv,contv;	
	
@Override
protected void onCreate(Bundle savedInstanceState)
{
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_search);
	
	can = (Button) findViewById(R.id.buttoncand);
	con = (Button) findViewById(R.id.buttoncon);
	
	candtv = (EditText) findViewById(R.id.editTextcand);
	contv = (EditText) findViewById(R.id.editTextcon);
	
	can.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(candtv.getText().length() < 1)
			{
				Toast.makeText(getApplicationContext(), "Please Enter Candidate", Toast.LENGTH_LONG).show();
			}
			else
			{
				Intent in = new Intent(getApplicationContext(),Activity_Searched_Candidate.class);
				in.putExtra("canName",candtv.getText().toString());
				startActivity(in);
			}
			
			
		}
	});
con.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			if(contv.getText().length() < 1)
			{
				Toast.makeText(getApplicationContext(), "Please Enter constituency", Toast.LENGTH_LONG).show();
			}
			else
			{
				Intent in = new Intent(getApplicationContext(),Activity_Constituency_Search.class);
				in.putExtra("conName",contv.getText().toString());
				startActivity(in);
			}
			
			
		}
	});
	
	
}
}
