package com.csit175.span;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;

public class DetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getActionBar().setTitle("SPAN");
		getActionBar().setSubtitle("Student Planner and Activity Notifier");
		getActionBar().hide();
		setContentView(R.layout.fragment_details);
	}

	
}
