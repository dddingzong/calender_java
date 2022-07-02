import java.util.Scanner;

public class calender5 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("년을 입력하세요.");
			System.out.print("YEAR> ");
			int year = sc.nextInt();
			
			System.out.println("월을 입력하세요.");
			System.out.print("MONTH> ");
			int month = sc.nextInt();

			if (month == -1 | year == -1) {
				System.out.println("Bye~");
				break;
			} else if (month > 12) {
				continue;
			} else {
				System.out.printf("   %4d 년 %3d 월\n",year, month);
				System.out.println("SU MO TU WE TH FR SA");
				System.out.println("--------------------");
				System.out.println(" 1  2  3  4  5  6  7");
				System.out.println(" 8  9 10 11 12 13 14");
				System.out.println("15 16 17 18 19 20 21");
				System.out.println("22 23 24 25 26 27 28");
				if (month == 1 | month == 3 | month == 5 | month == 7 | month == 8 | month == 10 | month == 12) {
					System.out.println("29 30 31");
				} else if (month == 4 | month == 6 | month == 9 | month == 11) {
					System.out.println("29 30");
				} else if (month == 2 & year % 4 == 0 & (year % 100 != 0 | year % 400 == 0)) {
					System.out.println("29");
				}
			}

		}
		sc.close();
	}
}
