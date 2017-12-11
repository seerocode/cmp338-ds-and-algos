
public class MergeSort<T extends Comparable<? super T>> extends RunTime implements SortInterface<T> {

	private long startTime;
	private long endTime;
	protected long runTime;
	
	RunTime mergeRun = new RunTime(){{
		setTimeUnits(TimeUnits.MicroSeconds);
		setMemoryUnits(MemoryUnits.KiloBytes);
	}};

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sort(T[] arrayToSort) {

		// start time for loop execution
		this.startTime = System.nanoTime();

		Object[] tempArray = new Object[arrayToSort.length];
		mergeSort(arrayToSort, tempArray, 0, arrayToSort.length - 1);

		// endtime for loop execution
		this.endTime = System.nanoTime();
		// grab end run time for loop execution
		this.runTime = endTime - startTime;
		// add runtime to runtime method in RunTime class
		mergeRun.addRuntime(runTime);

	}

	/////////////////////////

	private void mergeSort(T[] array, Object[] tempArray, int firstIndex, int lastIndex) {

		if (firstIndex < lastIndex) {
			int midIndex = (firstIndex + lastIndex) / 2;
			mergeSort(array, tempArray, firstIndex, midIndex);
			mergeSort(array, tempArray, midIndex + 1, lastIndex);
			merge(array, tempArray, firstIndex, midIndex, lastIndex);
//			showArray(array, firstIndex, lastIndex);
		}
	}

	@SuppressWarnings("unchecked")
	private void merge(T[] array, Object[] tempArray, int firstIndex, int midIndex, int lastIndex) {

		int first1 = firstIndex;
		int last1 = midIndex;
		int first2 = midIndex + 1;
		int last2 = lastIndex;
		int index = first1;

		while ((first1 <= last1) && (first2 <= last2)) {
			if (array[first1].compareTo(array[first2]) < 0) {
				tempArray[index++] = array[first1++];
			} else {
				tempArray[index++] = array[first2++];
			}
		}

		while (first1 <= last1) {
			tempArray[index++] = array[first1++];
		}

		while (first2 <= last2) {
			tempArray[index++] = array[first2++];
		}

		for (index = firstIndex; index <= lastIndex; index++) {
			array[index] = (T) tempArray[index];
		}
	}

	private void showArray(T[] array, int first, int last) {
		System.out.print("Array = {");
		for (int i = first; i <= last; i++) {
			if (i != last) {
				System.out.print(array[i] + ", ");
			} else {
				System.out.print(array[i]);
			}
		}
		System.out.println("}");
	}

}
