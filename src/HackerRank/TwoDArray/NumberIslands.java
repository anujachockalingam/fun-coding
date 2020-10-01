package HackerRank.TwoDArray;

/**
 * @author c59785a
 * Created on 2020-09-24 15:34
 *
 * Input : mat[][] = {{1, 1, 0, 0, 0},
 *                    {0, 1, 0, 0, 1},
 *                    {1, 0, 0, 1, 1},
 *                    {0, 0, 0, 0, 0},
 *                    {1, 0, 1, 0, 1}
 * Output : 5
 *
 **/
public class NumberIslands {

    int countIslands(int M[][]){

        int ROW = M.length;
        int COL = M[0].length;

        boolean visited[][] = new boolean[ROW][COL];

        int numIslands = 0;

        for(int i =0; i< ROW; i++){
            for(int j =0; i< COL; j++){
                if(M[i][j] == '1' && !visited[i][j]){
                    //do soemthing
                    DFS(M,i,j,visited);
                    numIslands++;

                }
            }
        }
        return numIslands;
    }

    private void DFS(int[][] m, int i, int j, boolean[][] visited) {

        int[] rowNr =  new int []{-1,0, 0, 1};
        int[] colNr =  new int []{0, -1,1,0};

        visited[i][j]= true;
            for(int k =0; k<4;k++){
                if (isSafe(m, i+rowNr[k],j+colNr[k],visited)){
                    DFS(m, i+rowNr[k],j+colNr[k],visited);
            }
        }
    }

    boolean isSafe(int M[][], int row, int col, boolean visited[][]){
        return (row >=0 && row <M.length && col >=0 && col<M[0].length && M[row][col] == '1' && !visited[row][col] );
    }
}
