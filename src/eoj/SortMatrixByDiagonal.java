package eoj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortMatrixByDiagonal {
	public void Solution(int[][] matrix){
		if(matrix.length == 0 || matrix[0].length == 0 || matrix == null) return;
		int m = matrix.length;
		int n = matrix[0].length;
		
		for(int i = 0; i < n; i++) {
			int row = 0;
			int col = i;
			List<Integer> nums = new ArrayList<>();
			while(row < m && col < n) {
				nums.add(matrix[row][col]);
				row++;
				col++;
			}
			Collections.sort(nums);
			row = 0;
			col = i;
			for(int num : nums) {
				matrix[row][col] = num;
				row++;
				col++;
			}
		}
		
		for(int j = 0; j < m; j++) {
			int row = j;
			int col = 0;
			List<Integer> nums = new ArrayList<>();
			while(row < m && col < n) {
				nums.add(matrix[row][col]);
				row++;
				col++;
			}
			Collections.sort(nums);
			row = j;
			col = 0;
			for(int num : nums) {
				matrix[row][col] = num;
				row++;
				col++;
			}
		}
		
	}
	
	public static void main(String[] args) {
		int[][] original= {{1, 5, 6},
				   		   {6, 7, 8},
				           {5, 8, 3},
				           {8, 4, 6},
				           {9, 1, 1}
				           };
		SortMatrixByDiagonal smbd = new SortMatrixByDiagonal();
		smbd.Solution(original);
		for(int i = 0; i < original.length; i++) {
			for(int j = 0; j < original[0].length; j++) {
				System.out.print(original[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		
	}
}
