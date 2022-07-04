public class calender_수정 {

	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	// 해당 년도의 1월 1일의 요일 찾기

	int sum = 0;
	int startYear = 0;

	public int FindweekYear(int year) {
		sum = 0;
		startYear = 0;
		for (int i = 1583; i < year; i++) {
			if (isLEAPYEAR(i)) {
				sum = sum + 2;
			} else {
				sum = sum + 1;
			}
		}
		return (sum + 6) % 7; // 해당 월의 1월 1일 요일
	}

	// 해당 월의 시작 요일 찾기
	public int FindweekMonth(int year, int month) {
		int[] weekMonth = new int[12];
		weekMonth[0] = startYear;

		if (isLEAPYEAR(year)) {
			for (int j = 1; j <= month - 1; j++) {
				weekMonth[j] = (weekMonth[j - 1] + LEAP_MAX_DAYS[j - 1] % 7) % 7;
			}
		} else {
			for (int j = 1; j <= month - 1; j++) {
				weekMonth[j] = (weekMonth[j - 1] + MAX_DAYS[j - 1] % 7) % 7;
			}
		}
		return weekMonth[month - 1]; // 해당 월의 시작 요일
	}

	// 운년 계산
	public boolean isLEAPYEAR(int year) {
		if (year % 4 == 0 & (year % 100 != 0 | year % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}
	
	// 각 달의 최대 일
	public int getMaxdaysofmonth(int year, int month) {
		if (isLEAPYEAR(year)) {
			return LEAP_MAX_DAYS[(month - 1)];
		} else {
			return MAX_DAYS[(month - 1)];
		}
	}

	// 메인 메소드
	public void printcalender(int year, int month) {

		System.out.printf("     %d 년 %d 월\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("---------------------");

		int maxDay = getMaxdaysofmonth(year, month);

		startYear = FindweekYear(year);
		int index = FindweekMonth(year, month);

		// print blank
		for (int j = 1; j <= index; j++) {
			System.out.printf("%3s", " ");
		}

		for (int i = 1 + index; i <= maxDay + index; i++) {
			System.out.printf("%3d", i - index);
			if (i % 7 == 0) {
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