import java.io.*;
import java.util.Scanner;

public class HeapProgram {

	public static void main(String[] args) throws FileNotFoundException {
		File data = new File("data.txt");
		Scanner reader = new Scanner(data);

		File heapData = new File("heapdata.txt");
		PrintWriter writer = new PrintWriter(heapData);

		Integer[] integers = new Integer[100];

		MaxHeap<Integer> sequentialHeap = new MaxHeap(100);

		/* This while adds the values in data.txt to sequentialHeap and adds
		the values in data.txt to an array that the optimalHeap will use. */
		int index = 0;
		while (reader.hasNext()) {
			int next = reader.nextInt();
			sequentialHeap.add(next);
			integers[index] = next;
			index++;
		}

		MaxHeap<Integer> optimalHeap = new MaxHeap(integers);

		Comparable[] sequentialHeapArray = sequentialHeap.getHeap();
		Comparable[] optimalHeapArray = optimalHeap.getHeap();

		writer.print("=====================================================================\n");
		writer.print("Heap built using sequential insertions: ");
		for (int i = 1; i < 11; i++) 
			writer.print(sequentialHeapArray[i] + ",");
		writer.print("...\n");

		writer.print("Number of swaps in the heap creation: " + sequentialHeap.getSwaps() + "\n");

		for (int i = 0; i < 10; i++)
			sequentialHeap.removeMax();
		writer.print("Heap after 10 removals: ");
		for (int i = 1; i < 11; i++)
			writer.print(sequentialHeapArray[i] + ",");
		writer.print("...\n\n");

		writer.print("Heap built using optimal method: ");
		for (int i = 1; i < 11; i++)
			writer.print(optimalHeapArray[i] + ",");
		writer.print("...\n");

		writer.print("Number of swaps in the heap creation: " + optimalHeap.getSwaps() + "\n");

		for (int i =0; i < 10; i++)
			optimalHeap.removeMax();
		writer.print("Heap after 10 removals: ");
		for (int i = 1; i < 11; i++)
			writer.print(optimalHeapArray[i] + ",");
		writer.print("...\n");
		writer.print("=====================================================================");

		writer.close();
	}
}