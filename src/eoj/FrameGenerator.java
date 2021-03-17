//第一题
//frame generator
//给一个整数n 假设是4的数输出一个这样的正方形
//****
//*   *
//*   *
//****
package eoj;

public class FrameGenerator {
	public char[][] framegenerator(int a){
		char[][] res = new char[a][a];
		for(int i = 0; i < a; i++) {
			res[0][i] = '*';
			res[i][a - 1] = '*';
			res[a - 1][i] = '*';
			res[i][0] = '*';
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int a = 4;
		FrameGenerator fg = new FrameGenerator();
		char[][] res = fg.framegenerator(a);
		for(int i = 0; i < res.length; i++) {
			for(int j = 0; j < res[0].length; j++) {
				System.out.print(res[i][j]);
			}
			System.out.println();
		}
	}
}
