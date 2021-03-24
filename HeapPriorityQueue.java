/*
* HeapPriorityQueue.java
*
* An implementation of a minimum PriorityQueue using a heap.
* based on the implementation in "Data Structures and Algorithms
* in Java", by Goodrich and Tamassia
*
* This implementation will throw a Runtime, HeapEmptyException
*	if the heap is empty and removeLow is called.
*
* This implementation will throw a Runtime, HeapFullException
*	if the heap is full and insert is called.
*
*/

public class HeapPriorityQueue implements PriorityQueue {

	protected final static int DEFAULT_SIZE = 10000;

	protected Comparable[] storage;
	protected int currentSize;

	/*
	 * Constructor that initializes the array to hold DEFAULT_SIZE elements
	 */
	public HeapPriorityQueue() {
		storage = new Comparable[DEFAULT_SIZE+1];
		currentSize = 0;
	}

	/*
	 * Constructor that initializes the array to hold size elements
	 * Precondition: size > 0
	 */
	public HeapPriorityQueue(int size) {
		//TODO: Implement this
		storage = new Comparable[size+1];
		currentSize = 0;
	}

	public int size(){
		return currentSize;
	}

	/*
	 * The array implementation of insert MUST throw
	 * a HeapFullException if the array is full
	 */
	public void insert ( Comparable element ) throws HeapFullException {
		//TODO: Implement this
		try{
			storage[++currentSize]= element;
			BubbleUp(currentSize);
		}catch(ArrayIndexOutOfBoundsException e){
			throw new HeapFullException();
		}
	}

	private void BubbleUp(int i){
		if(i>1){
			if(storage[i].compareTo(storage[i/2])<0){
				swap(storage, i, i/2);
				BubbleUp(i/2);
			}
		}
	}

	public Comparable removeMin() throws HeapEmptyException{
		if(isEmpty()){
			throw new HeapEmptyException();
		}
		Comparable minValue = storage[1];
		storage[1]= storage[currentSize];
		storage[currentSize]= minValue;
		currentSize--;
		BubbleDown(1);
		return minValue;
	}

	private void BubbleDown(int index){
		if(!isLeaf(index)){
			int minChildIndex = minChild(index);
			if(storage[index].compareTo(storage[minChildIndex])>0){
				swap(storage, index, minChildIndex);
				BubbleDown(minChildIndex);
			}
		}
	}

	private boolean isLeaf(int i){
		boolean result = true;
		if(isEmpty()){
			result =  false;
		}
		if((currentSize<2*i)&&(currentSize<2*i+1)){
			return true;
		}else{
			return false;
		}
	}

	private int minChild(int i){
		Comparable a = storage[i*2];
		Comparable b = storage[i*2+1];
		int result = 0;
		if(currentSize<2*i+1&&currentSize>=2*i){
			return i*2;
		}
		if(a.compareTo(b)<=0){
			result = i*2;
		}else{
			result = i*2+1;
		}
		return result;
	}

	private void swap(Comparable[] s, int i, int minChild){
		Comparable a = s[i];
		s[i] = s[minChild];
		s[minChild]= a;
	}

	// TODO: Add other methods here
	public boolean isEmpty(){
		return currentSize==0;
	}

	public String toString() {
		String s = "";
		String sep = "";
		for(int i=1;i<currentSize+1;i++) {
			s += sep + storage[i];
			sep = " ";
		}
		return s;
	}

}
