package eoj;

import java.util.Arrays;

//�������ֲ���(0,a,b)��(1,a,b)��ǰ�߱�ʾ����һ��axb�ľ��Σ�������һ��ѯ�ʣ�ѯ���㵱ǰ�յ������о����Ƿ��ܷŽ�һ��axb�ĺ����
// ���������ܷ�ͬʱ�������ӡ�����ֻҪ����1�ܷŽ�ȥ������2Ҳ�ܷŽ�������OK��
public class MatrixPutIntoBox {
    public boolean[] solution(int[][] queries){
        int size1 = 0;
        int size0 = 0;
        for(int[] query: queries){
            if(query[0] == 1){
                size1++;
            }else if(query[0] == 0){
                size0++;
            }
        }
        boolean[] res = new boolean[size1];
        if(size1!=0 && size0 == 0){
            Arrays.fill(res, true);
            return res;
        }
        int i=0;
        int maxlength = 0;
        int maxwidth = 0;
        size1 = 0;
        size0 = 0;
        for(int[] query: queries){
            int length = Math.max(query[1], query[2]);
            int width = Math.min(query[1], query[2]);
            if(query[0]==0){
                maxlength = Math.max(maxlength, length);
                maxwidth = Math.max(maxwidth, width);
                size0++;
            }else{
                if(size1>=0 && size0 == 0){
                    res[i] = true;
                }else if(length>maxlength || width>maxwidth){
                    res[i] = false;
                }else if(length<=maxlength && width<=maxwidth){
                    res[i] = true;
                }
                i++;
                size1++;
            }
        }
        return res;
    }

    public static void main(String[] args){
    	MatrixPutIntoBox ma = new MatrixPutIntoBox();
        int[][] array = new int[][]{{1,5,6},{1,6,7},{0,6,7},{1,6,7},{0,4,3},{1,6,7},{1,7,8}};
        boolean[] res = ma.solution(array);
        for(int i=0; i<res.length; i++){
            System.out.print(res[i]);
            System.out.print(" ");
        }
    }
}