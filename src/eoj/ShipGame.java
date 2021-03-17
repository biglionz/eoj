package eoj;

public class ShipGame {
	public static void main(String[] args) {
		char[][] ships = new char[][]{{'#', '.','.','#'},
	                                  {'#', '.','.','#'},
	                                  {'.', '.','.','.'},
	                                  {'#', '#','.','#'},
	                                  {'.', '#','.','#'}};
	    int[][] moves = new int[][]{{0,0},{1,0},{0,3},{0,2},{4,3},{3,3},{3,0},{3,1},{4,1},{1,3}};
	    for (String s : gameResult(ships, moves)) {
	    	System.out.println(s);
		}
	}
	  
	public static String[] gameResult(char[][] ships,int[][] moves) {
		String[] result = new String[moves.length];
	    int shipsNum = 0;
	    int count = 0;
	    for (int i = 0; i <ships.length ; i++) {
	    	for (int j = 0; j <ships[0].length ; j++) {
	    		if (ships[i][j] == '#') {
	    			shipsNum ++;
	    		}
	    	}
		}
		    
	    for (int i = 0; i <moves.length ; i++) {
	    	if (ships[moves[i][0]][moves[i][1]] == '.') {
	    		result[i] = "Miss";
		    } else {
		        //���У���Χû�� dead
		        //���У���Χ�д�����Χ�Ĵ����Ѿ������� dead
		        //���У���Χ�������д��������� hit
		        //�����Ϊ0
			    if (ships[moves[i][0]][moves[i][1]] == '#') {
			    	  ships[moves[i][0]][moves[i][1]] = '0';
			          count ++;
			          if (count == shipsNum) {
			    	  result[i] = "Game over";
			          } else if (checkAround(ships, moves[i][0] + 1,moves[i][1]) ||
			                  checkAround(ships, moves[i][0] - 1,moves[i][1]) ||
			                  checkAround(ships, moves[i][0] ,moves[i][1] + 1) ||
			                  checkAround(ships, moves[i][0] ,moves[i][1] - 1)) {
			        	  result[i] = "Hit";
			          } else {
			        	  result[i] = "Dead";
			          }
		        }
		     }
	    }
		
	    return result;
	}
		  
	public static boolean checkAround(char[][] ships, int i, int j) {
		    if (i < 0 || i >= ships.length || j < 0 || j >= ships[0].length) {
		      return false;
		    }
		    if (ships[i][j] == '#') return true;    //��Χ�д���û������
		    if (ships[i][j] == '0') {     //��Χ�д��ұ�����
		      return false;
		    }
		    return false;                //��Χû��
		  }
	}


