package com.Kitowski.timetable.date;

import java.util.ArrayList;
import com.Kitowski.timetable.utilities.HttpReader;
import android.util.Log;

public class DateLoader {
	private final static String logcatTAG = "Date loader";

	private ArrayList<String> toConvert;
	private ArrayList<String> dateList;
	
	public DateLoader() {
		HttpReader http = (HttpReader) new HttpReader().execute("https://inf.ug.edu.pl/terminy-zjazdow-semestr-zimowy-201617", "table");
		toConvert = new ArrayList<String>();
		dateList = new ArrayList<String>();
		
		if(loadFromHttp(http)) convertDate();
	}
	
	@SuppressWarnings("finally")
	private boolean loadFromHttp(HttpReader http) {
		try { toConvert = http.get(); }
		catch(Exception e) {
			Log.e(logcatTAG, "Failed to load");
			return false;
		}
		finally {
			if(toConvert.size() == 0) return false;
			else return true;
		}
	}
	
	public ArrayList<String> getList() { return dateList; }
	
	private void convertDate() {
		String buffer = "";
		
		for(String str : toConvert) {
			if(!str.contains("/")) {
				if(buffer != "") buffer = "";
				String st[] = str.split(" ");
				buffer = st[1] + "-" + Integer.toString(getMonth(st[0]));
			}
			else {
				String st[] = str.split("/");
				if(st[0].length() < 2) st[0] = "0" + st[0];
				if(st[1].length() < 2) st[1] = "0" + st[1];
				dateList.add(buffer + "-" + st[0]);
				dateList.add(buffer + "-" + st[1]);
			}
		}
	}
	
	private int getMonth(String month) {
		if(month.contentEquals("styczeń")) return 1;
		if(month.contentEquals("luty")) return 2;
		if(month.contentEquals("marzec")) return 3;
		if(month.contentEquals("kwiecień")) return 4;
		if(month.contentEquals("maj")) return 5;
		if(month.contentEquals("czerwiec")) return 6;
		if(month.contentEquals("lipiec")) return 7;
		if(month.contentEquals("sierpień")) return 8;
		if(month.contentEquals("wrzesień")) return 9;
		if(month.contentEquals("październik")) return 10;
		if(month.contentEquals("listopad")) return 11;
		if(month.contentEquals("grudzień")) return 12;
		return 1;
	}
}
