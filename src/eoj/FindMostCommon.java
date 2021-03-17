package eoj;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindMostCommon {
	public List<Integer> Solution(int[] nums){
		List<Integer> res = new LinkedList<>();
		if(nums == null || nums.length == 0) {
			return res;
		}
		
		Map<Integer, Integer> map = new HashMap<>();
		int maxValue = Integer.MIN_VALUE;
		for(int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
			maxValue = Math.max(maxValue, map.get(num));
		}
		
		for(int a : map.keySet()) {
			if(map.get(a) == maxValue) {
				res.add(a);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] A = {2, 2, 3, 3, 3, 5, 4, 6};
		FindMostCommon fmc = new FindMostCommon();
		for(int i : fmc.Solution(A)) {
			System.out.print(i + " ");
		}
	}
}
