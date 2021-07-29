package JsonClasses;

import java.util.ArrayList;

public class GetNotes {
	
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private String overallID = "getNotes";
	ArrayList<CreateNote> notes = new ArrayList<CreateNote>();
	
	public GetNotes(){
		
	}

	public ArrayList<CreateNote> getNotes() {
		return notes;
	}

	public void setNotes(ArrayList<CreateNote> notes) {
		this.notes = notes;
	}
	
}
