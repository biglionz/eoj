//give a number n and digit number k , find all serial substring is able to divisible n
//example:
//input : n = 120, k = 2
//output : 2
//explain: 120 -> 12 and 20
//120 % 12 == 0  yes
//120 % 20 == 0 yes

//input: n = 555, k = 1;
//output: 1
//explain: 555 -> 5 and 5 and 5 (duplicate only count one 5)
//555 % 5 = 0 yes

//input: n = 2345 , k = 2
//output : 0
//explain: 2345 -> 23 34 45
//2345 % 23 != 0 no
//2345 % 34 != 0 no
//2345 % 45 != 0 no

package eoj;

import java.util.HashSet;
import java.util.Set;

public class DivisorSubString {
	public int Solution(int num, int k) {
		if(num == 0) return 0;
		int res = 0;
		String val = String.valueOf(num);
		Set<Integer> set = new HashSet<>();
		
		for(int i = 0; i <= val.length() - k; i++) {
			String subnum = val.substring(i, i + k);
			int sub_num = Integer.parseInt(subnum);
			if(sub_num == 0) continue;
			if(!set.contains(sub_num)) {
				set.add(sub_num);
				if(num % sub_num == 0) {
					res++;
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int num = 120;
		int k = 2;
		DivisorSubString dss = new DivisorSubString();
		System.out.println("res = " + dss.Solution(num, k));
	}
}
