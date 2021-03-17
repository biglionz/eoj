package eoj;

public class ReverseDigitPairs {
	public int reverse(int a) {
		if(a < 10 && a > -10) return a;
		int flag = 0;
		if(a < - 10) flag = 1;
		String s = String.valueOf(a);
		char[] chs = s.toCharArray();
		for(int i = flag; i < chs.length; i += 2) {
			char temp = chs[i];
			chs[i] = chs[i + 1];
			chs[i + 1] = temp;
		}
		String str = new String(chs);
		return Integer.parseInt(str);
		
	}
	
	public static void main(String[] args) {
		int a = -163454;
		ReverseDigitPairs rdp = new ReverseDigitPairs();
		System.out.print(rdp.reverse(a));

	}
}
