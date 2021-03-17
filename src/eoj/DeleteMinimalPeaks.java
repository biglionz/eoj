package eoj;

//delete minimal peaks��minimal peaks������array�����Ҷ����Լ�С��element��Ȼ��������minimal peaks����С�ģ�ɾ�����ӵ�һ��list��ֱ��ɾ�ꡣ

import java.util.ArrayList;
import java.util.List;

public class DeleteMinimalPeaks {
  public List<Integer> solution(int[] array){
      List<Integer> list = new ArrayList<>();
      List<Integer> res = new ArrayList<>();
      for(int num: array){
          list.add(num);
      }

      while(!list.isEmpty()){
          if(list.size() == 1){
              res.add(list.get(0));
              break;
          }
          int index = 0;
          int val = Integer.MAX_VALUE;
          for(int i=0; i<list.size(); i++){
              if(i==0){
                  if(list.get(i)>=list.get(i+1)){
                      if(list.get(i)<=val){
                          index = i;
                          val = list.get(i);
                      }
                  }
              }else if(i==list.size()-1){
                  if(list.get(i)>=list.get(i-1)){
                      if(list.get(i)<=val){
                          index = i;
                          val = list.get(i);
                      }
                  }
              }else{
                  if(list.get(i)>=list.get(i-1) && list.get(i)>=list.get(i+1)){
                      if(list.get(i)<=val){
                          index = i;
                          val = list.get(i);
                      }
                  }
              }
          }
          list.remove(index);
          res.add(val);

      }
      return res;
  }

  public static void main(String[] args){
	  DeleteMinimalPeaks dm = new DeleteMinimalPeaks();
      int[] array = {1, 2, 0, 3, 5, 9, 3, 6, 7, 3, 5, 7, 1, 3};
      System.out.print(dm.solution(array));
  }
}