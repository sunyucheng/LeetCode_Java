package lc20220107;

public class SumofRange_2D {
	public static void main(String[] args){
		int[][] arr = new int[5][5];
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[0].length; j++){
				arr[i][j] = 1;
			}
		}
		NumMatrix num = new NumMatrix(arr);
		System.out.println(num.sumRegion(2, 3, 3, 4));
	}
}

class NumMatrix {

    //设置一个二维的前缀和数组，该数组用来计算以（0,0）为顶点的矩阵的元素之和
    public int[][] preSum;

    public NumMatrix(int[][] matrix) {
        //行
        int m = matrix.length;
        //列
        int n = matrix[0].length;
        preSum = new int[m + 1][n + 1];
        preSum[0][0] = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 1 ; j <= n; j++){
                preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] + matrix[i-1][j-1] - preSum[i-1][j-1] ;
           }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2+1][col2+1] - preSum[row2+1][col1] - preSum[row1][col2+1] + preSum[row1][col1];
    }
}
