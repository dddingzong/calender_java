import java.util.Scanner;

public class calender2 {
	public static void main(String[] args) {
		int[] date = new int[] {31,28,31,30,31,30,31,31,30,31,30,31};
		
		System.out.println("달을 입력하세요");
		Scanner sc = new Scanner(System.in);
		
		int month = sc.nextInt();
		System.out.println(month+"월은 "+date[(month-1)]+"일까지 있습니다.");
		sc.close();
	}
}

