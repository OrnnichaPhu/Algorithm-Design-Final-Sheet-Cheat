package Basic_fuc;

public class Dynamic_Knapsack {
	
	int W = 4;
	int v[] = {20,40,15};
	int w[] = {3,2,1};
	
	int Vi = 3;// Vi = i and Vj = j for finding V[i,j]
	int Vj = 3;// Vi = i and Vj = j for finding V[i,j]
	
	//do not change the properties below!!!
	int [][] V = new int[v.length+1][W+1];
	
	public Dynamic_Knapsack() {
		System.out.print("\t1/0 Knapsack Problem");
		D_Knapsack();
		printArray(V);
	}
	
	void D_Knapsack() {
		int v1;
		int v2;
		
		for(int i=0;i<v.length+1;i++) {
			V[i][0] = 0;
		}
		for(int j=0;j<W+1;j++) {
			V[0][j] = 0;
		}
		for(int i=1;i<v.length+1;i++) {
			for(int j=1;j<W+1;j++) {
				if(j<w[i-1]) {
					V[i][j] = V[i-1][j];
				}
				else {
					// V[i,j] = max{V[i-1][j],v[i] + V[i-1][j-w[i]]}
					v1 = V[i-1][j];
					v2 = v[i-1] + V[i-1][j-w[i-1]];
					if(v1 > v2)
						V[i][j] = v1;
					else
						V[i][j] = v2;
				}
			}
		}
	}
	
	void printBounder() {
		System.out.println("\n---------------------------------------------------");
	}
	
	void printArray(int[][] A ){  
		for (int i=0; i< v.length+1; i++ ){ 
			System.out.println();
			System.out.printf("\n i%d =",i);
			for (int j=0; j<W+1; j++ ){ 
				System.out.print("\t");
				System.out.print(A[i][j]+" ");
			}
       }
		printBounder();
		System.out.printf("V[%d,%d] = %d",Vi,Vj,V[Vi][Vj]);
		printBounder();
		System.out.printf("Most valuable subset of the first fit items is %d\n",V[v.length][W]);
		
    }
	
	public static void main(String[] args) {
		Dynamic_Knapsack D_K = new Dynamic_Knapsack();
	}

}
