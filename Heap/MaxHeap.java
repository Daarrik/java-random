import java.util.Arrays;

public class MaxHeap<T extends Comparable<? super T>> implements MaxHeapInterface<T> {

	private T[] heap;
	private int lastIndex;
	private int swaps = 0;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;

	public MaxHeap() {
		this(DEFAULT_CAPACITY);
	}

	//Sequential
	public MaxHeap(int initialCapacity) {
		if (initialCapacity < DEFAULT_CAPACITY || initialCapacity > MAX_CAPACITY)
			initialCapacity = DEFAULT_CAPACITY;
		@SuppressWarnings("unchecked")
		T[] tempHeap = (T[])new Comparable[initialCapacity + 1];
		heap = tempHeap;
		lastIndex = 0;
	}

	//Optimal
	public MaxHeap(T[] entries) {
		this(entries.length);
		lastIndex = entries.length;
		for (int index = 0; index < entries.length; index++)
			heap[index + 1] = entries[index];

		for (int rootIndex = lastIndex / 2; rootIndex > 0; rootIndex--)
			reheap(rootIndex);
	}

	public int getSwaps() {
		return swaps;
	}

	public int getLastIndex() {
		return lastIndex;
	}

	public T[] getHeap() {
		return heap;
	}

	public void add(T newEntry) {
		int newIndex = lastIndex + 1;
		int parentIndex = newIndex/2;
		while ((parentIndex > 0) && newEntry.compareTo(heap[parentIndex]) > 0) {
			heap[newIndex] = heap[parentIndex];
			newIndex = parentIndex;
			parentIndex = newIndex / 2;
			swaps++;
		}
		heap[newIndex] = newEntry;
		lastIndex++;
	}

	public T removeMax() {
		T root = null;

		if (!isEmpty()) {
			root = heap[1];
			heap[1] = heap[lastIndex];
			lastIndex--;
			reheap(1);
		}
		return root;
	}

	public T getMax() {
		T root = null;

		if (!isEmpty())
			root = heap[1];

		return root;
	}

	public boolean isEmpty() {
		return lastIndex < 1;
	}

	public int getSize() {
		return lastIndex;
	}

	public void clear() {
		while (lastIndex > -1) {
			heap[lastIndex] = null;
			lastIndex--;
		}
		lastIndex = 0;
	}

	private void reheap(int rootIndex) {
		boolean done = false;
		T orphan = heap[rootIndex];
		int leftChildIndex = 2 * rootIndex;

		while (!done && (leftChildIndex <= lastIndex)) {
			int largerChildIndex = leftChildIndex;
			int rightChildIndex = leftChildIndex + 1;

			if ((rightChildIndex <= lastIndex) && heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0) {
				largerChildIndex = rightChildIndex;
			}

			if (orphan.compareTo(heap[largerChildIndex]) < 0) {
				heap[rootIndex] = heap[largerChildIndex];
				rootIndex = largerChildIndex;
				leftChildIndex = 2 * rootIndex;
			} 
			else
				done = true;
			swaps++;
		}
		heap[rootIndex] = orphan;
	}

}