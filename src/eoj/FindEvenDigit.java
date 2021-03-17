package eoj;

public class FindEvenDigit {
	public int solution(int[] A){
        int res = 0;
        if(A.length==0) return res;
        for(int num: A){
            while(num>0){
                int temp = num%10;
                if(temp %2 == 0){
                    res++;
                    break;
                }else{
                    num = num/10;
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        FindEvenDigit ed = new FindEvenDigit();
        int[] A = {12,344,3456,967};
        System.out.print("Res: ");
        System.out.print(ed.solution(A));
    }
}
