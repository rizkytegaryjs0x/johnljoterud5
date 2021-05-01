package Logic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import JsonClasses.UserEvent;

public class CalendarHandler {
	private ArrayList <ArrayList<UserEvent>> calendar;

	public CalendarHandler() {
		
	}
	public ArrayList<UserEvent> getWeekEvents(int weeknumber, int year){
		
		ArrayList<UserEvent> weekEvents = new ArrayList<UserEvent>();
		
		ArrayList<String> dates = YearAndWeekDates(weeknumber, year);
		
		for(String tempdate : dates){

			for(ArrayList<UserEvent> tempcal : calendar){

				for (int i = 0 ; i < tempcal.size(); i++){
					if(tempcal.size()>0){
						System.out.println("Is " + tempcal.get(i).getStart() + " = " + tempdate + " ?");
						if(tempcal.get(i).getStart().contains(tempdate)){
							weekEvents.add(tempcal.get(i));
							System.out.println("an event was added to weekevents.");
						}
					}
				}
			}
		}
		
		return weekEvents;
	}

	public void setCalendar(ArrayList<ArrayList<UserEvent>> calendar) {
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
	 
	 public int getWeekDay(String date){
		 int column = 0;
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			int d = Integer.valueOf(date);
			cal.set(Calendar.DATE,d);
			sdf.format(cal.getTime());
			
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
	
	 public void PopulateTable(ArrayList<UserEvent> dayEvents, int dayOfWeek){
		 if(!dayEvents.isEmpty()){
			 SimpleDateFormat sdf = new SimpleDateFormat("hh");
			 CellModel cm = new CellModel();
			 ArrayList <CellModel> alcm = new ArrayList <CellModel>();
			 
			 for(UserEvent de : dayEvents){
				 cm.setRow(Integer.valueOf(sdf.format(de.getStart())));
				 
			 }
		 }
	 }
}
