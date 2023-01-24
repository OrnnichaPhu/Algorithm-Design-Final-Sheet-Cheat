package Basic_fuc;


public class Con_Knap {
	
	int Capacity = 500;
	int v[] = {5,5,4};
	int w[] = {120,150,250};

	//Array Vi = new Array(100);
	//Array Wi = new Array(100);
	//Array Solution = new Array(100);
	
	
	//do not change the properties below!!!
	float[] solution = new float[w.length];
	float Sum;
	float[] ratio;
	
	
	
	public Con_Knap() {
		Greedy_Algo();
	}
	
	/*
	 * public void addVi() { for(int i=0;i<v.length;i++) { Vi.addLast(v[i]); } }
	 * 
	 * public void addWi() { for(int i=0;i<w.length;i++) { Wi.addLast(w[i]); } }
	 */
	
	float findratio(int i) {
		float a = v[i];
		//System.out.println(a);
		float b = w[i];
		//System.out.println(b);
		float vw = (a/b);
		//System.out.printf("%.2f",vw);
		//System.out.println();
		vw= (float) (Math.round(vw*1000.0)/1000.0);
		return vw;
	}
	
	void addratio() {
		ratio = new float[w.length];
		for(int i=0;i<ratio.length;i++) {
			ratio[i] = findratio(i);
		}
	}
	
	/*
	 * public static void mergef(float[] list1, float[] list2, float[] temp) { int
	 * current1 = 0; int current2 = 0; int current3 = 0; while (current1 <
	 * list1.length && current2 < list2.length) { if (list1[current1] <
	 * list2[current2]) { temp[current3++] = list1[current1++]; } else {
	 * temp[current3++] = list2[current2++]; } } while (current1 < list1.length) {
	 * temp[current3++] = list1[current1++]; } while (current2 < list2.length) {
	 * temp[current3++] = list2[current2++]; } }
	 * 
	 * public static void sortf(float[] list) { if(list.length >1) { float[]
	 * firsthalf = new float[list.length/2]; int secondhalfLenght = list.length -
	 * list.length/2; float[] secondhalf = new float[secondhalfLenght];
	 * System.arraycopy(list, 0, firsthalf, 0, list.length/2);
	 * System.arraycopy(list, list.length/2, secondhalf, 0, secondhalfLenght);
	 * sortf(firsthalf); sortf(secondhalf); mergef(firsthalf, secondhalf, list); } }
	 * 
	 * void swapf(float [] A, int ind1, int ind2) { float temp = A[ind1]; A[ind1] =
	 * A[ind2]; A[ind2] = temp; }
	 * 
	 * void swap(int [] A, int ind1, int ind2) { int temp = A[ind1]; A[ind1] =
	 * A[ind2]; A[ind2] = temp; }
	 */
	
	int findMax(float[] list) {
		int index = 0;
		float temp = list[index];
		for(int i = 1;i<list.length;i++) {
			if(temp < list[i]) {
				temp = list[i];
				index = i;
			}
		}
		list[index] = 0;
		return index;
	}
	
	
	void Greedy_Algo() {
		addratio();
		
		System.out.print("Vi/Wi = ");
		printArrayf(ratio);
		
		int n = Capacity;
		float[] temp = ratio;
		
		for(int i =0;i<w.length;i++) {
			
			int index = findMax(temp);
			
			if(w[index] < n) {
				solution[index] = 1;
				n -= w[index];
			}
			else{
				if(n==0) {
					solution[index] = 0;
				}
				else {
					float a = n;
					float b = w[index];
					float  s = (float) (Math.round((a/b)*100.0)/100.0);
					solution[index] = s;	
					n = 0;
					}	
				}
		}
	
		System.out.print("Solution set = ");
		printArrayf(solution);
		SumValue();
		System.out.printf("Most valuable subset of item is %.1f\n",Sum);
	}
	
	void SumValue() {
		for(int j =0;j<solution.length;j++) {
			Sum += (solution[j]*v[j]);
		}
	}
	
	void printArrayf(float[] A ){  
		for (int i=0; i< A.length; i++ ){  
			System.out.print(A[i]+" ");
       }
		printBounder();
    }
	
	void printBounder() {
		System.out.println("\n------------------------------");
	}
	
	public static void main(String[] args) {
		Con_Knap ame = new Con_Knap();
	}
}
