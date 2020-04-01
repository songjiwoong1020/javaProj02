package threebythree;

import java.util.Scanner;

public class Game {
	//배열 아이디어 친구가 알려줌
	private String[][] game = new String[3][3];
	int xX = 2;
	int xY = 2;
	String x = " ";
	Scanner scanner = new Scanner(System.in);
	
	public Game() {
		for(int i=0; i<game.length; i++) {
			for(int j=0; j<game[i].length; j++) {
				if(i == 2 && j == 2) {
					game[i][j] = x;
					break;
				} 
				//valueOf와 몇가지 for문 아이디어 친구가 알려줌
				game[i][j] = String.valueOf(i*3 + j+1);
			}
		}
	}
	
	public void shuffle() {
//		System.out.println("셔플 발동시");
		for(int i=1; i<200; i++) {
			int random = (int)(Math.random()*4+1);
//			System.out.println(random);
			if(random == 1) {
				comDown();
			}else if(random == 2) {
				comUp();
			}else if(random == 3) {
				comRight();
			}else if(random == 4) {
				comLeft();
			}
		}
	}
	
	public void show() {
		System.out.println("========");
		for(int i=0; i<game.length; i++) {
			for(int j=0; j<game[i].length; j++) {
				System.out.print(game[i][j]+" ");
				}
			System.out.println();
		}
		System.out.println("========");
	}
	
	public void endShow() {
		System.out.println("==성공^^==");
		for(int i=0; i<game.length; i++) {
			System.out.print("ㅐ ");
			for(int j=0; j<game[i].length; j++) {
				System.out.print(game[i][j]+" ");
			}
			System.out.print("ㅐ");
			System.out.println();
		}
		System.out.println("=*=*=*=*=");
	}
	
	
	
	public void end() {
		if(game[0][0].equals("1") &&
			game[0][1].equals("2") &&
			game[0][2].equals("3") &&
			game[1][0].equals("4") &&
			game[1][1].equals("5") &&
			game[1][2].equals("6") &&
			game[2][0].equals("7") &&
			game[2][1].equals("8") &&
			game[2][2].equals(x)) {
				endShow();
				reGame();
		} else {
			show();
		}
	}
	
	public void reGame() {
		System.out.print("다시 하시겠습니까?(yes/no)\n>");
		while(true) {
			String select = scanner.nextLine();
			if(select.equalsIgnoreCase("YES")) {
				System.out.println("게임을 재시작 합니다.");
				shuffle();
				show();
				break;
			} else if(select.equalsIgnoreCase("NO")) {
				System.out.println("게임을 종료합니다.");
				System.exit(0);
			} else {
				System.out.println("Yes or No\n>");
			}
		}
	}
	
	
	
	
	//이동 관련 메소드
	
	public void right() {
		System.out.println("좌로 이동");
		if(xX == 1 && xY == 0) {
			game[0][1] = game[0][0];
			game[0][0] = x;
			xX = 0;
		} else if(xX == 1 && xY == 1) {
			game[1][1] = game[1][0];
			game[1][0] = x;
			xX = 0;
		} else if(xX == 1 && xY == 2) {
			game[2][1] = game[2][0];
			game[2][0] = x;
			xX = 0;
		} else if(xX == 2 && xY == 0) {
			game[0][2] = game[0][1];
			game[0][1] = x;
			xX = 1;
		} else if(xX == 2 && xY == 1) {
			game[1][2] = game[1][1];
			game[1][1] = x;
			xX = 1;
		} else if(xX == 2 && xY == 2) {
			game[2][2] = game[2][1];
			game[2][1] = x;
			xX = 1;
		} else {
			System.out.println("***이동불가***");
		}
		
		end();
		
	}
	
	public void left() {
		System.out.println("우로 이동");
		if(xX == 0 && xY == 0) {
			game[0][0] = game[0][1];
			game[0][1] = x;
			xX = 1;
		} else if(xX == 0 && xY == 1) {
			game[1][0] = game[1][1];
			game[1][1] = x;
			xX = 1;
		} else if(xX == 0 && xY == 2) {
			game[2][0] = game[2][1];
			game[2][1] = x;
			xX = 1;
		} else if(xX == 1 && xY == 0) {
			game[0][1] = game[0][2];
			game[0][2] = x;
			xX = 2;
		} else if(xX == 1 && xY == 1) {
			game[1][1] = game[1][2];
			game[1][2] = x;
			xX = 2;
		} else if(xX == 1 && xY == 2) {
			game[2][1] = game[2][2];
			game[2][2] = x;
			xX = 2;
		} else {
			System.out.println("***이동불가***");
		}
		
		end();
		
	}
	
