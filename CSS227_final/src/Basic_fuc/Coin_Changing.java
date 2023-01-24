package Basic_fuc;

public class Coin_Changing{
	
	int N = 96;
	
	int c[] = {40,25,20,10,5,1};
	
	
	//do not change the properties below!!!
	int Sum;
	int Select;
	int n = 1;
	Array C = new Array(10); //If number of elements in c more than 10 then use 100 instead of 10
	Array Solution = new Array(10); //If number of elements in c more than 10 then use 100 instead of 10
	
	
	
	public Coin_Changing() {
		// TODO Auto-generated constructor stub
		System.out.printf("We need to change for N = %d\n",N);
		printBounder();
		addCoins();
		greedy_Algo();
		printBounder();
		System.out.print("S = ");
		Solution.printArray();
		SumCoin();
		System.out.printf("We use %d coins\n",Sum);
	}
	
	public void addCoins() {
		for(int i=0;i<c.length;i++) {
			C.addLast(c[i]);
		}
	}
	
	void printBounder() {
		System.out.println("------------------------------");
	}
	
	public void greedy_Algo() {
		int initial = N;
		while (C.load != 0) {
			Select = C.getElementAtIndex(0);
			C.removeFirst();
			if(Select <= initial) {
				printBounder();
				System.out.printf("select = %d\n",Select);
				while (n*Select <= initial) {
	                n += 1;
	            }
	            n -= 1;
	            initial -= (n*Select);
	            Solution.addLast(n);
	            System.out.printf("S = {%d*%d}\n",Select,n);
	            System.out.printf("N = %d\n",initial);
	            
	            n = 1;
			}
			else {
				printBounder();
				System.out.printf("%d is not feasible\n",Select);
				Solution.addLast(0);
			}
		}
	}
	
	void SumCoin() {
		for(int i=0;i < Solution.load;i++) {
			Sum += Solution.getElementAtIndex(i);
		}
	}
	
	public static void main(String[] args) {
		Coin_Changing Coin = new Coin_Changing();
	}
}
