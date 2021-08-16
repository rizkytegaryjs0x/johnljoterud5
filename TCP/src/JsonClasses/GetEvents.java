package JsonClasses;

import java.util.ArrayList;

public class GetEvents {
	private  final long serialVersionUID = 1L;
	private String overallID = "getEvents";
	
	ArrayList<UserEvent> events = new ArrayList<UserEvent>();

	public String getOverallID() {
		return overallID;
	}

	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}

	public ArrayList<UserEvent> getEvents() {
		return events;
	}

	public void setEvents(ArrayList<UserEvent> events) {
		this.events = events;
	}

	public long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	
	
}
