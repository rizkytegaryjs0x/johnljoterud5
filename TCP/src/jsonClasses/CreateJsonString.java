package jsonClasses;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jsonClasses.*;

public class CreateJsonString {
	Gson gson = new GsonBuilder().create();
	public CreateJsonString(){
		
	}
	
	public String getJson (Object o){
		String JsonString = "";
		String gsonString = gson.toJson(o);
		return JsonString;
	}
}
