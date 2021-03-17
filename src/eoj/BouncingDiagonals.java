package eoj;


//ÃèÊö¼û£ºhttps://www.1point3acres.com/bbs/thread-666608-1-1.html
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class BouncingDiagonals {
	public int[] bouncingdiagonals(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return null;
		}
		int m = matrix.length, n = matrix[0].length;
		Map<Integer, Integer> map = new TreeMap<>();
		int[] res = new int[m];
		
		for(int i = 0; i < m; i++) {
			int row = i;
			int col = 0;
			int sum = 0;
			boolean reachTop = false;
			while(col < n) {
				sum += matrix[row][col];
				if(row == 0) {
					reachTop = true;
				}
				if(reachTop) {
					row++;
					col++;
				}else {
					row--;
					col++;
				}
			}
			map.put(i, sum);
		}
		
		List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>(){
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		
		int index = 0;
		for(Map.Entry<Integer, Integer> mapping : list) {
			res[index] = mapping.getKey();
			index++;
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[][] matrix = new int[][]{{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15}, {16,17,18,19,20}, {21,22,23,24,25}};
		BouncingDiagonals bd = new BouncingDiagonals();
		int[] res = bd.bouncingdiagonals(matrix);
		for(int i = 0; i < res.length; i++){
            System.out.print(res[i]);
            System.out.print(" ");
        }
	}
}
