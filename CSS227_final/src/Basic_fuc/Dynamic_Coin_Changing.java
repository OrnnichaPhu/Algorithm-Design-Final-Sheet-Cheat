package Basic_fuc;

public class Dynamic_Coin_Changing {
	int N = 11;
	int n = 3;
	int[] d = {1, 5, 10};
	
	int Ci = 3;// Ci = i and Cj = j for finding C[i,j]
	int Cj = 11;// Ci = i and Cj = j for finding C[i,j]
	
	
	//do not change the properties below!!!
	int [][] Solution = new int[n][N+1];
	
	Array Coin = new Array(N+1);
	Array Di = new Array(n);
	int ni =0;
	int C;
	int Select;
	
	
	public Dynamic_Coin_Changing() {
		System.out.print("\tCoin Changing Problem");
		addDi();
		CreateArrayC(N);
		coinChaning();
		printArray(Solution);	
	}
	
	void coinChaning() {
		int c1;
		int c2;
		
		for(int k=0;k<n;k++) {
			Solution[k][0] = 0;
		}
		
		for(int l=0;l<N+1;l++) {
			if(d[0] == 1)
				Solution[0][l] = l;
			else {
				Select = d[0];
				if(Select <= l) {
					while (ni*Select <= l) {
						ni += 1;
					}
					ni -= 1;
					Solution[0][l] = ni;
					ni = 0;
				}
			}
			
		}
		
		for(int i =1;i<n;i++) {
			for(int j=1;j<=N;j++) {
				
					c1 = Solution[i-1][j];
				
				
				if(j-d[i] >= 0) {
					c2 = 1+Solution[i][j-d[i]];
				}
				else {
					c2 = 10000;// infinity
				}
				if(c1 > c2)
					Solution[i][j] = c2;
				else
					Solution[i][j] = c1;
			}
		}
	}
	
	
	
	
	void CreateArrayC(int N) {
		for(int i =0;i<=N;i++) {
			Coin.addLast(i);
		}
	}
	
	public void addDi() {
		for(int i=0;i<d.length;i++) {
			Di.addLast(d[i]);
		}
	}
	
	void printBounder() {
		System.out.println("\n---------------------------------------------------");
	}
	
	void printArray(int[][] A ){  
		for (int i=0; i< n; i++ ){ 
			System.out.println();
			System.out.printf("\n D%d =\t",i+1);
			for (int j=0; j<= N; j++ ){ 
				System.out.print("\t");
				System.out.print(A[i][j]+" ");
			}	
       }
		printBounder();
		System.out.printf("C[%d,%d] = %d",Ci,Cj,Solution[Ci-1][Cj]);
		printBounder();
		System.out.printf("The minimum number of coins to make change is %d\n",Solution[n-1][N]);
		
    }
	
	public static void main(String[] args) {
		Dynamic_Coin_Changing D_Coin = new Dynamic_Coin_Changing();
		
	}

}
