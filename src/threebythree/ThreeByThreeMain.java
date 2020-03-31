package threebythree;

import java.util.Scanner;

public class ThreeByThreeMain {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Game gamePlay = new Game();
		
		gamePlay.show();
		
		System.out.println("입력");
		String a = scanner.nextLine();
		if(a.equalsIgnoreCase("A")) {
			gamePlay.left();
		}
		
		gamePlay.show();
		
		/**
		
		00 01 02
		10 11 12
		20 21 22
		
		0 0 -> 위 x 좌 x 우 o 밑 o  우 밑
		0 1 -> 위 x 좌 o 우 o 밑 o  좌 우 밑
		0 2 -> 위 x 좌 o 우 x 밑 o  좌 밑
		1 0 -> 위 o 좌 x 우 o 밑 o  위 우 밑
		1 1 -> 위 o 좌 o 우 o 밑 o  위 좌 우 밑
		1 2 -> 위 o 좌 o 우 x 밑 o  위 좌 밑
		2 0 -> 위 o 좌 x 우 o 밑 x  위 우
		2 1 -> 위 o 좌 o 우 o 밑 x  위 좌 우
		2 2 -> 위 o 좌 o 우 x 밑 x  위 좌
		
		첫번째 인덱스 0 -> 밑 o 
		첫번째 인덱스 1 -> 밑 o 위 o 
		첫번째 인덱스 2 -> 위 o
		두번째 인덱스 0 -> 우 o 
		두번째 인덱스 1 -> 우 o 좌 o 
		두번째 인덱스 2 -> 좌 o
		
		*/

		
		
		
		
		
		
	}
}
