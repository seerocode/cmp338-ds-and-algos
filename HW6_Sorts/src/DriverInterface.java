
/**
 * 
 * @author Sameh A. Fakhouri
 *
 */
public interface DriverInterface {

	/**
	 * This <code>enum</code> is used to specify the type of Array. All arrays used in this
	 * assignment will be arrays of <b>Integer</b>:
	 * 
	 * <ol>
	 * <li>Equal - The elements in the array are all equal.</li>
	 * <li>Random - The elements in the array are randomly generated.</li>
	 * <li>Increasing - The elements of the array are arranged in increasing order.</li>
	 * <li>Decreasing - The elements of the array are arranged in decreasing order.</li>
	 * <li>IncreasingAndRandom - The first 90% of the elements are arranged in increasing order and the last 10%
	 * of the elements are randomly generated.</li>
	 * </ol>
	 *
	 */
	public static enum ArrayType {Equal, Random, Increasing, Decreasing, IncreasingAndRandom};
	
	/**
	 * This <code>enum</code> is used to specify the desired sort algorithm:
	 * 
	 * <ol>
	 * <li>MergeSort - Indicates the Merge Sort algorithm.</li>
	 * <li>QuickSort - Indicates the Quick Sort algorithm.</li>
	 * <li>HeapSort - Indicates the Heap Sort algorithm.</li>
	 * </ol>
	 *
	 */
	public static enum SortType {MergeSort, QuickSort, HeapSort};
	
	/**
	 * 
	 * This method is used to create a new array of <b>Integer</b> objects of the type and size
	 * specified.
	 * 
	 * @param arrayType	This parameter specifies the type of array to create. See the enum {@link ArrayType}.
	 * 
	 * @param arraySize This parameter specifies the size of array to create.
	 * 
	 * @return	The method will return the array of <b>Integer</b> objects that was created.
	 * 
	 */
	public Integer[] createArray(ArrayType arrayType, int arraySize);
	
	/**
	 * 
	 * This method will run all the possible sorts a specified number of times. Each time a sort is run,
	 * the method will obtain a new array to sort. The array will be of the specified type and size.
	 * 
	 * @param arrayType This parameter specifies the type of array to create each time the sort is run. 
	 * See the enum {@link ArrayType}.
	 * @param arraySize This parameter specifies the size of array to create each time the sort is run.
	 * @param numberOfTimes This parameter specifies the number of times to run the specified sort.
	 * 
	 * @return The method must return an array of RunTime instances. The array will contain the the following
	 * instances:
	 * 
	 *  <ol>
	 *  <li>MergeSort</li>
	 *  <li>QuickSort PivotType.FirstElement</li>
	 *  <li>QuickSort PivotType.RandomElement</li>
	 *  <li>QuickSort PivotType.MidOfFirstMidLastElement</li>
	 *  <li>HeapSort</li>
	 *  </ol>
	 * 
	 */
	public RunTime[] runSorts(ArrayType arrayType, int arraySize, int numberOfTimes);

}
