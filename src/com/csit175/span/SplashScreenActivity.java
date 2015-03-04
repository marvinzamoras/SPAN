package com.csit175.span;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;


public class SplashScreenActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//remove title bar
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		//the layout xml
		setContentView(R.layout.activity_splashscreen);
		
		TimerTask task=new TimerTask(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Intent nextActivity=new Intent(SplashScreenActivity.this, LoginActivity.class);
				startActivity(nextActivity);
				SplashScreenActivity.this.finish();
			}
			
		};
		
		new Timer().schedule(task, 4000);
	}

}
