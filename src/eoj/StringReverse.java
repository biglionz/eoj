//反转连续的两个字符, "abcdef" => "badcfe"
//如果不连续则不变

package eoj;

public class StringReverse {
	public String reverseString(String word) {
		if(word == null || word.length() == 0) {
			return "";
		}
		char[] res = word.toCharArray();
		for(int i = 0; i < word.length() - 1; i++) {
			if((res[i + 1] - 'a') - (res[i] - 'a') == 1) {
				char temp = res[i];
				res[i] = res[i + 1];
				res[i + 1] = temp;
			}
		}
		return new String(res);
	}
	
	public static void main(String[] args) {
		String word = "avcdef";
		StringReverse sr = new StringReverse();
		System.out.print(sr.reverseString(word));
	}
}
