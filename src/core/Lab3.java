package core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import date.Date;
import date.DateRange;
/**
 * 
 * @author Chris Buckner
 *
 */
public class Lab3 {
	/**
	 * 
	 * main method
	 */
	public static void main(String[] args) {
		// create an instance of ArrayList containing Date objects('dList')
		ArrayList<Date> dList = new ArrayList<Date>();
		Scanner n = null;
		// open file
		try {
			n = new Scanner(new File("data.txt"));
		} catch (FileNotFoundException e) {
			System.err.println("Failed to open data.txt!");
			System.exit(1);
		}
		// while Scanner object has a line to read in....
		while (n.hasNextLine()) {
			// create String 'line' by reading in the entire line
			String line = n.nextLine();
			// create a Date object using 'line' as a parameter
			Date date = new Date(line);
			// check to make sure date is valid
			if (date.isValid()) 
			{ // date is valid,
				
				System.out.println(date);
				dList.add(date);
			}else {  // date is NOT valid, 
				
				System.out.println("Date: Invalid Date");
			}
			// if the ArrayList 'dList' has two dates in it
			if (dList.size() == 2)
			{ // do this....
				// create a value by comparing the 2 dates in array
				int val = dList.get(0).compareTo(dList.get(1));
				if (val == -1)
				{ // val == -1 means the date at index 0 precedes date at index 1 so,
					
					// create a DateRange object using both dates in 'dList'
					DateRange dRange = new DateRange(dList.get(0), dList.get(1));
					// print the DateRange object out
					System.out.println(dRange);
					// remove the first date in the dList array
					dList.remove(0);
				}
				else if (val == 1)
				{ // val == 1 means the date at index 0 does NOT precede the date at index 1
					// remove the date at index 0 from the array of date objects
					dList.remove(0);
				}
				
			} // end if statement
		} // end while loop		
	} // end method main		
} // end class Lab3
