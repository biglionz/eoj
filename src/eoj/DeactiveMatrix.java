package eoj;

//!!!!!pay attention to the index of matrix is start with 1   !!!!!!
//You are given two numbers n and m representing the dimensions of an n * m rectangular board
//The rows of the board are numbered form 1 to n, and the columns are numbered from 1 to m.
//Each cell has a value equal to the product of its row index and the column index (both 1 based)
//In other words, board[i][j] = (i + 1) * (j + 1)
//
//Initially, all the cells in the board are considered active, though some of them will eventually be deactivated through a sequence of queries
//You will be given an array queries, where each query is of one of the following 3 types
//
//[0] -- find the minimum value among all remaining active cells on the board
//[1, i] -- deactivate all cells in row i
//[2, j] -- deactivate all cells in column j
//
//Given the dimensions n , m and the array of queries, your task is to return an array consisting of calculated values
//in the order in which they were calculated
//
//Example:
//for n = 3, m = 4 , and the queries = [[0], [1, 2], [0], [2, 1], [0], [1, 1], [0]]
//the output should be matrixQueries(n, m, queries) = [1, 1, 2, 6]
//the matrix looks like:
//[1, 2, 3, 4],
//[2, 4, 6, 8],
//[3, 6, 9, 12]
//		
//In the beginning, all cells are active , hence the minimum value among all remaining active cells is board[0][0] = 1 * 1 = 1
//After the second query, only the second row is inactive, so the minimum value is still board[0][0] = 1 * 1 = 1, looks like
//[1, 2, 3, 4],
//[*, *, *, *],
//[3, 6, 9, 12]
//		
//After the fourth query, the second row and the first column are inactive, so the answer is board[0][1] = 1 * 2 = 2
//[*, 2, 3, 4],
//[*, *, *, *],
//[*, 6, 9, 12]
//		
//Finally, the first and the second rows and the first column are inactive, so the answer is board[2][1] = 3 * 2 = 6
//[*, *, *, *],
//[*, *, *, *],
//[*, 6, 9, 12]

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//deactivateһ�л�һ������Сֵ
public class DeactiveMatrix {
    public int[] solution(int[][] queries, int m, int n){
        int[] memo = new int[2];               //��¼��ǰ��Сֵ������
        int minval = Integer.MAX_VALUE;        //��¼��ǰ��Сֵ
        for(int i=0; i<m; i++){                //�������е�ȡ����Сֵ �� ��Сֵ������
            for(int j=0; j<n; j++){
                if((i+1)*(j+1)<minval){
                    memo[0] = i;
                    memo[1] = j;
                    minval = (i+1)*(j+1);
                }
            }
        }
        
        Set<Integer> row = new HashSet<>();        //������hashSet���ֱ��ű�deactivate�ĺ�������
        Set<Integer> col = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        
        for(int[] query: queries){                 
            if(query.length==1){                   //�����ȡֵ��query,������ǰά������Сֵ��������û��deactivate��
                if(!row.contains(memo[0]) && !col.contains(memo[1])){          //����set���ѯ��û�иõ㣬��Ϊset�����ű����õĵ�
                    res.add(minval);
                }else{                              //��������ã������±���matrix,���������õĵ������
                    minval = Integer.MAX_VALUE;
                    for(int i=0; i<m; i++){
                        if(row.contains(i)) continue;
                        for(int j=0; j<n; j++){
                            if(col.contains(j)) continue;
                            if((i+1)*(j+1)<minval){
                                memo[0] = i;
                                memo[1] = j;
                                minval = (i+1)*(j+1); 
                            }
                        }
                    }
                    res.add(minval);
                }
            }else{                               //�����л�����
                if(query[0] == 1){
                    row.add(query[1]-1);
                }else if(query[0] == 2){
                    col.add(query[1]-1);
                }
            }
        }

        int[] result = new int[res.size()];    //��ͷ��List add�ȽϿ죬������Ҫת��array�������Ϊ�����Ҫ����array
        for(int i=0; i<res.size(); i++){
            result[i] = res.get(i);
        }
    
        return result;
    }

    public static void main(String[] args){
    	DeactiveMatrix mq = new DeactiveMatrix();
        int[][] queries = new int[][]{{0},{1,2},{0},{2,1},{0},{1,1},{0}};
        int[]res = mq.solution(queries, 3,4);
        for(int i=0; i<res.length; i++){
            System.out.print(res[i]);
            System.out.print(" ");
        }
    }
}