	public void down() {
		System.out.println("위로 이동");
		if(xX == 0 && xY == 1) {
			game[1][0] = game[0][0];
			game[0][0] = x;
			xY = 0;
		} else if(xX == 1 && xY == 1) {
			game[1][1] = game[0][1];
			game[0][1] = x;
			xY = 0;
		} else if(xX == 2 && xY == 1) {
			game[1][2] = game[0][2];
			game[0][2] = x;
			xY = 0;
		} else if(xX == 0 && xY == 2) {
			game[2][0] = game[1][0];
			game[1][0] = x;
			xY = 1;
		} else if(xX == 1 && xY == 2) {
			game[2][1] = game[1][1];
			game[1][1] = x;
			xY = 1;
		} else if(xX == 2 && xY == 2) {
			game[2][2] = game[1][2];
			game[1][2] = x;
			xY = 1;
		} else {
			System.out.println("***이동불가***");
		}
		
		end();
		
	}
	
	public void up() {
		System.out.println("밑으로 이동");
		if(xX == 0 && xY == 0) {
			game[0][0] = game[1][0];
			game[1][0] = x;
			xY = 1;
		} else if(xX == 1 && xY == 0) {
			game[0][1] = game[1][1];
			game[1][1] = x;
			xY = 1;
		} else if(xX == 2 && xY == 0) {
			game[0][2] = game[1][2];
			game[1][2] = x;
			xY = 1;
		} else if(xX == 0 && xY == 1) {
			game[1][0] = game[2][0];
			game[2][0] = x;
			xY = 2;
		} else if(xX == 1 && xY == 1) {
			game[1][1] = game[2][1];
			game[2][1] = x;
			xY = 2;
		} else if(xX == 2 && xY == 1) {
			game[1][2] = game[2][2];
			game[2][2] = x;
			xY = 2;
		} else {
			System.out.println("***이동불가***");
		}
		
		end();
		
	}
	
	
	public void comRight() {
		if(xX == 1 && xY == 0) {
			game[0][1] = game[0][0];
			game[0][0] = x;
			xX = 0;
		} else if(xX == 1 && xY == 1) {
			game[1][1] = game[1][0];
			game[1][0] = x;
			xX = 0;
		} else if(xX == 1 && xY == 2) {
			game[2][1] = game[2][0];
			game[2][0] = x;
			xX = 0;
		} else if(xX == 2 && xY == 0) {
			game[0][2] = game[0][1];
			game[0][1] = x;
			xX = 1;
		} else if(xX == 2 && xY == 1) {
			game[1][2] = game[1][1];
			game[1][1] = x;
			xX = 1;
		} else if(xX == 2 && xY == 2) {
			game[2][2] = game[2][1];
			game[2][1] = x;
			xX = 1;
		} 
	}
	
	public void comLeft() {
		if(xX == 0 && xY == 0) {
			game[0][0] = game[0][1];
			game[0][1] = x;
			xX = 1;
		} else if(xX == 0 && xY == 1) {
			game[1][0] = game[1][1];
			game[1][1] = x;
			xX = 1;
		} else if(xX == 0 && xY == 2) {
			game[2][0] = game[2][1];
			game[2][1] = x;
			xX = 1;
		} else if(xX == 1 && xY == 0) {
			game[0][1] = game[0][2];
			game[0][2] = x;
			xX = 2;
		} else if(xX == 1 && xY == 1) {
			game[1][1] = game[1][2];
			game[1][2] = x;
			xX = 2;
		} else if(xX == 1 && xY == 2) {
			game[2][1] = game[2][2];
			game[2][2] = x;
			xX = 2;
		}
	}
	
	public void comDown() {
		if(xX == 0 && xY == 1) {
			game[1][0] = game[0][0];
			game[0][0] = x;
			xY = 0;
		} else if(xX == 1 && xY == 1) {
			game[1][1] = game[0][1];
			game[0][1] = x;
			xY = 0;
		} else if(xX == 2 && xY == 1) {
			game[1][2] = game[0][2];
			game[0][2] = x;
			xY = 0;
		} else if(xX == 0 && xY == 2) {
			game[2][0] = game[1][0];
			game[1][0] = x;
			xY = 1;
		} else if(xX == 1 && xY == 2) {
			game[2][1] = game[1][1];
			game[1][1] = x;
			xY = 1;
		} else if(xX == 2 && xY == 2) {
			game[2][2] = game[1][2];
			game[1][2] = x;
			xY = 1;
		}
	}
	
	public void comUp() {
		if(xX == 0 && xY == 0) {
			game[0][0] = game[1][0];
			game[1][0] = x;
			xY = 1;
		} else if(xX == 1 && xY == 0) {
			game[0][1] = game[1][1];
			game[1][1] = x;
			xY = 1;
		} else if(xX == 2 && xY == 0) {
			game[0][2] = game[1][2];
			game[1][2] = x;
			xY = 1;
		} else if(xX == 0 && xY == 1) {
			game[1][0] = game[2][0];
			game[2][0] = x;
			xY = 2;
		} else if(xX == 1 && xY == 1) {
			game[1][1] = game[2][1];
			game[2][1] = x;
			xY = 2;
		} else if(xX == 2 && xY == 1) {
			game[1][2] = game[2][2];
			game[2][2] = x;
			xY = 2;
		}
	}
}
