import java.util.Arrays;

public class calender_수정 {
	
	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final String[] WEEKDAYS_ARRAY = {"SU", "MO","TU", "WE", "TH", "FR", "SA"};
	
	public int startpoint(String weekday) {
		return Arrays.asList(WEEKDAYS_ARRAY).indexOf(weekday);
	}

	public boolean isLEAPYEAR(int year) {
		if (year % 4 ==0 & (year % 100 != 0 | year % 400 == 0)) { 
			return true;
		}else{ 
			return false;
		}
	}

	public int getMaxdaysofmonth(int year, int month) {
		if (isLEAPYEAR(year)) {
			return LEAP_MAX_DAYS[(month - 1)];	
		} else {
			return MAX_DAYS[(month - 1)];
		} 
	}

	public void printcalender(int year, int month, String weekday) {
		
		int index = startpoint(weekday);
		
		System.out.printf("   %4d 년 %3d 월\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("--------------------");

		int maxDay = getMaxdaysofmonth(year, month);
		
		//print blank
		for (int j = 1; j <= index; j++) {
			System.out.printf("%3s", " ");
		}
		
		for (int i = 1 + index ; i <= maxDay + index; i++) {
			System.out.printf("%3d", i - index);
			if (i  % 7 == 0) {
				System.out.println("");
			}
		}
		System.out.println();
		System.out.println();

//		System.out.println(" 1  2  3  4  5  6  7");
//		System.out.println(" 8  9 10 11 12 13 14");
//		System.out.println("15 16 17 18 19 20 21");
//		System.out.println("22 23 24 25 26 27 28");
	}
}