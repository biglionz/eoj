package eoj;

//给s 和 t两个String, 任意从s 或 t 中删去一个数字，使 s < t， 问有几种可能性
public class RemoveExactOneDigit {
	private static int removeExactOneDigit(String s1, String t1) {
		StringBuilder sb = new StringBuilder(s1);
		int res = 0;
		for(int i=0;i<sb.length();i++) {
			if(Character.isDigit(sb.charAt(i))) {
				char c = sb.charAt(i);
				sb.deleteCharAt(i);
				if(sb.toString().compareTo(t1) < 0)
					res++;
				sb.insert(i, c);
			}
		}
		sb = new StringBuilder(t1);
		for(int i=0;i<sb.length();i++) {
			if(Character.isDigit(sb.charAt(i))) {
				char c = sb.charAt(i);
				sb.deleteCharAt(i);
				if(sb.toString().compareTo(s1) > 0)
					res++;
				sb.insert(i, c);
			}
		}
		return res;
	}
    
    public static void main(String[] args) {
    	String s = "123ab";
    	String t = "423cd";
    	System.out.println(removeExactOneDigit(s, t));
    }
    

}
