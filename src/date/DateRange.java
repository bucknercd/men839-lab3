package date;
/**
 * 
 * @author Chris Buckner
 *
 */
public class DateRange {
	/**
	 * class that contains two dates, begining and end
	 */
	
	private Date begin, end;
	/**
	 * 
	 * @param begin
	 * @param end;
	 * constructor to set the two dates to their values
	 * 
	 */
	public DateRange(Date begin, Date end) {
		this.begin = begin;
		this.end = end;
	}
	/**
	 * overrides toString to produce desired dateRange output
	 */
	public String toString() {
		String output = "DateRange: "+begin+" - "+end;
		return output;
	}
}
