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
	public void setCalendar(ArrayList<ArrayList<UserEvent>> calendar) {
		this.calendar = calendar;
	}
	
	public String[] YearAndWeekDates(int week, int year){
		String[] dates = {};
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM dd yyyy");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.WEEK_OF_YEAR, week);        
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		System.out.println(sdf.format(cal.getTime()));  
		
		return dates;
	}
}
