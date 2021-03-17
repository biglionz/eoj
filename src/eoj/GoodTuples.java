//Give an array and find the count of a pair number and a single number combination in a row of this array. Target array is a[i - 1], a, a[i + 1]
//Example:
//Input: a = [1, 1, 2, 1, 5, 3, 2, 3]
//Output: 3
//Explain:
//[1, 1, 2] -> two 1 and one 2(O)
//[1, 2, 1] -> two 1 and one 2(O)
//[2, 1, 5] -> one 2, one 1 and one five(X)
//[1, 5, 3] -> (X)
//[5, 3, 2] -> (X)
//[3, 2, 3] -> (O)
package eoj;

public class GoodTuples {
	public int solution(int[] a) {
        int res = 0;
        for(int i = 1; i < a.length - 1; i++) {
            res += check(a[i-1], a[i], a[i+1]);
        }
        return res;
    }

    public static int check(int a, int b, int c) {
        if(a == b && a != c) {
            return 1;
        } else if (a == c && a != b) {
            return 1;
        } else if (b == c && a != b) {
            return 1;
        } else {
            return 0;
        }
    }


    public static void main(String[] args){
        GoodTuples gt = new GoodTuples();
        int[] array = {1, 1, 2, 1, 5, 3, 2, 3};
        System.out.print(gt.solution(array));
    }
}
