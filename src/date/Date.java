package date;

/**
 * 
 * @author Chris Buckner
 *
 *
 */
public class Date implements Comparable<Date> {
	/**
	 * this class uses the comparable interface for Date objects
	 */
	
	// String objects to represent month day year
	private String month, day, year;
	// ints to represent month day year
	private int dayInt, yearInt, monthInt;
	// a String array that contains the proper names of the months of the year
	private String[] months = {"January","Febuary","March","April","May","June",
			"July","August","September","October","November"
			,"December"};
	/**
	 * 
	 * @param line
	 * Date constructor which parses the line and assigns date month year to string vars
	 * also, replaces the months with the full month name and creates a day as int value
	 */
	public Date(String line) {
		mySplit(line);
		fixMonth(month);
		fixDay(day);
		fixYear(year);
	}
	/**
	 * 
	 * @param line
	 * parses line into 3 parts: month day year
	 */
	public void mySplit(String line) {
		// splits string into 3 tokens
		String[] parts = line.split(" ");
		// assigns each token to a variable
		this.month = parts[0];
		this.day = parts[1];
		this.year = parts[2];		
	}
	/**
	 * 
	 * @param day
	 * removes any comma of of day String arg, casts it to an int
	 */
	public void fixDay(String day) {
		// if the last char of the 'day' token is a comma, remove it
		if (day.charAt(day.length() - 1) == ',' ) {
			day = day.substring(0, day.length() - 1);
		}
		// cast 'day' to an int
		this.dayInt = Integer.parseInt(day);
	}
	/**
	 * 
	 * @param year
	 * casts the string 'year' to an int
	 */
	public void fixYear(String year) {
		this.yearInt = Integer.parseInt(year);
	}
	/**
	 * 
	 * @param month
	 * removes any '.' at end of month string 
	 * replaces the abbreviated month with the proper one
	 */
	public void fixMonth(String month) {
		// if the last char of the 'month' token is a period, remove it
		if (month.charAt(month.length() - 1) == '.' ) {
			month = month.substring(0, month.length() - 1);
		}
		// array of abbreviated months
		String[] sMonths = {"Jan","Feb","Mar","Apr","May","June","July","Aug",
							"Sep","Oct","Nov","Dec"};
		// if the month is abbreviated, modify it to its non-abbreviated spelling and
		// assign the 'monthInt' var its numeric representation of the month for
		// comparison later on
		if (month.contains(sMonths[0])) {
			month = months[0];
			monthInt = 1;
		}
		else if (month.contains(sMonths[1])) {
			month = months[1];
			monthInt = 2;
		}
		else if (month.contains(sMonths[2])) {
			month = months[2];
			monthInt = 3;
		}
		else if (month.contains(sMonths[3])) {
			month = months[3];
			monthInt = 4;
		}
		else if (month.contains(sMonths[4])) {
			month = months[4];
			monthInt = 5;
		}
		else if (month.contains(sMonths[5])) {
			month = months[5];
			monthInt = 6;
		}
		else if (month.contains(sMonths[6])) {
			month = months[6];
			monthInt = 7;
		}
		else if (month.contains(sMonths[7])) {
			month = months[7];
			monthInt = 8;
		}
		else if (month.contains(sMonths[8])) {
			month = months[8];
			monthInt = 9;
		}
		else if (month.contains(sMonths[9])) {
			month = months[9];
			monthInt = 10;
		}
		else if (month.contains(sMonths[10])) {
			month = months[10];
			monthInt = 11;
		}
		else if (month.contains(sMonths[11])) {
			month = months[11];
			monthInt = 12;
		}
		this.month = month;
	}
	/**
	 * 
	 * checks the month and the day of the date to see if 
	 * the date is valid; including leap years
	 * returns boolean condition
	 */
	public boolean isValid() {
		// all month day checks, even leap year checking for February
		if (month.contains(months[0]) && dayInt <= 31) 
		{
			return true;
		}
		else if (month.contains(months[1]) && yearInt % 4 == 0 && dayInt <= 29) 
		{
			return true;
		}
		else if (month.contains(months[1]) && yearInt % 4 != 0 && dayInt <= 28) 
		{
			return true;
		}
		else if (month.contains(months[2]) && dayInt <= 31) 
		{
			return true;
		}
		else if (month.contains(months[3]) && dayInt <= 30) 
		{
			return true;
		}
		else if (month.contains(months[4]) && dayInt <= 31) 
		{
			return true;
		}
		else if (month.contains(months[5]) && dayInt <= 30) 
		{
			return true;
		}
		else if (month.contains(months[6]) && dayInt <= 31) 
		{
			return true;
		}
		else if (month.contains(months[7]) && dayInt <= 31) 
		{
			return true;
		}
		else if (month.contains(months[8]) && dayInt <= 30) 
		{
			return true;
		}
		else if (month.contains(months[9]) && dayInt <= 31) 
		{
			return true;
		}
		else if (month.contains(months[10]) && dayInt <= 30) 
		{
			return true;
		}
		else if (month.contains(months[11]) && dayInt <= 31) 
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * @param Date object
	 * compares 2 dates, starting with year, then month, then day 
	 * returns appropriate value
	 */
	public int compareTo(Date other) {
		if (yearInt < other.yearInt)
		{
			return -1;
		}
		else if (yearInt > other.yearInt)
		{
			return 1;
		}
		else
		{
			if (monthInt < other.monthInt)
			{
				return -1;
			}
			else if (monthInt > other.monthInt)
			{
				return 1;
			}
			else
			{
				if (dayInt < other.dayInt)
				{
					return -1;
				}
				else if (dayInt > other.dayInt)
				{
					return 1;
				}
				else
				{
					return 0;
				}
			} // end inner else statement
		} // end outer else statement  
	} // end method compareTo

	/**
	 * overrides toString method to produce desired date output
	 */
	public String toString() {
		String output = "Date: "+month+" "+" "+day+" "+year;
		return output;
	}
} // end class Date
