package com.sd.dynamic.programming;

public class Knapsack {

	// A utility function that returns maximum of two integers
	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	static int knapsackMaximizeProfit(int wt[],int val[],int W,int n){
		
		
		int t[][] = new int[n+1][W+1];
		
		for(int i=0;i<=n;i++){
			for(int j=0;j<=W;j++){
				if(i==0 || j==0)
					t[i][j] =0;
				
				else if(wt[i-1]<=j)
					t[i][j] = max(val[i-1]+t[i-1][j-wt[i-1]],t[i-1][j]);
				else if(wt[i-1]>j)
					t[i][j] = t[i-1][j];
				
			}
		}
		return t[n][W];
	}

	public static void main(String[] args) {
		int val[] = new int[] { 60, 100, 120 };
		int wt[] = new int[] { 10, 20, 30 };
		int W = 50;
		int n = val.length;
		System.out.println(knapsackMaximizeProfit(wt, val, W, n));
	}
}
