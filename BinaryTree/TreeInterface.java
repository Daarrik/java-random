package TreePackage;

public interface TreeInterface<T> {

	public T getRootData();
	public T getLeftmostData();
	public T getRightmostData();
	public int getHeight();
	public int getNumberOfNodes();
	public boolean isEmpty();
	public void clear();

}