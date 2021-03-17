package eoj;

public class RibbonCut {
	public int ribboncut(int[] L, int k) {
		if(L.length == 0 || L == null) {
			return 0;
		}
		long maxValue = 0, sumValue = 0;
		for(int i = 0; i < L.length; i++) {
			sumValue += L[i];
			maxValue = Math.max(maxValue, L[i]);
		}
		int start = 1, end = (int)Math.min(maxValue, sumValue / k);
		if(start > end) {
			return 0;
		}
		while(start + 1 < end) {
			int mid = start + (end - start) / 2;
			if(sumPieces(L, mid) >= k) {
				start = mid;
			}else {
				end = mid;
			}
		}
		if(sumPieces(L, end) >= k) {
			return end;
		}
		if(sumPieces(L, start) >= k) {
			return start;
		}
		return 0;
	}
	
	private int sumPieces(int[] L, int mid) {
		int sum = 0;
		for(int i = 0; i < L.length; i++) {
			sum += L[i] / mid;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int[] L = {232, 124, 456};
		int k = 7;
		RibbonCut rc = new RibbonCut();
		System.out.println(rc.ribboncut(L, k));
	}
}
