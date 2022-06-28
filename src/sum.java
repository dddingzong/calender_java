import java.util.Scanner;



public class sum {
	public static void main(String[] args) {
		System.out.println("두 수를 입력하새요.");
		
		Scanner sc = new Scanner(System.in);

	    String inputValue = sc.nextLine();
	    String[] splitedValue = inputValue.split(" ");
	    int a = Integer.parseInt(splitedValue[0]);
	    int b = Integer.parseInt(splitedValue[1]);
	       
	    System.out.println("두 수의 합은 " + (a+b) + "입니다.");
	    
	}
}
