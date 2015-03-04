package com.csit75.span.models;

import java.util.ArrayList;

import com.csit175.span.R;

public class DashboardItem {
	
	public String day;
	public String day_name;
	public String about_act;
	public String time_place;
	public int cover;
	
	public static ArrayList<DashboardItem> populateItems(){
		ArrayList<DashboardItem> items = new ArrayList<DashboardItem>();
		
		for(int i=0; i<10; i++){
			DashboardItem itemActivity = new DashboardItem();
			
			switch(i){
			case 0: {
				itemActivity.day = "23";
				itemActivity.day_name = "Mon";
				itemActivity.about_act = "Math 137";
				itemActivity.time_place = "3:00 pm @LB285TC";
				itemActivity.cover = R.drawable.calendar_ismis;
			}
				break;
				
			case 1: {
				itemActivity.day = "24";
				itemActivity.day_name = "Tues";
				itemActivity.about_act = "IT 136";
				itemActivity.time_place = "9:00 am @LB470TC";
				itemActivity.cover = R.drawable.calendar_ismis;
			}
				break;
			
			case 2: {
				itemActivity.day = "24";
				itemActivity.day_name = "Tues";
				itemActivity.about_act = "IT 145";
				itemActivity.time_place = "12:00 pm @LB468TC";
				itemActivity.cover = R.drawable.calendar_ismis;
			}
				break;
				
			case 3: {
				itemActivity.day = "25";
				itemActivity.day_name = "Wed";
				itemActivity.about_act = "go to church";
				itemActivity.time_place = "6:00 am @Consolacion Parish";
				itemActivity.cover = R.drawable.calendar_shared;
			}
				break;
			
			case 4: {
				itemActivity.day = "25";
				itemActivity.day_name = "Wed";
				itemActivity.about_act = " No class: Math 137";
				itemActivity.time_place = "3:00 pm @LB285TC";
				itemActivity.cover = R.drawable.calendar_dcs;
			}
			
				break;
				
			case 5: {
				itemActivity.day = "27";
				itemActivity.day_name = "Fri";
				itemActivity.about_act = " Career Talk";
				itemActivity.time_place = "2:00 pm @Rigney Hall";
				itemActivity.cover = R.drawable.calendar_dcs;
			}
			
				break;
				
			case 6: {
				itemActivity.day = "27";
				itemActivity.day_name = "Sat";
				itemActivity.about_act = " Mike's Birthday";
				itemActivity.time_place = "all day";
				itemActivity.cover = R.drawable.calendar_gmail;
			}
			
				break;
				
			case 7: {
				itemActivity.day = "28";
				itemActivity.day_name = "Sat";
				itemActivity.about_act = " NSTP 2";
				itemActivity.time_place = "9:00 am @LB285TC";
				itemActivity.cover = R.drawable.calendar_ismis;
			}
			
				break;
				
			case 8: {
				itemActivity.day = "28";
				itemActivity.day_name = "Sat";
				itemActivity.about_act = "Lecture on Security Information";
				itemActivity.time_place = "1:30 pm @CAS Open Theatre";
				itemActivity.cover = R.drawable.calendar_gmail;
			}
			
				break;
				
			case 9: {
				itemActivity.day = "28";
				itemActivity.day_name = "Sat";
				itemActivity.about_act = "make android project";
				itemActivity.time_place = "6:00 pm @home";
				itemActivity.cover = R.drawable.calendar_shared;
			}
			
				break;
			}
			
			items.add(itemActivity);
		}
		
		return items;
		
	}

}
