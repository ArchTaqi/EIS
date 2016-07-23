package com.example.Eis;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity 
{

	Button Button_Na,Button_Pa,Button_Sa,Button_Ba,Button_Kpk,Button_Searchcandidate,Button_SearchConstituency,Button_aboutus,Button_info, Button_Gilget;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome_screen);
		
		Button_Na =(Button)findViewById(R.id.button_ncentre1);
		 Button_Pa =(Button)findViewById(R.id.button_ncentre2);
		 Button_Sa=(Button)findViewById(R.id.button_ncentre3);
		 Button_Ba=(Button)findViewById(R.id.button_ncentre4);
		 Button_Kpk=(Button)findViewById(R.id.button_ncentre5);
		 Button_Gilget=(Button)findViewById(R.id.button_ncentre6);
		 Button_Searchcandidate=(Button)findViewById(R.id.button_topleft);
		 Button_SearchConstituency=(Button)findViewById(R.id.button_topright);
		 Button_aboutus=(Button) findViewById(R.id.button_bottemleft);
		 Button_info=(Button) findViewById(R.id.button_bottemright);
		
		 Button_Searchcandidate.setOnClickListener(new OnClickListener()
		 {
			
			@Override
			public void onClick(View v)
			{
				Intent i = new Intent(MainActivity.this,Activity_Searchcandidate.class);
				startActivity(i);
					
			}
		});
		 
		 
		 
		 Button_SearchConstituency.setOnClickListener(new OnClickListener()
		 {
			
			@Override
			public void onClick(View v)
			{
				Intent i = new Intent(MainActivity.this,Activity_Searchcandidate.class);
			startActivity(i);
				
			}
		});
		 Button_Na.setOnClickListener(new OnClickListener()
		 {
			
			@Override
			public void onClick(View v) 
			{
				Intent i = new Intent(MainActivity.this,Screen_Na_Consituency.class);
			startActivity(i);
			}
		});
		 Button_Pa.setOnClickListener(new OnClickListener()
		 {
			
			@Override
			public void onClick(View v) 
			{
				Intent i = new Intent(MainActivity.this,Activity_Pa_Constiturncy.class);
				startActivity(i);
			
			}
		});
		 
		 
		 Button_Sa.setOnClickListener(new OnClickListener()
		 {
			
			@Override
			public void onClick(View v)
			{
				Intent i = new Intent(MainActivity.this,Activity_Sa_Constituency.class);
				startActivity(i);
				
			}
		});
		 
		 Button_Ba.setOnClickListener(new OnClickListener()
		 {
			
			@Override
			public void onClick(View v)
			{
				Intent i = new Intent(MainActivity.this,Activity_Ba_Constituency.class);
				startActivity(i);
				
			}
		});
		 Button_Kpk.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				Intent i = new Intent(MainActivity.this,Activity_Kpk_Constituency.class);
				startActivity(i);
				
			}
		});
		 Button_Gilget.setOnClickListener(new OnClickListener()
		 {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this,Activity_GB_Constituency.class);
				startActivity(i);	
				
			}
		});
		
		 
		 Button_aboutus.setOnClickListener(new OnClickListener()
		 
		 {
			
			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,Activity_Articleform.class);
				startActivity(i);	
			}
		});
		 Button_info.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,Activity_aboutus.class);
				startActivity(i);
				
			}
		});
	}





	
	


/*	public void changescreen(View v)
	{
		
			if(v.getId()==findViewById(R.id.button_NA))
				
			{
				Intent i = new Intent();
				i.setClassName("com.example.project", "com.example.project.Screen_Na_Consituency");
				startActivity(i);
		
			
		} 			
	*/	
	
		
	}




	
	
	
	
	
	
	

