package eoj;

import java.util.HashSet;
import java.util.Set;

public class IsPrefix {
	private static String connect(String[] a) {
        StringBuilder sb = new StringBuilder();
        for (String str : a) {
            sb.append(str);
        }
        
        return sb.toString();
    }

    private static void swap(String[] a, int i, int j) {
        String tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static void dfs(Set<String> permutation, String[] a, int pos) {
    	if (pos == a.length) {
    		permutation.add(connect(a));
    	}
        for (int i = pos; i < a.length; i++) {
            swap(a, pos, i);
            dfs(permutation, a, pos + 1);
            swap(a, pos, i);
        }
    }

    private static Set<String> generate(String[] a) {
        Set<String> permutation = new HashSet<>();
        dfs(permutation, a, 0);
        return permutation;
    }

    public static boolean isPrefix(String[] a, String[] b) {
        Set<String> permutation = generate(a);

        for (String str : b) {
            if (!permutation.contains(str)) {
                return false;
            }
        }

        return true;
    }
    
    public static void main(String[] args) {
        String[] a = new String[] {"ab", "bc", "cd"};
        String[] b = new String[] {"abbccd", "bccdab"};

        System.out.println(isPrefix(a, b));
    }
}
