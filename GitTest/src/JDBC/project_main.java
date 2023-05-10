package JDBC;

import java.util.Scanner;

public class project_main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		DAO dao = new DAO();

		System.out.println("      ============== 게임첫화면 ==============      ");
		while (true) {
			System.out.println("[1]회원가입 [2]로그인 [3]종료 >>");
			int input = sc.nextInt();

			if (input == 1) {
				System.out.print(">> ID 입력 : ");
				String id = sc.next();
				System.out.print(">> PW 입력 : ");
				String pw = sc.next();
				System.out.print(">> 이름 입력 : ");
				String name = sc.next();
				System.out.print(">> 점수 : ");
				int score = 0;

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
						System.out.print("조리방법을 보고 어떤 요리인지 맞히는 게임/n1. 조리방법은 6단계로 나눠져 있습니다."
								+ "/n첫 번째 ");
					}
					}

			} else {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}
}
