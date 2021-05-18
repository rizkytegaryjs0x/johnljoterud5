package Logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import JsonClasses.CalendarInfo;
import JsonClasses.UserEvent;

public class CalendarHandler {
	private ArrayList <CalendarInfo> calendar;

	public CalendarHandler() {
		
	}
	public CalendarInfo getWeekEvents(int weeknumber, int year){
		
		CalendarInfo weekEvents = new CalendarInfo();
		
		ArrayList<String> dates = YearAndWeekDates(weeknumber, year);
		
		for(String tempdate : dates){
			System.out.println("tempdate is empty: " + tempdate.isEmpty());
			System.out.println("dates is empty: " + dates.isEmpty());
			for(CalendarInfo tempcal : calendar){
				System.out.println("calendar is empty: " + calendar.isEmpty());
				System.out.println("tempcal is empty: " + tempcal.isEmpty());
				for (int i = 0 ; i <= tempcal.size(); i++){
					
					if(tempcal.get(i).getStart().contains(tempdate)){
						weekEvents.add(tempcal.get(i));
					}
					
				}
			}
		}
		
		return weekEvents;
	}

	public void setCalendar(ArrayList<CalendarInfo> calendar) {
		this.calendar = calendar;
	}
	
	/**Method to get dates of given week in a given year, in the "yyyy-MM-dd" format
	 * @author Niklas Broge
	 * @param 
	 * @return ArrayList<String> of dates
	 */
	 public ArrayList<String> YearAndWeekDates(int week, int year){
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
	 
	 public int getWeekDay(String date) throws ParseException{
		 int column = 0;
			Calendar cal = Calendar.getInstance();
			Date d =  new SimpleDateFormat("yyyy-MM-dd").parse(date);
			cal.setTime(d);
			System.out.println(d);
			int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
			if (dayOfWeek == 1) {
				column = 6;
			}
			else if (dayOfWeek == 2){
				column = 0;
			}
			else if (dayOfWeek == 3){
				column = 1;
			}
			else if (dayOfWeek == 4){
				column = 2;
			}
			else if (dayOfWeek == 5){
				column = 3;
			}
			else if (dayOfWeek == 6){
				column = 4;
			}
			else if (dayOfWeek == 7){
				column = 5;
			}	
		System.out.println(column);
		return column;
	
	 }
	

}
