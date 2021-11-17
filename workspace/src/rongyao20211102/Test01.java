package rongyao20211102;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		String[] arr = s.split("");
		int[] res = new int[arr.length];
		int index = 0;
		for(int i = 0 ; i < arr.length; i++){
			res[index++] = Integer.parseInt(arr[i]);
		}
		int N = res[0];
		int[] numOfFun = new int[N];
		int[] weight = new int[N];
		int[][] graph = new int[100][100];
		for(int i = 0; i < N; i++){
			for(int j = 0; j < numOfFun[i] + 2; j++){
				int input = in.nextInt();
				if(j > 0){
					if(j == 1){
						if(input == 0){
							System.out.println("NA");
						}
						weight[i] = input;
					}
				}else if(input == i+1){
					System.out.println("R");
				}else {
					graph[i][input -1] = weight[i];
				}
			}
		}
		System.out.println(getMaxStack(graph,weight,N));
	}
	
	public static int firstNeig(int graph[][], int v ,int N){
		for(int i = 0; i <N; i++){
			if(graph[v][i] > 0){
				return i;
			}
		}
		return -1;
	}
	
	public static int nextNeig(int graph[][], int v ,int w, int N){
		for(int i = w+1; i<N; i++){
			if(graph[v][i] > 0){
				return i;
			}
		}
		return -1;
	}
	
	public static void dfs(int graph[][], int v, int N, int weight[], int curStack, int maxStack){
		curStack += weight[v];
		int temp = curStack;
		int w = firstNeig(graph, v, N);
		while(w != -1){
			dfs(graph,w,N,weight,curStack,maxStack);
			maxStack = maxStack > curStack ? maxStack : curStack;
			curStack = temp;
			w = nextNeig(graph,v,w,N);
		}
	}
	
	public static int getMaxStack(int graph[][], int weight[], int N){
		int maxStack = 0;
		for(int i = 0; i < N; i++){
			int curStack = 0;
			dfs(graph,i,N,weight,curStack,maxStack);
		}
		return maxStack;
	}
}
