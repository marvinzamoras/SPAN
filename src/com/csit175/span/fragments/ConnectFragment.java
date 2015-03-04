package com.csit175.span.fragments;

import com.csit175.span.R;
import com.csit175.span.R.layout;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ConnectFragment extends Fragment {
 
    public ConnectFragment() {
    }
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_connect, container, false);
 
        return rootView;
    }
 
}

