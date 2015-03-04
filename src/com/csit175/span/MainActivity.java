package com.csit175.span;

import java.util.ArrayList;




import com.csit175.span.adapter.DrawerItemCustomAdapter;
import com.csit175.span.fragments.AboutFragment;
import com.csit175.span.fragments.CalendarFragment;
import com.csit175.span.fragments.ConnectFragment;
import com.csit175.span.fragments.DashboardFragment;
import com.csit175.span.fragments.NotesFragment;
import com.csit175.span.fragments.SettingsFragment;





import com.csit75.span.models.ObjectDrawerItem;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	// declare properties
    private String[] mMenuTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    private ActionBarDrawerToggle mDrawerToggle;

    // nav drawer title
    private CharSequence mDrawerTitle;
 
    // used to store app title
    private CharSequence mTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ActionBar bar=getActionBar();
		bar.setTitle("SPAN");
		bar.setSubtitle("Student Planner and Activity Notifier");
		bar.setIcon(R.drawable.ic_launcher);
		
		mTitle = mDrawerTitle = getTitle();
		
		//load slide menu items
		mMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);
		
		// list the drawer items
        ObjectDrawerItem[] drawerItem = new ObjectDrawerItem[7];
		
        drawerItem[0] = new ObjectDrawerItem(R.drawable.ic_dashboard,mMenuTitles[0]);
        drawerItem[1] = new ObjectDrawerItem(R.drawable.ic_connect,mMenuTitles[1]);
        drawerItem[2] = new ObjectDrawerItem(R.drawable.ic_notes,mMenuTitles[2]);
        drawerItem[3] = new ObjectDrawerItem(R.drawable.ic_calendar,mMenuTitles[3]);
        drawerItem[4] = new ObjectDrawerItem(R.drawable.ic_about,mMenuTitles[4]);
        drawerItem[5] = new ObjectDrawerItem(R.drawable.ic_settings,mMenuTitles[5]);
        drawerItem[6] = new ObjectDrawerItem(R.drawable.ic_logout,mMenuTitles[6]);
		
     // Pass the folderData to our ListView adapter
        DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.listview_item_row, drawerItem);
		
     // Set the adapter for the list view
        mDrawerList.setAdapter(adapter);
        
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
		
		
		// enabling action bar app icon and behaving it as toggle button
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
		
		mDrawerToggle = new ActionBarDrawerToggle(
		        this,
		        mDrawerLayout,
		        R.drawable.ic_drawer, 
		        R.string.app_name, 
		        R.string.app_name 
		        ) {
		    
		    /** Called when a drawer has settled in a completely closed state. */
		    public void onDrawerClosed(View view) {
		    	super.onDrawerClosed(view);
		    	getActionBar().setTitle(mTitle);
		    }
		 
		    /** Called when a drawer has settled in a completely open state. */
		    public void onDrawerOpened(View drawerView) {
		    	super.onDrawerOpened(drawerView);
		    	getActionBar().setTitle(mDrawerTitle);
		    }
		};
		 
		mDrawerLayout.setDrawerListener(mDrawerToggle);
		
        if (savedInstanceState == null) {
        	// on first time display view for first nav item
        	selectItem(0);
        }

	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	 @Override
		public boolean onOptionsItemSelected(MenuItem item) {
		 /// The action bar home/up action should open or close the drawer.
	        // ActionBarDrawerToggle will take care of this.
		 if (mDrawerToggle.onOptionsItemSelected(item)) {
	           return true;
	       }
	       
	       return super.onOptionsItemSelected(item);
		
		}
	 
	// navigation drawer click listener
		private class DrawerItemClickListener implements ListView.OnItemClickListener {
			
		    @Override
		    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		        selectItem(position);
		    }
		    
		}
	
	
    /**
	 * Diplaying fragment view for selected nav drawer list item
	 * */

	    private void selectItem(int position) {
	    	
	        // update the main content by replacing fragments
	    	
	        Fragment fragment = null;
	        
	        switch (position) {
	        case 0:
	            fragment = new DashboardFragment();
	            break;
	        case 1:
	            fragment = new ConnectFragment();
	            break;
	        case 2:
	            fragment = new NotesFragment();
	            break;
	        case 3:
	            fragment = new CalendarFragment();
	            break;
	        case 4:
	            fragment = new SettingsFragment();
	            break;
	        case 5:
	        	fragment= new AboutFragment();
	        	break;
	        case 6://logout
	            //fragment = new LogOutFragment();
	        	Intent logout = new Intent(getApplicationContext(),LoginActivity.class);
	        	logout.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	        	startActivity(logout);
	            break;
	        default:
	            break;
	        }
	        
	        
	        if(fragment!=null){
	        	FragmentManager transaction = getFragmentManager();
	        	transaction.beginTransaction().replace(R.id.frame_content, fragment).commit();
	        	
	        	// update selected item and title, then close the drawer
	        	mDrawerList.setItemChecked(position, true);
	        	mDrawerList.setSelection(position);
	        	setTitle(mMenuTitles[position]);
	        	mDrawerLayout.closeDrawer(mDrawerList);
	        }else{
	        	// error in creating fragment
	        	 Log.e("MainActivity", "Error in creating fragment");
	        }
	        
	       
	    }
	    
	    @Override
		public void onBackPressed() {
			if(!mDrawerLayout.isDrawerOpen(mDrawerList)){
				mDrawerLayout.openDrawer(mDrawerList);
			} else {
				mDrawerLayout.closeDrawer(mDrawerList);
			}
		}

		@Override
	    public void setTitle(CharSequence title) {
	        mTitle = title;
	        getActionBar().setTitle(mTitle);
	    }
		
		// to change up caret
	    @Override
	    protected void onPostCreate(Bundle savedInstanceState) {
	        super.onPostCreate(savedInstanceState);
	        // Sync the toggle state after onRestoreInstanceState has occurred.
	        mDrawerToggle.syncState();
	    }
	    
	   
}
