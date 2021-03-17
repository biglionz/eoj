package eoj;

//����Ƶ����ߵ�����
//Input: A = [22, 2, 3, 33, 5]
//Output: [2, 3]
//��ʼ��һ��case�����ˣ��������³�ʼ����һ��dictionary�� ������A=[]�����

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentDigit {
  int[] solution(int[] nums){
      if(nums == null || nums.length == 0) return new int[0];
      Map<Integer, Integer> mapping = new HashMap<>();
      for(int i:nums){
          while(i>0) {
              int temp = i%10;
              mapping.put(temp, mapping.getOrDefault(temp, 0) + 1);
              i = i/10;
          }
      }
      int max = 0;
      for(int i: mapping.values()){
          if(i>max){
              max = i;
          }
      }
      List<Integer> res = new ArrayList<>();
      for(int i:mapping.keySet()){
          if(mapping.get(i) == max){
              res.add(i);
          }
      }
      int[] res2 = new int[res.size()];
      for(int i=0; i<res.size(); i++){
          res2[i] = res.get(i);
      }
      return res2;
  }

  public static void main(String[] args){
	  MostFrequentDigit mdf = new MostFrequentDigit();
      int[] nums = {22, 2, 3, 33, 5};
      int[]res = mdf.solution(nums);
      for(int i:res){
          System.out.print(i);
          System.out.print(" ");
      }

  }
}