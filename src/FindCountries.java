/**
 * 2D matrix with 0s and 1s. 
 * Try to find out how many countries in this matrix? 
 * For example: 
 * [[1,1,1,0] 
 * [1,1,0,0] 
 * [0,0,0,1]] 
 * return 3, because one for 1s, one for 0s, 
 * and one for the last one. 
 * another example: 
 * [[1,1,1,1] 
 * [0,0,0,0] 
 * [1,0,0,1]] 
 * return 4
 * 
 * A country is a region that all elements are the same, 
 * DFS
 * @author shirleyyoung
 *
 */
public class FindCountries {
	public static int countries(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			throw new IllegalArgumentException("Invalid input matrix");
		int countries = 0;
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (!visited[i][j]) {
					visit(i, j, matrix, visited);
					countries++;
					//printMatrix(visited);
				}
			}
		}
		return countries;
	}
	private static void visit(int i, int j, int[][] matrix, boolean[][] visited) {
		visited[i][j] = true;
		int rows = matrix.length;
		int cols = matrix[0].length;
		if (i - 1 >= 0 && matrix[i - 1][j] == matrix[i][j] && !visited[i - 1][j]) 
			visit(i - 1, j, matrix, visited);
		if (i + 1 < rows && matrix[i + 1][j] == matrix[i][j] && !visited[i + 1][j])
			visit(i + 1, j, matrix, visited);
		if (j - 1 >= 0 && matrix[i][j - 1] == matrix[i][j] && !visited[i][j - 1])
			visit(i, j - 1, matrix, visited);
		if (j + 1 < cols && matrix[i][j + 1] == matrix[i][j] && !visited[i][j + 1])
			visit(i, j + 1, matrix, visited);
			
	}
	public static void printMatrix(boolean[][] visited) {
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[i].length; j++) {
				System.out.print(visited[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("***************");
	}
	public static void main(String[] args) {
		/*int[][] matrix = {
				{1, 1, 1, 0},
				{1, 1, 0, 0},
				{0, 0, 0, 1}
		};*/
		/*int[][] matrix = {
				{1, 1, 1, 1},
				{0, 0, 0, 0},
				{1, 0, 0, 1}
		};*/
		/*int[][]matrix = {
				{1}
		};*/
		/*int[][]matrix = {
				{1, 0, 1, 1}
		};*/
		int[][]matrix = {
				{1},
				{1},
				{0},
				{0}
		};
		System.out.println(countries(matrix));
		

	}

}
