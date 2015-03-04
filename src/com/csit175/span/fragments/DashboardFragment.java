package com.csit175.span.fragments;

import java.util.ArrayList;

import com.csit175.span.DetailActivity;
import com.csit175.span.R;
import com.csit175.span.R.layout;
import com.csit175.span.adapter.DashboardAdapter;
import com.csit75.span.models.DashboardItem;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

@SuppressLint ("InflateParams")
public class DashboardFragment extends ListFragment {
	
	View header = null;
 
    public DashboardFragment() {
    }
    
    
 
    @Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}



	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
 
        //View rootView = inflater.inflate(R.layout.fragment_create, container, false);
        header = inflater.inflate(R.layout.dashboard_header, null);
        return super.onCreateView(inflater, container, savedInstanceState);
    }



	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		ArrayList<DashboardItem> items = DashboardItem.populateItems();
		DashboardAdapter adapter = new DashboardAdapter(getActivity(),items);
		
		if(header != null)
			this.getListView().addHeaderView(header);
			
		setListAdapter(adapter);
		super.onActivityCreated(savedInstanceState);
	}



	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		Intent details = new Intent(getActivity(),DetailActivity.class);
		startActivity(details);
	}
 
	
	
}

