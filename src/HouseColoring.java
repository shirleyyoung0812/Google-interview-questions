/**
 * There are a row of houses, each house can be painted with three colors 
 * red, blue and green. The cost of painting each house with a certain color 
 * is different. You have to paint all the houses such that no two adjacent 
 * houses have the same color. You have to paint the houses with minimum cost. 
 * How would you do it?
 * @author shirleyyoung
 *
 */
public class HouseColoring {
	//assume rows are the cost of each color and columns are for each house
	public static int minCost(int[][] house){
		if(house == null || house.length == 0 ||house[0].length == 0)
			return -1;
		int cols = house[0].length;
		int[][] cost = new int[3][cols];
		for(int i = 0; i < 3; i++)
			cost[i][0] = house[i][0];
		for(int j = 1; j < cols; j++){
			cost[0][j] = Math.min(cost[1][j - 1], cost[2][j - 1]) + house[0][j];
			cost[1][j] = Math.min(cost[0][j - 1], cost[2][j - 1]) + house[1][j];
			cost[2][j] = Math.min(cost[0][j - 1], cost[2][j - 1]) + house[2][j];
		}
		return Math.min(cost[0][cols - 1], Math.min(cost[1][cols - 1], cost[2][cols - 1]));
	}
	public static void main(String[] args) {
		int[][] house = new int[3][];
		house[0] = new int[] {1, 3, 2, 6, 7, 8, 9};
		house[1] = new int[] {5, 4, 1, 3, 9, 8, 10};
		house[2] = new int[] {7, 6, 1, 5, 8, 2, 3};
		System.out.println(minCost(house));
	}
}
