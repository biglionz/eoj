package eoj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

//Divide Array into two with equal size, make sure every element in each two array is unique. return empty list if impossible.

public class DivideToEqualSizeUniqueArray {
    public List<List<Integer>> solution(int[] array){
        if(array.length == 0 || array == null || array.length % 2 != 0) {
        	return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < array.length; i++) {
        	if(map.containsKey(array[i])) {
        		if(map.get(array[i]) >= 2) {
        			return new ArrayList<>();
        		}else {
        			map.put(array[i], map.get(array[i]) + 1);
        		}
        		
        	}else {
        		map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        	}
        }
        
        Iterator<Integer> it = map.keySet().iterator();
        while(it.hasNext()) {
        	int num = it.next();
        	if(map.get(num) == 2) {
        		l1.add(num);
        		l2.add(num);
        	}else {
        		if(l1.size() >= l2.size()) {
        			l2.add(num);
        		}else {
        			l1.add(num);
        		}
        	}
        	it.remove();
        }
        res.add(l1);
        res.add(l2);
        return res;
    }

    public static void main(String[] args){
        int[] array = {1,2,1,7,8,5,7,8};
        DivideToEqualSizeUniqueArray eq = new DivideToEqualSizeUniqueArray();
        List<List<Integer>> res = eq.solution(array);
        if(res.isEmpty()){
            System.out.print("no such array");
            return ;
        }
        List<Integer> list1 = res.get(0);
        List<Integer> list2 = res.get(1);
        System.out.print("res: ");
        for(int i:list1){
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.print("\n");
        System.out.print("res2: ");
        for(int i:list2){
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.print("\n");

    }
}
