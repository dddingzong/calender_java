import java.util.Scanner;

public class calender3 {
	public static void main(String[] args) {
		
		int[] date = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int[] month_list = new int[12];
		
		System.out.println("반복횟수를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		int iter = sc.nextInt();
		
		System.out.println("");
		
		System.out.println("월을입력하세요");
		
		for (int i=0;i<iter;i++) {
			int month = sc.nextInt();
			month_list[i] = month;
		}
		
		System.out.println("");
		
		for (int i=0;i<iter;i++) {
		System.out.println(month_list[i] + "월은 " + date[month_list[i] - 1] + "일까지 있습니다.");
		}
		
		System.out.println("끝!");
		
		sc.close();
	}
}
