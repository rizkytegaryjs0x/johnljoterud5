package Logic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import JsonClasses.UserEvent;

public class CalendarHandler {
	private ArrayList <ArrayList<UserEvent>> calendar;

	public CalendarHandler(ArrayList<ArrayList<UserEvent>> calendar) {
		setCalendar(calendar);
	}
	public ArrayList<ArrayList<UserEvent>> getWeekEvents(int weeknumber, int year){
		
		ArrayList<ArrayList<UserEvent>> weekEvents = new ArrayList<ArrayList<UserEvent>>();
		
		
		
		return weekEvents;
	}
	/**
	 * 
	 * @param calendar
	 */
	public void setCalendar(ArrayList<ArrayList<UserEvent>> calendar) {
		this.calendar = calendar;
	}
	
	 static public ArrayList<String> YearAndWeekDates(int week, int year){
		ArrayList<String> dates = new ArrayList<String>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.WEEK_OF_YEAR, week);

		
		for(int i=2 ; i<7 ; i++){
		cal.set(Calendar.DAY_OF_WEEK, i);
		dates.add(sdf.format(cal.getTime()));
		}
		for(int i=0 ; i<2 ; i++){
			cal.set(Calendar.DAY_OF_WEEK, i);
			dates.add(sdf.format(cal.getTime())); 
		}

		return dates;
	 }
	}
