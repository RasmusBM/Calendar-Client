package shared;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;


public class Event  implements java.io.Serializable {
	
	private  final long serialVersionUID = 3L;
	private String overallID;
	private int id;
    private String eventid;
    private int calendarId;
    private int createdby;
    private String description;
    private String title;
    private String location;
    private Timestamp ts;
    private ArrayList<String> start;
    private ArrayList<String> end;
    private Timestamp startTimestamp;
    private Timestamp endTimestamp;
    private String type;
    private boolean active;
    
    
    public Event(int id, String eventid, int calendarId, int createdby,
			String title, String description, String location, Timestamp start, Timestamp end, String type, boolean active) {
		super();
		this.id = id;
		this.eventid = eventid;
		this.calendarId = calendarId;
		this.createdby = createdby;
		this.description = description;
		this.title = title;
		this.location = location;
		this.startTimestamp = start;
		this.endTimestamp = end;
		this.type = type;
		this.active = active;
	}
    
    public Event(){
    	
    }
    
    public String getOverallID() {
		return overallID;
	}
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}

	public void setEventid(String event_id){
        this.eventid = event_id;
    }
    public int getId(){
        return id;
    }

    public int getCalendarId() {
		return calendarId;
	}
	public void setCalendarId(int calendarId) {
		this.calendarId = calendarId;
	}
	public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }

    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return description;
    }

    public void setLocation(String location){
        this.location = location;
    }
    public String getLocation(){
        return location;
    }

    public void setCreatedby(int createdby){
        this.createdby = createdby;
    }
    public int getCreatedby(){
        return createdby;
    }
    
    public void setStart(ArrayList<String> start){
        this.start = start;
    }
    public ArrayList<String> getStart(){
    	return start;
    }

    public void setEnd(ArrayList<String> end){
        this.end = end;
    }
    public ArrayList<String> getEnd(){
        return end;
    }

	public String getEventId() {
		return eventid;
	}
	public void setId(int id) {
		this.id = id;
	}
	
    public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Timestamp getStartTimestamp() {
		
		return this.startTimestamp;
	}

	public Timestamp getEndTimestamp() {
		
		return endTimestamp;
	}
	@Override
	public String toString() {
		return "Event [serialVersionUID=" + serialVersionUID + ", overallID="
				+ overallID + ", id=" + id + ", eventid=" + eventid
				+ ", calendarId=" + calendarId + ", createdby=" + createdby
				+ ", description=" + description + ", title=" + title
				+ ", location=" + location + ", ts=" + ts + ", start=" + start
				+ ", end=" + end + ", type=" + type + ", active=" + active
				+ "]";
	}

	public void setStartTimestamp(Timestamp startTimestamp) {
		this.startTimestamp = startTimestamp;
	}

	public void setEndTimestamp(Timestamp endTimestamp) {
		this.endTimestamp = endTimestamp;
	}

}
