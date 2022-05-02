public interface MaxHeapInterface<T extends Comparable<? super T>> {

	public void add(T newEntry);
	public T removeMax();
	public boolean isEmpty();
	public int getSize();
	public void clear();

}
	