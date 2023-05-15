package Controller;

import java.util.Random;

public class GameController {
	Random ran=new Random();
	
	public int[] listSel(int gameNum,int recipenum) {
		int selectList[] = new int[gameNum];
		int recipeNum = recipenum;
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
		return selectList;
	}
}
