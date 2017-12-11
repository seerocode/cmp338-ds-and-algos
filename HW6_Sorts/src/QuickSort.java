import java.util.Arrays;
import java.util.Random;

public class QuickSort<T extends Comparable<? super T>> extends RunTime implements SortInterface<T> {

	private long startTime;
	private long endTime;
	protected long runTime;

	PivotType pivotType = PivotType.FirstElement;
	
	RunTime qsRun = new RunTime() {
		{
			setTimeUnits(TimeUnits.MicroSeconds);
			setMemoryUnits(MemoryUnits.KiloBytes);
		}
	};
	
	public static void main(String[] args) {
	
		QuickSort qs = new QuickSort();
		
		Integer[] array = { 5, 10, 6, 9, 3, 1 };
		System.out.println(Arrays.toString(array));
		
		for (int i = 0; i < 10; i++) {
		qs.setPivotType(PivotType.MidOfFirstMidLastElement);
		qs.sort(array);
		}
		
		System.out.println(Arrays.toString(array));

	}

	
	public static enum PivotType {
		FirstElement, MidOfFirstMidLastElement, RandomElement
	}

	@Override
	public void sort(T[] arrayToSort) {

		this.startTime = System.nanoTime();

		quickSort(arrayToSort, 0, arrayToSort.length - 1);

		this.endTime = System.nanoTime();
		this.runTime = endTime - startTime;
		qsRun.addRuntime(runTime);
//		System.out.println(runTime);
//		System.out.println(Arrays.toString(qsRun.getRunTimes()));

	}
	
	public void setPivotType(QuickSort.PivotType pivotType) {
		this.pivotType = pivotType;
	}
	
	public PivotType getPivotType() {
		return this.pivotType;
	}


	/////////////////////////////////////////////////////////////////////

	private void quickSort(T[] array, int firstIndex, int lastIndex) {
		
		int pivotIndex;
		if (firstIndex < lastIndex) {
			pivotIndex = partition(array, firstIndex, lastIndex);
			quickSort(array, firstIndex, pivotIndex - 1);
			quickSort(array, pivotIndex + 1, lastIndex);
		}
	}

	public void choosePivot(T[] array, int first, int last) {
		// after this method returns, the chosen pivot is
		// always in the first location in the segment of the
		// array being worked on.


		int firstElement = first;
		int pivotIndex = first;
		int mid = (first + last) / 2;

		T tempFirst = array[first];
		T tempMid = array[mid];
		T tempLast = array[last];

		T temp = array[first];
		T pivot = array[first];

		switch (pivotType) {
		case FirstElement:
			break;
		case MidOfFirstMidLastElement:
			if (tempFirst.compareTo(tempMid) == -1 && tempMid.compareTo(tempLast) == -1
					|| tempLast.compareTo(tempMid) == -1 && tempMid.compareTo(tempFirst) == -1) {
				pivot = tempMid;
				pivotIndex = mid;
			} else if (tempFirst.compareTo(tempLast) == -1 && tempLast.compareTo(tempMid) == -1
					|| tempMid.compareTo(tempLast) == -1 && tempLast.compareTo(tempFirst) == -1) {
				pivot = tempLast;
				pivotIndex = last;
			} else {
				pivot = tempFirst;
				pivotIndex = first;
			}
			break;
		case RandomElement:
			Random rand = new Random();
			int randElement = (rand.nextInt(last - first)) + first;
			pivot = array[randElement];
			pivotIndex = randElement;
			break;
		}

		array[firstElement] = pivot;
		array[pivotIndex] = temp;

	}

	private int partition(T[] array, int first, int last) {

		T tempItem;
		int firstUnknown;

		choosePivot(array, first, last);
		T pivot = array[first];

		int lastS1 = first;

		for (firstUnknown = first + 1; firstUnknown <= last; firstUnknown++) {
			if (array[firstUnknown].compareTo(pivot) < 0) {
				lastS1++;
				tempItem = array[firstUnknown];
				array[firstUnknown] = array[lastS1];
				array[lastS1] = tempItem;
			}
		}

		// swap pivot with element at lastS1
		tempItem = array[first];
		array[first] = array[lastS1];
		array[lastS1] = tempItem;

		return lastS1;
	}

}
