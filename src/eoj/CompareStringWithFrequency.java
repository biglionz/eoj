package eoj;

//֮ǰ�澭Ҳ���ֹ���compare����string��ֻ��Сд��ĸ�� ÿ��stirng�ڲ��������⻻λ�ã�
//���� λ�ò���Ҫ��ÿ��string�ڲ�����letter���ֵ�Ƶ��Ҳ���Ի�����
//��������ֻ��Ҫ����stringÿ�� frequency���ֵĴ���Ҫһ����
//���硰babzccc�� �� ��bbazzcz�� �ͷ��ء�true������Ϊz��c���Ի���Ƶ�ʡ� ���ǡ�babzcccm�� �� ��bbazzczl�� �Ͳ�һ������Ϊm�ڵ�һ������ֹ����ڶ�����û�г��ֹ���

import java.util.HashSet;
import java.util.Set;

public class CompareStringWithFrequency {
	 public boolean solution(String str1, String str2){
	     if(str1.length() != str2.length()) return false;
	     if(str1.length() == 0 || str2.length() == 0) return false;
	     
	     Set<Character> set = new HashSet<Character>();
	     int[] letter1 = new int[26];
	     int[] letter2 = new int[26];
	     
	     for(int i = 0; i < str1.length(); i++){
	         set.add(str1.charAt(i));
	     }
	     for(int i = 0; i < str2.length(); i++){
	         if(!set.contains(str2.charAt(i))) return false;//�ж���ĸ�Ƿ���ͬ
	     }
	
	
	     for(int i = 0; i < str1.length(); i++){
	         letter1[str1.charAt(i)-'a']++;
	         letter2[str2.charAt(i)-'a']++;
	     }
	
	     int[] frequency1 = new int[str1.length()];//��¼��ĸ���ֵ�Ƶ��
	     int[] frequency2 = new int[str2.length()];
	     
	     for(int i = 0; i < 26; i++){
	         if(letter1[i] != 0){
	             frequency1[letter1[i]]++;//��¼Ƶ�ʵ�Ƶ��
	         }
	         if(letter2[i] != 0){
	             frequency2[letter2[i]]++;
	         }
	     }
	
	     for(int i=0; i < frequency1.length; i++){
	         if(frequency1[i] != frequency2[i]) return false;//�ж�frequency�Ƿ�һ��
	     }
	
	     return  true;
 }

 	public static void main(String[] args){
 		String str1 = "babzccc";
 		String str2 = "bbazzcz";
 		CompareStringWithFrequency str = new CompareStringWithFrequency();
 		System.out.print(str.solution(str1, str2));
 	}
}