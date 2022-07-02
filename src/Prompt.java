import java.util.Scanner;

public class Prompt {
	
	
	public void runPrompt() {
		Scanner sc = new Scanner(System.in);
		calender_수정 cal = new calender_수정();
		
		while (true) {
			System.out.println("년도를 입력하세요");
			System.out.print("YEAR> ");
			int year = sc.nextInt();
			System.out.println("월을 입력하세요");
			System.out.print("MONTH> ");
			int month = sc.nextInt();
			
			if (month == -1) {
				System.out.println("Bye~");
				break;
			}
			
			if (month > 12) {
				continue;
			}
			
			cal.printcalender(year,month);
		}
	}
	
	
	public static void main(String[] args) {
		Prompt p = new Prompt();
		p.runPrompt();
	}
}