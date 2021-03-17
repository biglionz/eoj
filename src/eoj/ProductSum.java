// 1 �ܼ򵥣�һ�����֣�������λ���ĳ˻���ȥ����λ���ĺ͡�
package eoj;

public class ProductSum {
	public int Solution(int num) {
		int sum = 0;
		int prod = 1;
		while(num != 0) {
			int a = num % 10;
			num /= 10;
			prod *= a;
			sum += a;
		}
		return prod - sum;
	}
	
	public static void main(String[] args) {
		int num = 1655468;
		ProductSum ps = new ProductSum();
		System.out.println(ps.Solution(num));
	}
}
