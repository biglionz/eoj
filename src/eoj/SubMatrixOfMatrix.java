package eoj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Point{
	int x;
	int y;
	public Point() {
		x = 0;
		y = 0;
	}
	public Point(int a, int b) {
		x = a;
		y = b;
	}
}

public class SubMatrixOfMatrix {
	public static void main(String[] args) {
		int[][] square = {{1, 2, 3, 4, 1, 6},
				          {5, 6, 7, 8, 2, 3},
				          {6, 5, 7, 9, 1, 4},
				          {3, 4, 2, 8, 8, 10},
				          {1, 1, 1, 1, 10, 3},
				          {1, 1, 1, 1, 1, 1}
						};
		int k = 2;
		SubMatrixOfMatrix smm = new SubMatrixOfMatrix();
		System.out.println(smm.Solution(square, k));
	}
	
	public int Solution(int[][] square, int k) {
		if(square == null || square.length == 0 || square[0].length == 0) {
			return 0;
		}
		int res = 0;
		int n = square.length;
	
		int maxValue = Integer.MIN_VALUE;
		Set<Integer> set = new HashSet<>();
		List<Point> list = new ArrayList<>();
		
		for(int i = 0; i <= n - k; i++) {
			for(int j = 0; j <= n - k; j++) {
				if(getMaxValue(i, j, square, k) < maxValue) {
					continue;
				}else if(getMaxValue(i, j, square, k) > maxValue) {
					maxValue = Math.max(maxValue, getMaxValue(i, j, square, k));
					list.clear();
					list.add(new Point(i, j));
				}else {
					list.add(new Point(i, j));
				}
			}
		}
		
		for(Point p : list) {
			for(int h = 0; h < k; h++) {
				for(int q = 0; q < k; q++) {
					set.add(square[p.x + h][p.y + q]);
				}
			}
		}
		
		for(int sum : set) {
			res += sum;
		}
		return res;
	}
	
	private int getMaxValue(int i, int j, int[][] square, int k) {
		int sum = Integer.MIN_VALUE;
		for(int n = 0; n < k; n++) {
			for(int m = 0; m < k; m++) {
				sum += square[i + n][j + m];
			}
		}
		return sum;
	}
}
