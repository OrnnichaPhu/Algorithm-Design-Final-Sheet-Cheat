package Basic_fuc;


public class Array {
	final int size;  //The maximum capacity of A
    int [] A ;
    int load=0;  //number of elements in A
    
    Array(int n)
    { size = n;
      A = new int[size];  
    }
    
 


	//Ex3 a    
    void addFirst(int e)
    { 
    	for(int i = load;i>0;i--) {
    		A[i] = A[i-1];
    	}
    	A[0]= e;
    	load++;


    }
     //Ex3 b 
    void addLast(int e)
    {  
    	A[load] = e;
    	load++;
 
    }

    //Ex3 c
    void addAtIndex(int e, int index)
    {  
    	for(int i = load;i>index;i--) {
    		A[i] = A[i-1];
    	}
    	A[index] = e;
    	load++;


    }
    
    //Ex4 a
    int removeFirst()
    {   
    	for(int i = 0; i<load;i++) {
    		A[i] = A[i+1];
    	}
    	A[load-1] = 0;
    	load--;
    	return A[0];


    }

    //Ex4 b
     int removeLast()
    {  
    	 A[load-1] = 0;
    	 load--;
    	 return A[load-1];



    }

     //Ex4 c
     int removeAtIndex(int index)
    {  
    	 for(int i = index; i <load; i++) {
    		 A[i] = A[i+1];
    	 }
    	 load--;
    	 return A[index];

    }
    
     //Ex5 a
     public int  getElementAtIndex(int index)
     {  
    	return A[index];

     }
     
    //Ex5 b
     public void  setElementAtIndex(int val, int index)
     {   
    	 A[index] = val;


     }
     
     
    void printArray( )
    {  for (int i=0; i< load; i++ )
       {  System.out.print(A[i]+" ");
       }
      System.out.println("\nArray load is " +load);
    }
    
}