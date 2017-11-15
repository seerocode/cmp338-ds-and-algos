
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
	 * <li>BubbleSort - Indicates the Bubble Sort algorithm.</li>
	 * <li>SelectionSort - Indicates the Selection Sort algorithm.</li>
	 * <li>InsertionSort - Indicates the Insertion Sort algorithm.</li>
	 * </ol>
	 *
	 */
	public static enum SortType {BubbleSort, SelectionSort, InsertionSort};
	
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
	 * This method will run the specified sort type a specified number of times. Each time the sort run
	 * the method will obtain a new array to sort. The array will be of the specified type and size.
	 * 
	 * @param sortType This parameter specifies the sort algorithm that will be used. See {@link SortType}.
	 * 
	 * @param arrayType This parameter specifies the type of array to create each time the sort is run. 
	 * See the enum {@link ArrayType}.
	 * 
	 * @param arraySize This parameter specifies the size of array to create each time the sort is run.
	 * 
	 * @param numberOfTimes This parameter specifies the number of times to run the specified sort.
	 * 
	 * @return The method must return the RunTime class that was used to save the measured run times for the 
	 * sort performed.
	 * 
	 */
	public RunTime runSort(SortType sortType, ArrayType arrayType, int arraySize, int numberOfTimes);

}
