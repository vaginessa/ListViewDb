package com.listview.db;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends Activity {
	
	private final int SPLASH_DISPLAY_LENGTH = 5000;
	private Bundle savedInstanceState;

	@Override
	protected void onCreate(Bundle savedIsnstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_splash_screen);
		
	    }

	@Override
	protected void onResume()
	{
		super.onResume();
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
		boolean isSplashEnabled = sp.getBoolean("isSplashEnabled", true);

		if (isSplashEnabled)
		{
			new Handler().postDelayed(new Runnable()
			{
				public void run()
				{
					SplashActivity.this.finish();
					
					Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
					SplashActivity.this.startActivity(mainIntent);
				}
			}, SPLASH_DISPLAY_LENGTH);
		}
		else
		{
	
			finish();
			Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
			SplashActivity.this.startActivity(mainIntent);
		}
	}
}

