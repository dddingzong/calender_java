import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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

			if (year == -1) {
				System.out.println("Bye~");
				break;
			}

			if (month > 12 | month < 1) {
				System.err.println("오류입니다.");
				continue;
			}

			cal.printcalender(year, month);
		}

		sc.close();
	}

	public static void main_clender(String[] args) {
		Prompt p = new Prompt();
		p.runPrompt();

	}

	public static void main(String[] args) {

		String date = "default";
		String work_list;
		ArrayList<String> existList = new ArrayList<String>();
		HashMap<String, ArrayList<String>> workspace = new HashMap<String, ArrayList<String>>(); // HashMap생성

		// I/O 관리
		String Save_file = "calender.dat";
		File f = new File(Save_file);
		// 파일 불러오기
		if (!f.exists()) {
			System.err.println("일정이 없습니다.");
		} else {
			try {
				Scanner s = new Scanner(f);
				while (s.hasNext()) {
					String line = s.nextLine();
					// System.out.println(line);
					String[] words = line.split(",");
					date = words[0];

					if (workspace.containsKey(date) == false) {
						ArrayList<String> work = new ArrayList<String>();
						workspace.put(date, work); // workspace hashmap에 arrayList 추가
					}

					int step = workspace.get(date).size();
					
					if (step == 0) {
						work_list = words[1 + step];
						work_list = work_list.replaceAll("]","");
						work_list = work_list.replaceAll("\\[","");
					} else {
						work_list = words[1 + step].replaceAll("]",""); 
					}
					
					// System.out.println(work_list);
					existList = workspace.get(date);
					existList.add(work_list); // 일정을 ArrayList에 추가

					// workspace.put(date, existList);

					// System.out.println(workspace);

				}
				s.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}

		Scanner sc = new Scanner(System.in);
		boolean flag = true;

		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록");
		System.out.println("| 2. 일정 검색");
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말 q. 종료");
		System.out.println("+----------------------+");

		while (flag == true) {
			System.out.println("명령 (1, 2, 3, h, q)");
			System.out.println("명령을 입력하세요.");
			System.out.print("> ");
			String number = sc.next();

			// 1번 입력
			if (number.equals("1")) {
				System.out.println("[일정 등록] 날짜를 입력하세요.");
				System.out.print("> ");
				date = sc.next();

				if (workspace.containsKey(date) == false) {
					ArrayList<String> EmptyList = new ArrayList<String>();
					workspace.put(date, EmptyList); // workspace hashmap에 arrayList 추가
				}

				sc.nextLine(); // ignore one newLine
				System.out.println("일정을 입력하세요.");
				System.out.print("> ");
				work_list = sc.nextLine(); // 일정 받기

				existList = workspace.get(date);

				existList.add(work_list); // 일정을 ArrayList에 추가
				workspace.put(date, existList);
				System.out.println("일정을 등록되었습니다.");

				// I/O 시도
				try {
					FileWriter fw = new FileWriter(f, true);

					String shortword = date + "," + existList + "\n";
					fw.write(shortword);
					fw.close();
					//System.out.println(date + ":" + existList);
				} catch (IOException e) {
					e.printStackTrace();
				}

			} else if (number.equals("2")) {
				System.out.println("[일정 검색] 날짜를 입력하세요.");
				System.out.print("> ");
				String date_search = sc.next(); // 조회 날짜 정하기

				if (workspace.containsKey(date_search) == false) {
					System.out.println("일정이 비어있습니다.");
				} else {
					System.out.println(workspace.get(date_search).size() + "개의 일정이 있습니다.");
					for (int i = 0; i < workspace.get(date_search).size(); i++) {
						System.out.println(workspace.get(date_search).get(i));
					}
				}
			} else if (number.equals("3")) {
				calender_수정 cal = new calender_수정();

				System.out.println("년도를 입력하세요");
				System.out.print("YEAR> ");
				int year = sc.nextInt();

				System.out.println("월을 입력하세요");
				System.out.print("MONTH> ");
				int month = sc.nextInt();

				if (month > 12 | month < 1) {
					System.err.println("오류입니다.");
				} else {
					cal.printcalender(year, month);
				}

			} else if (number.equals("h")) {
				System.out.println("+----------------------+");
				System.out.println("| 1. 일정 등록");
				System.out.println("| 2. 일정 검색");
				System.out.println("| 3. 달력 보기");
				System.out.println("| h. 도움말 q. 종료");
				System.out.println("+----------------------+");
			} else if (number.equals("q")) {
				flag = false;
				System.out.println("Bye~");
			}

		}
		sc.close();
	}
}