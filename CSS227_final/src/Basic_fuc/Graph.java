package Basic_fuc;



public class Graph<T> {
	AdjList<T> firstList;
	int vertexCount;
	int edgeCount;
	AdjList<T> lastList;

	private class AdjList<T> {
		AdjList<T> nextList;
		T data;
		int outdegree;
		Member<T> firstMember;

		AdjList() {}

		AdjList(T newVertex) {
			data = newVertex;
		}
	}

	private class Member<T> {
		T adjVertex;
		int weight;
		Member<T> nextMember;

		Member() {}

		Member(T toV, int weight) {
			adjVertex = toV;
			this.weight = weight;
		}
	}

	// Exercise 1
	void insertVertex(T newVertex) {
		AdjList<T> temp = new AdjList<T>(newVertex);

		if (vertexCount == 0) { // add your code here
			firstList =  lastList = temp;
			
			
		} else {
			// add your code here
			lastList.nextList = temp;
			lastList = lastList.nextList;

		}
		vertexCount++;
	
	}

	// Exercise 2
	AdjList<T> searchVertex(T data) {
		AdjList<T> current = firstList;
		while (current != null) {
			//insert your code here
			if(current.data == data)
				return current;
			current = current.nextList;
		}
		return null;
	}

	// Exercise 3 //Assume that fromData and toData exist in the graph
	void insertEdge(T fromData, T toData, int weight) {
		AdjList<T> fromAdjList = searchVertex(fromData);
		Member<T> newMember = new Member<T>(toData, weight);
		
		//insert your code here
		newMember.nextMember = fromAdjList.firstMember;
		fromAdjList.firstMember = newMember;
		fromAdjList.outdegree++;
		edgeCount++;
	}

	// Exercise 4
	void deleteEdge(T fromData, T toData) { // Locate the fromVertex using searchAdjList
		AdjList<T> fromAdjList = searchVertex(fromData);

		if (fromAdjList == null)
			return;

		if (fromAdjList.firstMember != null && toData.equals(fromAdjList.firstMember.adjVertex)) {
			//insert your code here
			fromAdjList.firstMember = fromAdjList.firstMember.nextMember;
			fromAdjList.outdegree--;
			edgeCount--;
		} 
		else if (fromAdjList.firstMember != null && !toData.equals(fromAdjList.firstMember.adjVertex)) {
			Member<T> temp = fromAdjList.firstMember;
			while (temp != null && temp.nextMember != null) {
				//insert your code here
				if(toData.equals(temp.nextMember.adjVertex)) {
					temp.nextMember = temp.nextMember.nextMember;
					fromAdjList.outdegree--;
					edgeCount--;
					return;
				}
				temp = temp.nextMember;
			}
		}

	}

	// Exercise 5
	void deleteVertex(T vertex)
	{
		AdjList<T> currentAdjList = firstList;
		AdjList<T> prevAdjList = firstList;

		while (currentAdjList != null) {
			if (!currentAdjList.data.equals(vertex)) {
				//insert your code here
				deleteEdge(currentAdjList.data, vertex);	
			} else {
				if (currentAdjList == firstList) {
					firstList = currentAdjList.nextList;
				} 
				else if (currentAdjList == lastList) {
					//insert your code here
					prevAdjList.nextList = null;
					lastList = prevAdjList;
				} 
				else {
					//insert your code here
					prevAdjList.nextList = currentAdjList.nextList;
				}
				edgeCount -= currentAdjList.outdegree;
				vertexCount--;
			}
			
			prevAdjList = currentAdjList;
			currentAdjList = currentAdjList.nextList;
		}
	}

	void print() {
		AdjList<T> currentList = firstList;
		while (currentList != null) {
			System.out.print(currentList.data);
			Member<T> cMem = currentList.firstMember;
			while (cMem != null) {
				System.out.print("-->" + cMem.adjVertex);
				System.out.print("," + cMem.weight);
				cMem = cMem.nextMember;
			}
			System.out.println("");
			currentList = currentList.nextList;

		}
		System.out.println("The graph consists of " + vertexCount + " vertices " + "and " + edgeCount + " edges.");
	}
}