import java.util.Scanner;

public class calender4 {
	public static void main(String[] args) {
		
		int[] date = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		
		System.out.println("반복횟수를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		int iter = sc.nextInt();
		
		for (int i = 0; i < iter; i++) {
			System.out.println("월을 입력하세요.");
			int month = sc.nextInt();
			
			if (month == -1) {
				System.out.println("Have a nice day!");
				break;
			}else{
				System.out.println(month + "월은 " + date[(month-1)] + "일까지 있습니다.");
			}
		}	
	}
}
