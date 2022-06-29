import java.util.Scanner;

public class calender2 {

	private static final int[] date = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int maxdays(int month) {
		return date[month - 1];
	}

	public static void main(String[] args) {

		System.out.println("달을 입력하세요");
		Scanner sc = new Scanner(System.in);
		calender2 cal = new calender2();
		int month = sc.nextInt();

		System.out.println(month + "월은 " + cal.maxdays(month) + "일까지 있습니다.");

		sc.close();
	}
}
