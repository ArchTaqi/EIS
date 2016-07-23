package com.example.Eis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Activity_Candidatedetails extends Activity
{
	Button view; 
	String Name,cand_name;
	 TextView tvcandidatename;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		//cand_name=tvcandidatename.getText().toString();
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_candidate_details);
		 Name = getIntent().getStringExtra("canName");
		tvcandidatename = (TextView) findViewById(R.id.textViewfirstname);
		Log.d("Eis", "name is"+Name);
		Toast.makeText(this, Name, Toast.LENGTH_LONG).show();
		view=(Button) findViewById(R.id.buttonViewdetails);
	view.setOnClickListener(new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
		
			Intent in = new Intent(getApplicationContext(),Tabmain.class);
			Log.d("Eis", "candidate name is"+cand_name);
			in.putExtra("CanName", tvcandidatename.getText().toString());
			startActivity(in);
		}
	});
	}
	
}
