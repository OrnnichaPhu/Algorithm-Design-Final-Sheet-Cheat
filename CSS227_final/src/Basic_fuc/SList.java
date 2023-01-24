package Basic_fuc;

public class SList<T> {
	// Class properties
	int size;
	Node<T> first;
	Node<T> last;

	// Class constructor
	SList() {
		size = 0;
		first = null;
		last = null;
	}

	/*----------------------------------------------------*/

	// Class methods

	void addFirst(T element) {
		Node<T> newNode = new Node<T>(element);
		newNode.next = first;
		first = newNode;
		size++;
		if (last == null)
			last = first;
	}

	void addLast(T element) {
		// Ex.1 complete the program
		Node<T> newNode = new Node<T>(element);
		last.next = newNode;
		last = newNode;
		size++;
		if(last == null) 
			last = first = newNode;		
		
	}

	void addAtIndex(int index, T element) {
		// Ex.2 complete the program
		Node<T> newNode = new Node<T>(element);
		
		Node<T> walker = first;
		for (int i = 1; i < index; i++) {
			walker = walker.next;
		}

		if(walker == first) 
			addFirst(element);
		else if (index == size)
			addLast(element);
		else {
			newNode.next = walker.next;
			walker.next = newNode;
			size++;	
		}		
	}
			
			
	
	


	T removeFirst() {
		if (size == 0)
			return null;
		else {
			Node<T> tmp = first;
			first = first.next;
			size--;
			if (first == null)
				last = null;
			return tmp.element;
		}

	}

	T removeLast() {
		// Ex.3 replace this line with your code
		if(size == 0)
			return null;
		else if (size == 1) {
			Node<T> temp = first;
			first = last = null;
			size = 0;
			return temp.element;
		} else {
			Node<T> tmp = last;
			Node<T> walker = first;
			for (int i = 1; i < size; i++) {
				walker = walker.next;
			}
			last = walker;
			size--;
			last.next = null;
			return tmp.element;
		}
	}

	T removeAtIndex(int index) {
		// Ex.4 replace this line with your code
		if (index < 0 || index >= size)
			return null;
		else if (index == 0)
			return removeFirst();
		else if (index == size - 1)
			return removeLast();
		else {
			Node<T> walker = first;
			for (int i = 1; i < index; i++) {
				walker = walker.next;
			}
			Node<T> tmp = walker.next;
			walker.next = tmp.next;
			size--;
			return tmp.element;
		}
		
	}

	int search(T item) {
		// Ex.5 replace this line with your code
		if(size == 0)
			return 0;
		else {
			Node<T> walker = first;
			for (int i = 0; i < size; i++) {
				if(walker.element == item)
					return i;
				walker = walker.next;
			}
			return -1;
		}
		
	}

	
	boolean isEmpty() {
		if (size == 0)
			return true;
		else
			return false;
	}

	int getSize() {
		return size;
	}

	void printHorizontal() {
		Node<T> walker = first;
		for (int i = 0; i < size; i++) {
			System.out.print(walker.element);
			System.out.print(" ");
			walker = walker.next;
		}
		System.out.println("\n-----");
	}
}