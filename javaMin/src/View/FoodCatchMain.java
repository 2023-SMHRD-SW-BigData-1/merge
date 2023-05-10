package View;

import java.util.Random;
import java.util.Scanner;

import Conn.DAO;
import JDBC.Member_DAO;
import JDBC.Member_DTO;
import JDBC.RecipeDAO;
import JDBC.RecipeDTO;

public class FoodCatchMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Member_DAO dao = new Member_DAO();
		DAO da = new DAO();
		Random ran=new Random();
		RecipeDAO rdao=new RecipeDAO();
		
		while (true) {
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
			System.out.printf("%20s%20s%20s   %s   ", "[1]회원가입", "[2]로그인", "[3]종료", ">>");
			int input = sc.nextInt();
			int score = 0;

			switch(input){
			case 1:// 회원가입
				System.out.print("\t\t\t\t ID 입력 : ");
				String id = sc.next();
				System.out.print("\t\t\t\t PW 입력 : ");
				String pw = sc.next();
				System.out.print("\t\t\t\t 이름 입력 : ");
				String name = sc.next();
				System.out.println();
				Member_DTO mdto = new Member_DTO(id, pw, name, score);
				int row = dao.join(mdto);
				if (row > 0) {
					System.out.println("회원가입 성공");
				} else {
					System.out.println("회원가입 실패");
				}
			break;
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------					
			case 2 :// 로그인
				    // 1. 사용자로부터 아이디와 비밀번호 입력 받기
				System.out.print("ID 입력 : ");
				id = sc.next();
				System.out.print("PW 입력 : ");
				pw = sc.next();
				Member_DTO dto = dao.login(id, pw);
				if (dto != null) {// 로그인 성공
					while(true) {
						System.out.println("\r\n"
								+ "\t░██╗░░░░░░░██╗███████╗██╗░░░░░░█████╗░░█████╗░███╗░░░███╗███████╗\r\n"
								+ "\t░██║░░██╗░░██║██╔════╝██║░░░░░██╔══██╗██╔══██╗████╗░████║██╔════╝\r\n"
								+ "\t░╚██╗████╗██╔╝█████╗░░██║░░░░░██║░░╚═╝██║░░██║██╔████╔██║█████╗░░\r\n"
								+ "\t░░████╔═████║░██╔══╝░░██║░░░░░██║░░██╗██║░░██║██║╚██╔╝██║██╔══╝░░\r\n"
								+ "\t░░╚██╔╝░╚██╔╝░███████╗███████╗╚█████╔╝╚█████╔╝██║░╚═╝░██║███████╗\r\n"
								+ "\t░░░╚═╝░░░╚═╝░░╚══════╝╚══════╝░╚════╝░░╚════╝░╚═╝░░░░░╚═╝╚══════╝");
						System.out.println("");
					System.out.printf("%15s%15s%15s%15s   %s   ","[1]게임방법","[2]게임시작","[3]랭킹보기","[4]이전",">>");
					int input2 = sc.nextInt();
					switch(input2){
					case 1:// 게임방법
						System.out.print("\n\t\t    --조리방법을 보고 어떤 요리인지 맞히는 게임입니다.--\n\t-- 조리방법은 6단계로 나눠져 있습니다."
									+ "\n\t-- 첫 번째 조리방법을 보고 정답입력 후 정답시 30점 획득, 오답시 5점 차감 후 다음 조리방법 오픈"
									+ "\n\t-- 오답 후 다음 조리방법 오픈할 때마다 5점씩 차감되면서 정답 맞힌 시점의 점수 획득"
									+ "\n\t-- 3번째, 5번째, 6번째 조리방법 오픈시 힌트 추가제공" + "\n\t-- 한 문제 당 제한시간은 100초, 총 문제는 5문제");
							 System.out.println("\n");
							 System.out.print("\t\t\t\t [1]확인 >> ");
							 int select = sc.nextInt();
							 System.out.println("\n");
							if(select == 1) break;
							 
					
					case 2: // 게임시작
							da.TimeFirst();
							int gameNum=5;
							int selectList[]=new int[gameNum];
							int recipeNum=rdao.RecipeNumber()+1;
							for(int i=0;i<gameNum;i++) {
								int random=ran.nextInt(recipeNum);
								selectList[i]=random;
								for(int j=0;j<i;j++) {
									if(selectList[j]==random) {
										i--;
										break;
									}
								}
							}
							
							
							for(int i=0;i<gameNum;i++) {
								System.out.printf("[%d번째 레시피 문제 시작]\n",i+1);
								RecipeDTO rdto=rdao.getRDTP(selectList[i]);
								String recipe[]=rdao.getRecipe(selectList[i]);
								for(int j=0;j<6;j++) {
									System.out.printf("레시피 - %d : %s\n",j+1,recipe[j]);
								}
							}
							
					break;		
					case 3 ://랭킹보기
						
					break;
					case 4: // 이전
						
					break;
					}//<--input2 switch
					if(input2 == 4) {
						break;
					}
					}//<--input2 while
				} else {
					System.out.println("로그인 실패");
				}
				break;
	//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------			
			case 3:
				System.out.println("시스탬 종료");
			break;
				}//<-- input switch
			if(input == 3) {
				break;
			}//<-- 종료 if
			}//<-- main while
		
		
		}//<-- Main
	}//<-- class
