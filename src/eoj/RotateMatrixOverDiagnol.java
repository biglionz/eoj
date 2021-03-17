package eoj;

public class RotateMatrixOverDiagnol {
	public void Solution(int[][] matrix, int k) {
		 if(matrix.length == 0 || matrix[0].length == 0 || matrix == null) {
			 return;
		 }
		 k = k % 4;
		 for(int i = 0; i < k; i++) {
			 rotate(matrix);
		 }
	}
	
	private void rotate(int[][] matrix) {
		int N = matrix.length;
		int rightdiagonal = N - 1;
		
		for(int i = 0; i < N; i++) {
			for(int j = i; j < N; j++) {
				if(j != rightdiagonal) {
					int temp = matrix[i][j];
					matrix[i][j] = matrix[j][i];
					matrix[j][i] = temp;
				}
			}
			rightdiagonal--;
		}

		
		int leftdiagonal = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < (N / 2); j++) {
				if(j == leftdiagonal || j == N - leftdiagonal - 1) continue;
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][N - 1 - j];
				matrix[i][N - 1 - j] = temp;
			}
			leftdiagonal++;
		}
	}
	
	public static void main(String[] args) {
		RotateMatrixOverDiagnol rmod = new RotateMatrixOverDiagnol();
		int[][] matrix = {{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		int k = 1;
		rmod.Solution(matrix, k);
		for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j]);
                System.out.print(",");
            }
            System.out.print("\n");
        }
	}
}
