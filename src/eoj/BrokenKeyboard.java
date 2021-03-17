package eoj;

import java.util.HashSet;
import java.util.Set;

public class BrokenKeyboard {
	public static int brokenKeyboard(String a, char[] b) {
		int res = 0;
		boolean flag = true;
		Set<Character> set = new HashSet<>();
		for(char c : b) {
			set.add(c);
		}
		String[] words = a.toLowerCase().split(" ");
		for(String word : words) {
			for(Character letter : word.toCharArray()) {
				if(Character.isLowerCase(letter)) {
					if(!set.contains(letter)) {
						flag = false;
						break;
					}
				}
			}
			if(flag) {
				res++;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		String a = "hEllo##, This^^";
		char[] b = {'i','e','o','l','h'};
		System.out.println(brokenKeyboard(a, b));
	}
}
