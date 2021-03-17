package eoj;

public class SumOfReverse {
	public int sumofReverse(int[] array) {
		int sum = 0;
		for(int num : array) {
			String s = String.valueOf(num);
			char[] ch = s.toCharArray();
			int left = 0, right = ch.length - 1;
			int countZero = 0;
			while(ch[right] == '0' && right > 0 && right < s.length()) {
				right--;
				countZero++;
			}
			while(left <= right && right >= 0 && right < s.length() && left >= 0 && left < s.length()) {
				char temp = ch[left];
				ch[left] = ch[right];
				ch[right] = temp;
				left++;
				right--;
			}
			String newstring = new String(ch);
			sum += Integer.parseInt(newstring);
		}
		return sum;
	}
	
	public static void main(String[] args) {
//		int[] array = {7, 234, 58100};
		int[] array = {0, 100, 220};
		SumOfReverse sr = new SumOfReverse();
		int res = sr.sumofReverse(array);
		System.out.print(res);
	}
}
