package com.csit175.span;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ActionBar bar=getActionBar();
		bar.hide();
		setContentView(R.layout.activity_login);
	}
	
	public void registerUser(View view){
		Intent intent = new Intent(this, SignUpActivity.class);
		startActivity(intent);
	}
	
	public void skip(View view){
		Intent dashboard = new Intent(this, MainActivity.class);
		startActivity(dashboard);
	}

}
