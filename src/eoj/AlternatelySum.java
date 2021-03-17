package eoj;

public class AlternatelySum {
	public int Solution(int a) {
		String s = String.valueOf(a);
		int res = 0;
		for(int i = 0; i < s.length(); i++) {
			if(i % 2 == 0) {
				res += s.charAt(i) - '0';
			}else if(i % 2 == 1) {
				res -= s.charAt(i) - '0';
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int a = 25631;
		AlternatelySum as = new AlternatelySum();
		System.out.println(as.Solution(a));
	}
}
