package threebythree;

public class Game {
	
	private String[][] game = new String[3][3];
	int xX = 2;
	int xY = 2;
	
	public Game() {
		for(int i=0; i<game.length; i++) {
			for(int j=0; j<game[i].length; j++) {
				if(i == 2 && j == 2) {
					game[i][j] = "X";
					break;
				} 
				game[i][j] = String.valueOf(i*3 + j+1);
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
	
	public void left() {
		System.out.println("좌로 이동");
		if(xX == 1 && xY == 0) {
			game[0][1] = game[0][0];
			game[0][0] = "X";
			xX = 0;
		} else if(xX == 1 && xY == 1) {
			System.out.println("이경우 해당");
			game[1][1] = game[1][0];
			game[1][0] = "X";
			xX = 0;
		} else if(xX == 1 && xY == 2) {
			game[2][1] = game[2][0];
			game[2][0] = "X";
			xX = 0;
		} else if(xX == 2 && xY == 0) {
			game[0][2] = game[0][1];
			game[0][1] = "X";
			xX = 1;
		} else if(xX == 2 && xY == 1) {
			game[1][2] = game[1][1];
			game[1][1] = "X";
			xX = 1;
		} else if(xX == 2 && xY == 2) {
			game[2][2] = game[2][1];
			game[2][1] = "X";
			xX = 1;
		} else {
			System.out.println("이동불가");
		}
		
		
		
	}
	
	
	
	
	
}
