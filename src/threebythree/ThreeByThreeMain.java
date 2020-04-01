package threebythree;

import java.util.Scanner;
/*
일단 움직이는것 부터 만들어 보라는 아이디어를 친구가 알려줌 ㅠㅠ
 */
public class ThreeByThreeMain {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Game gamePlay = new Game();
		
		

		gamePlay.shuffle();
		
		System.out.println("3by3게임을 시작합니다.\n중간에 종료하고싶으면 exit를 입력하세요^^");
		
		gamePlay.show();
		while(true) {
			System.out.println("입력>");
			String move = scanner.nextLine();
			if(move.equalsIgnoreCase("A")) {
				gamePlay.left();
			} else if(move.equalsIgnoreCase("D")) {
				gamePlay.right();
			} else if(move.equalsIgnoreCase("S")) {
				gamePlay.down();
			} else if(move.equalsIgnoreCase("w")) {
				gamePlay.up();
			} else if(move.equalsIgnoreCase("exit")) {
				System.out.println("게임을 종료합니다.");
				System.exit(0);
			} else {
				gamePlay.show();
				System.out.println("A,S,D,W 키로 이동합니다.");
			}
		}
		
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
