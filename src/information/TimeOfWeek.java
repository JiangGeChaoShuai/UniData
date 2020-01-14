package information;

public class TimeOfWeek {

	private String date;
	private int beginTime;
	private int endTime;
	
	public TimeOfWeek(String date, int beginTime, int endTime) {
	
		this.date = date;
		this.beginTime = beginTime;
		this.endTime = endTime;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(int beginTime) {
		this.beginTime = beginTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	
}
