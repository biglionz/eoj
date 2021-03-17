package eoj;

import java.util.HashMap;
import java.util.Map;

public class LongestEqualSubarray {
	public int findmaxLength(int[] array) {
		if(array == null || array.length == 0) {
			return 0;
		}
		int res = 0;
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] == 0) array[i] = -1;
		}
		
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < array.length; i++) {
			sum += array[i];
			if(sum == 0) {
				res = i + 1;
			}
			if(map.containsKey(sum)) {
				res = Math.max(i - map.get(sum), res);
			}else {
				map.put(sum, i);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] array = {0,0,1,0,1,0,0};
		LongestEqualSubarray les = new LongestEqualSubarray();
		System.out.print(les.findmaxLength(array));
	}
}
