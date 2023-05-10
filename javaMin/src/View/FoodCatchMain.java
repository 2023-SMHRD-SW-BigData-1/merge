package View;

import java.util.Scanner;

import JDBC.DAO;
import JDBC.DTO;

public class FoodCatchMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DAO dao = new DAO();
		System.out.println("\r\n" + "\r\n"
				+ "░█████╗░░█████╗░░█████╗░██╗░░██╗░░░  ██████╗░░█████╗░██████╗░██████╗░██╗░░░██╗░░░      \r\n"
				+ "██╔══██╗██╔══██╗██╔══██╗██║░██╔╝░░░  ██╔══██╗██╔══██╗██╔══██╗██╔══██╗╚██╗░██╔╝░░░      \r\n"
				+ "██║░░╚═╝██║░░██║██║░░██║█████═╝░░░░  ██║░░██║███████║██║░░██║██║░░██║░╚████╔╝░░░░      \r\n"
				+ "██║░░██╗██║░░██║██║░░██║██╔═██╗░██╗  ██║░░██║██╔══██║██║░░██║██║░░██║░░╚██╔╝░░██╗      \r\n"
				+ "╚█████╔╝╚█████╔╝╚█████╔╝██║░╚██╗╚█║  ██████╔╝██║░░██║██████╔╝██████╔╝░░░██║░░░╚█║      \r\n"
				+ "░╚════╝░░╚════╝░░╚════╝░╚═╝░░╚═╝░╚╝  ╚═════╝░╚═╝░░╚═╝╚═════╝░╚═════╝░░░░╚═╝░░░░╚╝      \r\n" + "\r\n"
				+ "\t██████╗░███████╗██╗░░░░░██╗░█████╗░██╗░█████╗░██╗░░░██╗░██████╗██╗\r\n"
				+ "\t██╔══██╗██╔════╝██║░░░░░██║██╔══██╗██║██╔══██╗██║░░░██║██╔════╝██║\r\n"
				+ "\t██║░░██║█████╗░░██║░░░░░██║██║░░╚═╝██║██║░░██║██║░░░██║╚█████╗░██║\r\n"
				+ "\t██║░░██║██╔══╝░░██║░░░░░██║██║░░██╗██║██║░░██║██║░░░██║░╚═══██╗╚═╝\r\n"
				+ "\t██████╔╝███████╗███████╗██║╚█████╔╝██║╚█████╔╝╚██████╔╝██████╔╝██╗\r\n"
				+ "\t╚═════╝░╚══════╝╚══════╝╚═╝░╚════╝░╚═╝░╚════╝░░╚═════╝░╚═════╝░╚═╝");

		System.out.println("\t");
		while (true) {
			System.out.printf("%20s%20s%20s   %s", "[1]회원가입", "[2]로그인", "[3]종료", ">>");
			int input = sc.nextInt();
			int score = 0;

			if (input == 1) {
				System.out.print(">> ID 입력 : ");
				String id = sc.next();
				System.out.print(">> PW 입력 : ");
				String pw = sc.next();
				System.out.print(">> 이름 입력 : ");
				String name = sc.next();
				System.out.println();

				DTO mdto = new DTO(id, pw, name, score);
				int row = dao.join(mdto);

				if (row > 0) {
					System.out.println("회원가입 성공");
				} else {
					System.out.println("회원가입 실패");
				}

			} else if (input == 2) {
				// 로그인
				// 1. 사용자로부터 아이디와 비밀번호 입력 받기
				System.out.print("ID 입력 : ");
				String id = sc.next();
				System.out.print("PW 입력 : ");
				String pw = sc.next();
				DTO dto = dao.login(id, pw);
				if (dto != null) {
					System.out.println("로그인 성공");
				} else {
					System.out.println("로그인 성공");
				}
				System.out.println("      ============== 게임두번째화면 ==============      ");
				while (true) {
					System.out.println("[1]게임방법 [2]게임시작 [3]랭킹보기 [4]종료 >>");
					int input2 = sc.nextInt();

					if (input2 == 1) {
						System.out.print("조리방법을 보고 어떤 요리인지 맞히는 게임\n1. 조리방법은 6단계로 나눠져 있습니다."
								+ "\n2. 첫 번째 조리방법을 보고 정답입력 후 정답시 30점 획득, 오답시 5점 차감 후 다음 조리방법 오픈"
								+ "\n3. 오답 후 다음 조리방법 오픈할 때마다 5점씩 차감되면서 정답 맞힌 시점의 점수 획득"
								+ "\n4. 3번째, 5번째, 6번째 조리방법 오픈시 힌트 추가제공" + "\n5. 한 문제 당 제한시간은 100초, 총 문제는 5문제");
						System.out.println();
					} else if (input2 == 2) {

					} else if (input2 == 3) {

					} else {
						System.out.println("프로그램을 종료합니다.");
						break;
					}
				}

			} else {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}

	}

}
