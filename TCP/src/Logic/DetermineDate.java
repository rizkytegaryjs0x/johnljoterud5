package Logic;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DetermineDate {

	public static final String course1 = "8:00";
	public static final String course2 = "9:00";
	public static final String course3 = "10:00";
	public static final String course4 = "11:00";
	public static final String course5 = "12:00";
	public static final String course6 = "13:00";
	public static final String course7 = "14:00";
	public static final String course8 = "15:00";
	public static final String course9 = "16:00";
	public static final String course10 = "17:00";
	public static final String course11 = "18:00";
	public static final String course12 = "19:00";
	public static final String course13 = "20:00";
	public static final String course14 = "21:00";
	

	public DetermineDate() {
		int row = 0;
			
			int timeOfDay = cal.get(Calendar.DAY_OF_WEEK);
			if (timeOfDay == course1) {
				row = 1;
			}
			else if (timeOfDay == course2){
				row = 2;
			}
			else if (timeOfDay == course3){
				row = 3;
			}
			else if (timeOfDay == course4){
				row = 4;
			}
			else if (timeOfDay == course5){
				row = 5;
			}
			else if (timeOfDay == course6){
				row = 6;
			}
			else if (timeOfDay == course7){
				row = 7;
			}	
			else if (timeOfDay == course8) {
				row = 8;
			}
			else if (timeOfDay == course9) {
				row = 9;
			}
			else if (timeOfDay == course10) {
				row = 10;
			}
			else if (timeOfDay == course11) {
				row = 11;
			}
			else if (timeOfDay == course12) {
				row = 12;
			}
			else if (timeOfDay == course13) {
				row = 13;
			}
			else if (timeOfDay == course14) {
				row = 14;
			}
		System.out.println(row);
		return row;
	}
}
