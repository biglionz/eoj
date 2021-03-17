package eoj;

import java.util.Arrays;

//��a b�������飬���޺����ޣ����������޺�����֮��� a\[i\]ƽ�� + b[j]ƽ�� ��������ϵ�������
public class NumberOfArrayInUpperLower {
  public int solution(int[] a, int[] b){
      int[] array = new int[a.length+b.length];
      int i=0;
      for(;i<a.length; i++){
          array[i] = a[i];
      }

      int index = i;
      for(int j=0; j<b.length; j++){
          array[index] = b[j];
          index++;
      }

      Arrays.sort(array);
      int lower = array[0];
      int upper = array[array.length-1];
      int res = 0;
      for(int i1=0; i1<a.length;i1++){
          int start = 0;
          int end = b.length-1;
          while(start<=end && a[i1]*a[i1]+b[start]*b[start]<lower){
              start++;
          }
          while(start<=end && a[i1]*a[i1]+b[end]*b[end]>upper){
              end--;
          }
          if(start<=end){
              res+=end-start+1;
          }
      }

      return res;
  }

  public static void main(String[] args){
      int[] a = new int[]{1,2,3,4,5};
      int[] b = new int[]{6,7,8,9,50};
      NumberOfArrayInUpperLower ua = new NumberOfArrayInUpperLower();
      System.out.print(ua.solution(a,b));
  }
}