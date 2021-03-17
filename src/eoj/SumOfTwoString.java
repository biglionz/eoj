package eoj;

public class SumOfTwoString {
	
	public static void main(String[] args) {
		String str1 = "156796";
		String str2 = "45646564";
		System.out.println(combineString(str1, str2));
		
	}
	
	public static String combineString(String str1, String str2) {
		StringBuilder sb = new StringBuilder();
		
		int l1 = str1.length() - 1, l2 = str2.length() - 1;
		for(; l1 >= 0 && l2 >= 0; l1--, l2--) {
			int sum = (str1.charAt(l1) - '0') + (str2.charAt(l2) - '0');
			sb.insert(0, sum);
		}
		for(; l1 >= 0; l1--) {
			sb.insert(0, str1.charAt(l1) - '0');
		}
		for(; l2 >= 0; l2--) {
			sb.insert(0, str1.charAt(l2) - '0');
		}
		return sb.toString();
	}
}

