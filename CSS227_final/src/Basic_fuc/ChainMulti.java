package Basic_fuc;

public class ChainMulti {
	//ex. A1.A2.A3 in L16 pg.9
	int[] P = {40,10,5,3};

	int n = P.length-1;

	int[][] m = new int[100][100];
	int[][] s = new int[100][100];
	int mi = 1;// Ci = i and Cj = j for finding C[i,j]
	int mj = 3;// Ci = i and Cj = j for finding C[i,j]


	static char name;

	public ChainMulti() {
		Max_Chain(P,n);
		printArray(m);
		// If the Optimal Parenthesization is not working correctly pls check it in printArray
	}

	void Max_Chain(int[] p, int n) {
		int i,j,k,l,q;
		for(i=1;i<=n;i++) {
			m[i][i] = 0;
		}
		for(l=1; l < n ;l++){

			for (i = 0; i < n-l; i++) {

				j = i+l;

				m[i][j] = 9999;


				for(k = i;k<j;k++) {
					q = m[i][k] + m[k+1][j] + (p[i]*p[k+1]*p[j+1]);
					if(q < m[i][j]) {
						m[i][j]= q;
						s[i][j]= k;
					}


				}
			}
		}
	}

	void printBounder() {
		System.out.println("\n---------------------------------------------------");
	}

	void printArray(int[][] A ){  
		for (int i=0; i< n; i++ ){ 
			System.out.println();
			System.out.printf("\n i%d =",i+1);
			for (int j=0; j<n; j++ ){ 
				System.out.print("\t");
				System.out.print(A[i][j]+" ");
			}
		}
		printBounder();
		System.out.printf("m[%d,%d] = %d",mi,mj,m[mi-1][mj-1]);
		printBounder();
		System.out.printf("Optimal solution is %d\n",m[0][n-1]);
		name = 'A';
		System.out.printf("Optimal Parenthesization is ");
		prin(0, n-1);
	/* Uncomment --------> printParenthesis(0, n - 1, n, s); <-------- and comment call for method prin above of function prin not work */
		//printParenthesis(0, n - 1, n, s);
		


	}


	void prin(int i,int j)
	{
		if(i==j)
		{
			System.out.printf("A%d",i+1);
		}
		else
		{
			System.out.printf("(");
			prin(i,s[i][j]);
			prin((s[i][j]+1),j);
			System.out.printf(")");

		}
	}

	
	//Use this if prin is not working
	// I am not the one who wrote this 'printParenthesis' so be careful when use it!!!!!!
	static void printParenthesis(int i, int j,int n, int[][] bracket){

		// If only one matrix left in current segment
		if (i == j)
		{
			System.out.print(name++);
			return;
		}
		System.out.print("(");

		// Recursively put brackets around subexpression
		// from i to bracket[i][j].
		// Note that "*((bracket+i*n)+j)" is similar to
		// bracket[i][j]
		printParenthesis(i, bracket[i][j], n, bracket);

		// Recursively put brackets around subexpression
		// from bracket[i][j] + 1 to j.
		printParenthesis(bracket[i][j] + 1, j, n, bracket);
		System.out.print(")");
	}
	// Matrix Ai has dimension p[i-1] x p[i] for i = 1..n
	// Please refer below article for details of this
	// function
	// https://goo.gl/k6EYKj
	

	public static void main(String[] args) {
		ChainMulti Cain_Mul = new ChainMulti();
	}

}
