package eoj;

//��s �� t����String, �����s �� t ��ɾȥһ�����֣�ʹ s < t�� ���м��ֿ�����
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
