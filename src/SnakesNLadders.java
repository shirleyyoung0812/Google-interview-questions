import java.util.*;
/**
 * http://shirleyisnotageek.blogspot.com/2015/03/snakes-and-ladders.html
 * @author shirleyyoung
 *
 */
public class SnakesNLadders {
	public static int roles(Struct[][] board){
		if(board == null || board.length == 0 || board[0].length == 0 || board.length != board[0].length)
			return 0;
		int n = board.length;
		int[] roles = new int[n * n];
		for(int i = 0; i < n * n; i++){
			int x = i / n;
			int y = (x % 2 != 0) ? (n - 1 - i % n) : i % n;
			if(i < 6){
				roles[i] = board[x][y].s.equals("SU") ? Integer.MAX_VALUE / 2 : 1;
			}
			else{
				roles[i] = Integer.MAX_VALUE;
				for(int j = i - 6; j < i; j++)
					roles[i] = Math.min(roles[i], roles[j] + 1);
				if(board[x][y].s.equals("LU"))
					//in case the lower end of the ladder is the upper end of the
					//snake
					roles[i] = Math.min(ladder(board, x, y, roles),  roles[i]);
				else if(board[x][y].s.equals("SU"))
					roles[i] = Integer.MAX_VALUE / 2;
			}
		}
		
		return roles[n * n - 1];
	}
	private static int ladder(Struct[][] board, int x, int y, int[] roles){
		int n = board.length;
		int xc = board[x][y].x;
		return xc % 2 != 0 ? roles[xc * n + (n - 1 - board[x][y].y)]
					: roles[xc * n + board[x][y].y];
	}
	/**
	 * consists the string which represents the status of the square:
	 * "SU": snake upper side
	 * "SL": snake lower side
	 * "LU": ladder upper side
	 * "LL": ladder lower side
	 * as well as the coordinates of its corresponding end
	 * e.g., "SU", 1, 1 indicates the lower side of the snake is at x = 1, y = 1	
	 * @author shirleyyoung
	 *
	 */
	private static class Struct{
		String s;
		//the coordinate of the corresponding square
		int x;
		int y;
		public Struct(String s, int x, int y){
			this.s = s;
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) {
		Struct[][] board = new Struct[4][4];
		for(int i = 0; i < 4; i++)
			//indicate nothing in the square
			Arrays.fill(board[i], new Struct("", -1, -1));
		board[0][1] = new Struct("SL", 1, 2);
		board[1][2] = new Struct("SU", 0, 1);
		board[0][3] = new Struct("LL", 2, 3);
		board[2][3] = new Struct("LU", 0, 3);
		board[1][1] = new Struct("SL", 3, 2);
		board[3][2] = new Struct("SU", 1, 1);
		board[1][0] = new Struct("LL", 2, 0);
		board[2][0] = new Struct("LU", 1, 0);
		System.out.println(roles(board));
	}
}
