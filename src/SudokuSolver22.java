
import java.util.*;
public class SudokuSolver22 {
	private static int dimen = 9;
	//private static int[][] sudoku = new int[dimen][dimen];
	//public static List<String[]> rst = new ArrayList<String[]> ();
	public static Set<String[]> sudokuSolver () {
		Set<String[]> rst = new HashSet<String[]> ();
		int[][] sudoku = new int[dimen][dimen];
		for (int i = 0; i < dimen; i++) {
			for (int j = 0; j < dimen; j++) {
				for (int k = 1; k <= dimen; k++) {
					sudoku[i][j] = k;
					solve(sudoku, rst);
					clear(sudoku);
				}
			}
		}
		return rst;
	}
	private static void clear(int[][] sudoku) {
		for (int i = 0; i < dimen; i++) {
			Arrays.fill(sudoku[i], 0);
		}
	}
	private static boolean solve(int[][] sudoku, Set<String[]> rst) {
		for (int i = 0; i < dimen; i++) {
			for (int j = 0; j < dimen; j++) {
				if (sudoku[i][j] != 0)
					continue;
				for (int k = 1; k <= dimen; k++) {
					sudoku[i][j] = k;
					/*for (int in = 0; in < dimen; in++) {
						for (int jn = 0; jn < dimen; jn++) {
							System.out.format("%4d",sudoku[in][jn]);
						}
						System.out.println("");
					}
					System.out.println("***************\n");*/
					if (isValid(i, j, sudoku) && solve(sudoku, rst)) {
						//rst.add(drawSudoku(sudoku));
						return true;
					}
				}
				sudoku[i][j] = 0;
				return false;
			}
		}
		/*for (int i = 0; i < dimen; i++) {
			for (int j = 0; j < dimen; j++) {
				System.out.format("%4d",sudoku[i][j]);
			}
			System.out.println();
		}*/
		rst.add(drawSudoku(sudoku));
		return true;
	}
	private static String[] drawSudoku(int[][] sudoku) {
		String[] outPut = new String[dimen];
		for (int i = 0; i < dimen; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < dimen; j++) {
				sb.append(sudoku[i][j]).append(",");
			}
			outPut[i] = sb.deleteCharAt(sb.length() - 1).toString();
		}
		return outPut;
	}
	
	private static boolean isValid(int row, int col, int[][] sudoku) {
		Set<Integer> set = new HashSet<Integer> ();
		for (int i = 0; i < dimen; i++) {
			if(sudoku[i][col] == 0)
				continue;
			if (!set.add(sudoku[i][col]))
				return false;
		}
		set.clear();
		for (int j = 0; j < dimen; j++) {
			if(sudoku[row][j] == 0)
				continue;
			if (!set.add(sudoku[row][j]))
				return false;
		}
		set.clear();
		int div = (int)Math.sqrt(dimen);
		for (int i = 0; i < div; i++) {
			for (int j = 0; j < div; j++) {
				if (sudoku[row / div * div + i][col / div * div + j] == 0)
					continue;
				if (!set.add(sudoku[row / div * div + i][col / div * div + j]))
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Set<String[]> rst = sudokuSolver();
		//sudokuSolver();
		/*for (String[] s : rst) {
			for (String row : s) {
				System.out.println(row);
			}
			System.out.println("*****");
		}*/
		System.out.println("Number of solutions: " + rst.size());

	}

}
