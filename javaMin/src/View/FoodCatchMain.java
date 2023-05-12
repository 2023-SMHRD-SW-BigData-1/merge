package View;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Conn.DAO;
import JDBC.Member_DAO;
import JDBC.Member_DTO;
import JDBC.RecipeDAO;
import JDBC.RecipeDTO;
import JDBC.Score_DTO;

// 정렬 하지 말아주세요!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 글자 다 깨져요!!!!!!!!!!!!!
public class FoodCatchMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Member_DAO dao = new Member_DAO();
		DAO da = new DAO();
		Random ran = new Random();
		RecipeDAO rdao = new RecipeDAO();

		while (true) {

			System.out.println("\r\n" + "\r\n"
					+ "░█████╗░░█████╗░░█████╗░██╗░░██╗░░░  ██████╗░░█████╗░██████╗░██████╗░██╗░░░██╗░░░      \r\n"
					+ "██╔══██╗██╔══██╗██╔══██╗██║░██╔╝░░░  ██╔══██╗██╔══██╗██╔══██╗██╔══██╗╚██╗░██╔╝░░░      \r\n"
					+ "██║░░╚═╝██║░░██║██║░░██║█████═╝░░░░  ██║░░██║███████║██║░░██║██║░░██║░╚████╔╝░░░░      \r\n"
					+ "██║░░██╗██║░░██║██║░░██║██╔═██╗░██╗  ██║░░██║██╔══██║██║░░██║██║░░██║░░╚██╔╝░░██╗      \r\n"
					+ "╚█████╔╝╚█████╔╝╚█████╔╝██║░╚██╗╚█║  ██████╔╝██║░░██║██████╔╝██████╔╝░░░██║░░░╚█║      \r\n"
					+ "░╚════╝░░╚════╝░░╚════╝░╚═╝░░╚═╝░╚╝  ╚═════╝░╚═╝░░╚═╝╚═════╝░╚═════╝░░░░╚═╝░░░░╚╝      \r\n"
					+ "\t██████╗░███████╗██╗░░░░░██╗░█████╗░██╗░█████╗░██╗░░░██╗░██████╗██╗\r\n"
					+ "\t██╔══██╗██╔════╝██║░░░░░██║██╔══██╗██║██╔══██╗██║░░░██║██╔════╝██║\r\n"
					+ "\t██║░░██║█████╗░░██║░░░░░██║██║░░╚═╝██║██║░░██║██║░░░██║╚█████╗░██║\r\n"
					+ "\t██║░░██║██╔══╝░░██║░░░░░██║██║░░██╗██║██║░░██║██║░░░██║░╚═══██╗╚═╝\r\n"
					+ "\t██████╔╝███████╗███████╗██║╚█████╔╝██║╚█████╔╝╚██████╔╝██████╔╝██╗\r\n"
					+ "\t╚═════╝░╚══════╝╚══════╝╚═╝░╚════╝░╚═╝░╚════╝░░╚═════╝░╚═════╝░╚═╝");

			System.out.println("\t");
			System.out.printf("%20s%20s%20s   %s   ", "[1]회원가입", "[2]로그인", "[3]종료", ">>");
			int input = sc.nextInt();
			int scoreL = 0;
			switch (input) {
			case 1:// 회원가입
				while (true) {
					System.out.println("\n\t\t   ================ 회원가입 ================");
					System.out.print("\n\t\t\t\t  ID 입력 : ");
					String id = sc.next();
					System.out.print("\t\t\t\t  PW 입력 : ");
					String pw = sc.next();
					System.out.print("\t\t\t\t  이름 입력 : ");
					String name = sc.next();
					System.out.println();
					Member_DTO mdto = new Member_DTO(id, pw, name, scoreL);
					int row = dao.join(mdto);
					if (row > 0) {
						System.out.println("\t\t   ============== 회원가입 성공 ==============");
						break;
					} else {
						System.out.println("\t\t   ============== 회원가입 실패 ==============");
						System.out.println("\t\t\t\t다시 입력해주세요!!");
						System.out.println("\t\t\t[1]다시입력\t\t[2]이전");
						System.out.print("\t\t   ========================================  >> ");
						int selec = sc.nextInt();
						if (selec == 1) {
							continue;
						} else {
							break;
						}
					}
				}
				break;
			// -----------------------------------------------------------------------------------------------------------------------------------------------------------
			case 2:// 로그인
					// 1. 사용자로부터 아이디와 비밀번호 입력 받기
				System.out.println("\n\t\t   ================ 로그인 ================");
				System.out.print("\n\t\t\t\t  ID 입력 : ");
				String id = sc.next();
				System.out.print("\t\t\t\t  PW 입력 : ");
				String pw = sc.next();
				Member_DTO dto = dao.login(id, pw);
				if (dto != null) {// 로그인 성공
					while (true) {
						System.out.println(
								"\r\n" + "\t░██╗░░░░░░░██╗███████╗██╗░░░░░░█████╗░░█████╗░███╗░░░███╗███████╗\r\n"
										+ "\t░██║░░██╗░░██║██╔════╝██║░░░░░██╔══██╗██╔══██╗████╗░████║██╔════╝\r\n"
										+ "\t░╚██╗████╗██╔╝█████╗░░██║░░░░░██║░░╚═╝██║░░██║██╔████╔██║█████╗░░\r\n"
										+ "\t░░████╔═████║░██╔══╝░░██║░░░░░██║░░██╗██║░░██║██║╚██╔╝██║██╔══╝░░\r\n"
										+ "\t░░╚██╔╝░╚██╔╝░███████╗███████╗╚█████╔╝╚█████╔╝██║░╚═╝░██║███████╗\r\n"
										+ "\t░░░╚═╝░░░╚═╝░░╚══════╝╚══════╝░╚════╝░░╚════╝░╚═╝░░░░░╚═╝╚══════╝");
						System.out.println("");
						System.out.printf("%15s%15s%15s%15s   %s   ", "[1]게임방법", "[2]게임시작", "[3]랭킹보기", "[4]이전", ">>");
						int input2 = sc.nextInt();
						switch (input2) {
						case 1:// 게임방법
							System.out.print("\n\t\t    --조리방법을 보고 어떤 요리인지 맞히는 게임입니다.--\n\t-- 조리방법은 6단계로 나눠져 있습니다."
									+ "\n\t-- 첫 번째 조리방법을 보고 정답입력 후 정답시 30점 획득, 오답시 5점 차감 후 다음 조리방법 오픈"
									+ "\n\t-- 오답 후 다음 조리방법 오픈할 때마다 5점씩 차감되면서 정답 맞힌 시점의 점수 획득"
									+ "\n\t-- 3번째, 5번째, 6번째 조리방법 오픈시 힌트 추가제공" + "\n\t-- 한 문제 당 제한시간은 100초, 총 문제는 5문제");
							System.out.println("\n");
							System.out.print("\t\t\t\t [1]확인 >> ");
							int select = sc.nextInt();
							System.out.println("\n");
							if (select == 1)
								break;

						case 2: // 게임시작
							int gameNum = 5;
							int selectList[] = new int[gameNum];
							int recipeNum = rdao.RecipeNumber() + 1;
							for (int i = 0; i < gameNum; i++) {
								int random = ran.nextInt(recipeNum);
								selectList[i] = random;
								for (int j = 0; j < i; j++) {
									if (selectList[j] == random) {
										i--;
										break;
									}
								}
							}

							int totalScore = 0;
							for (int i = 0; i < gameNum; i++) {
								System.out.printf("[%d번째 레시피 문제 시작]\n", i + 1);
								int score = 30;
								RecipeDTO rdto = rdao.getRDTO(selectList[i]);
								String recipe[] = rdao.getRecipe(selectList[i]);
								for (int j = 0; j < 6; j++) {
									System.out.printf("레시피 - %d : %s\n", j + 1, recipe[j]);
									if (j % 2 == 1) {
										switch (j / 2) {
										case 0:
											System.out.println("첫번째 힌트 : 백종원유튜브의 먹는 소리 출력");
											rdto.getHint1();
											break;
										case 1:
											System.out.println("두번째 힌트 : 그림 힌트 출력");
											rdto.getHint2();
											break;
										case 2:
											System.out.println("세번째 힌트 : " + rdto.getHint3());
											break;
										}
									}
									System.out.print("정답 >> ");
									String ans = sc.next();
									if (ans.equals(rdto.getAns())) {
										totalScore += score;
										System.out.printf("정답입니다! (+%d)\n\n", score);
										break;
									}
									System.out.println("오답입니다!(-5)\n");
									score -= 5;
								}
								if (score == 0) {
									System.out.println("기회를 다 소진했습니다.. (+0)\n");
								}
								System.out.println("\n\n\n\n\n");
							}

							System.out.println(("총점 : ") + totalScore);

							break;
						case 3:// 랭킹보기
							ArrayList<Score_DTO> arr = dao.rank();

							System.out.println("\n\t\t   ============== 점수 보기 ==============");
							System.out.printf("\t\t\t%10s%9s\n\t\t\t %10s%10s", "닉네임", "스코어", "===", "===");
							System.out.println();
							for (int i = 0; i < arr.size(); i++) {
								System.out.printf("\t\t\t%10s%10d", arr.get(i).getName(), arr.get(i).getScore());
								System.out.println();
							}
							break;
						case 4: // 이전

							break;
						}// <--input2 switch
						if (input2 == 4) {
							break;
						}
					} // <--input2 while
				} else {
					System.out.println("로그인 실패");
				}
				break;
			// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			case 3:
				System.out.println("시스템 종료");

				break;
			}// <-- input switch
			if (input == 3) {
				break;
			} // <-- 종료 if
		} // <-- main while

	}// <-- Main
}// <-- class
