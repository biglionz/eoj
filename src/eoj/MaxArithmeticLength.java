package eoj;

import java.util.LinkedList;

public class MaxArithmeticLength {
    public static void addAfter(int[] b, int idxB, int diff, LinkedList<Integer> temp) {
        while(idxB < b.length) {
            if(b[idxB] == diff + temp.get(temp.size() - 1)) {
                temp.add(b[idxB]);
            }
            idxB++;
        }
    }

    public static void addFront(int[] b, int idxB, int diff, LinkedList<Integer> temp) {
        while(idxB >= 0) {
            if(b[idxB] == temp.get(0) - diff) {
                temp.addFirst(b[idxB]);
            }
            idxB--;
        }
    }

    public static int checkIdxA(int[] a, int idxA, int diff, LinkedList<Integer> temp) {
        while(idxA < a.length) {
            if(a[idxA] == diff + temp.get(temp.size() - 1)) {
                temp.add(a[idxA++]);
            } else {
                break;
            }
        }
        return idxA;
    }
    public static int findLong(int[] b, int val, int pos, int loc) {
        LinkedList<Integer> temp = new LinkedList<Integer>();
        temp.add(val);
        int diff = Math.abs(val - b[loc]);
        int res = 0;
        if(pos == -1) {
            addAfter(b, 0, diff, temp);
        } else if (pos == b.length - 1) {
            addFront(b, b.length - 1, diff, temp);
        } else {
            addAfter(b, pos, diff, temp);
            addFront(b, pos, diff, temp);
        }
        res = Math.max(res, temp.size());
        return res;
    }
    public static int maxArithmeticLength(int[] a, int[] b) {
        int lenA = a.length;
        int lenB = b.length;

        // find the place a[0] in b
        int left = 0, right = lenB - 1;
        int pos = -1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (b[mid] >= a[0]) {
                right = mid - 1;
            } else {
                pos = mid;
                left = mid + 1;
            }
        }

        // pos is the first b[pos] strictly less than a[0]
        int res = -1;
        if(a.length == 1) {
            // only have a[0] but not sure about the difference
            // the problem is equivalent to find the max Arithmetic length
            // contains A[0]
            for(int i = 0; i < b.length; i++) {
                res = Math.max(res, findLong(b, a[0], pos, i));
            }
        } else {
            // get the range of the difference
            int diffMax = a[1] - a[0];
            for(int i = 1; i < lenA; i++) {
                diffMax = Math.min(diffMax, a[i] - a[i-1]);
            }
            for(int diff = 0; diff <= diffMax; diff++) {

                LinkedList<Integer> temp = new LinkedList<Integer>();
                temp.add(a[0]);

                if(pos == -1) {
                    // all elements in b is greater than A[0]
                    int idxA = 1, idxB = 0;
                    while(idxA < lenA && idxB < lenB) {
                        if(a[idxA] == diff + temp.get(temp.size() - 1)) {
                            temp.add(a[idxA++]);
                        } else if (b[idxB] == diff + temp.get(temp.size() - 1)) {
                            temp.add(b[idxB++]);
                        } else {
                            idxB++;
                        }
                    }
                    idxA = checkIdxA(a, idxA, diff, temp);
                    if(idxA == lenA) {
                        addAfter(b, idxB, diff, temp);
                    }
                } else if (pos == lenB - 1) {
                    // all elements in B is smaller than a[0]
                    int idxA = 1;
                    idxA = checkIdxA(a, idxA, diff, temp);
                    if(idxA == lenA) {
                        addFront(b, b.length - 1, diff, temp);
                    }
                } else {
                    // a[0] split [0, pos] and [pos + 1, lenB - 1]
                    int idxA = 1, idxB = pos + 1;
                    while (idxA < lenA && idxB < lenB) {
                        if(a[idxA] == diff + temp.get(temp.size() - 1)) {
                            temp.add(a[idxA++]);
                        } else if (b[idxB] == diff + temp.get(temp.size() - 1)) {
                            temp.add(b[idxB++]);
                        } else {
                            idxB++;
                        }
                    }
                    idxA = checkIdxA(a, idxA, diff, temp);
                    // add range [0, pos]
                    if(idxA == lenA) {
                        addFront(b, pos, diff, temp);
                        addAfter(b, idxB, diff, temp);
                    }
                }
                res = Math.max(res, temp.size());
            }
        }
        return res;
    }

    public static void main(String[] args) {
    	int[] a = {179, 335, 647, 699, 959, 1011, 1635, 2051, 2103, 2415, 2623};
    	int[] b = {2, 12, 24, 27, 45, 53, 55, 74, 82, 87, 95, 111, 117, 119, 120, 123, 127, 128, 129, 138, 160, 168, 176, 198, 199,
    	        224, 229, 231, 263, 283, 300, 308, 319, 322, 340, 341, 353, 387, 411, 415, 429, 438, 439, 443, 446, 466, 468,
    	        491, 518, 525, 531, 539, 543, 569, 570, 587, 594, 595, 751, 803, 855, 907, 1063, 1115, 1167, 1219, 1271, 1323,
    	        1375, 1427, 1479, 1531, 1583, 1687, 1739, 1791, 1843, 1895, 1947, 1999, 2155, 2207, 2259, 2311, 2363, 2467,
    	        2519, 2571};
    	System.out.println(maxArithmeticLength(a, b));
    }
}
