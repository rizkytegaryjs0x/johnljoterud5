package Logic;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import tcpClasses.*;
import JsonClasses.*;

public class test {
	
	public static void main (String[] args) throws UnknownHostException, IOException{
		CalendarHandler ch = new CalendarHandler();
		TCPClient tcp = new TCPClient();
		ClientLogin cl = new ClientLogin();
		cl.setEmail("nibr13ae");
		cl.setPassWord("1234");
		
		Gson gson = new GsonBuilder().create();
		String gsonString = gson.toJson(cl);
		
		String jsonString = tcp.TalkToServer(gsonString);
		
		ClientLogin cl2 = (ClientLogin)gson.fromJson(jsonString, ClientLogin.class);
		System.out.println(cl2.getCalendars().get(2).get(10).getStart());
		ch.setCalendar(cl2.getCalendars());
		
		ArrayList<UserEvent> weekEvents = ch.getWeekEvents(48, 2014);
		
		System.out.println(weekEvents.get(1).getEventid());
	}
}

