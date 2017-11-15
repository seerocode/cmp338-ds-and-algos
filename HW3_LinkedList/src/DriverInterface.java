
/**
 * 
 * This is the DriverInterface for 
 * <a href="">
 *    Homework 3
 * </a>
 * of CMP-338 in the Spring 2017 semester.
 * 
 * @author Sameh A. Fakhouri
 *
 */
public interface DriverInterface {
	
	/**
	 * 
	 * This <code>enum</code> is used to specify which list implementation to use. All list implementations 
	 * used in this assignment will be lists of <b>Integer</b>:
	 * 
	 * The <code>ListType</code> enum has the following choices:
	 * 							<ol>
	 * 								<li>ArrayBasedList</li>
	 * 								<li>LinkedList</li>
	 * 							</ol>
	 *
	 */
	public static enum ListType {ArrayBasedList, LinkedList};

	
	
	/**
	 * 
	 * This <code>enum</code> is used to specify which test scenario will be executed.
	 * 
	 * The <code>TestType</code> enum has the following choices:
	 * 							<ol>
	 * 								<li>AddSortedOdd</li>
	 * 								<li>AddSortedEven</li>
	 * 								<li>AddAll</li>
	 * 								<li>AddAllAtIndexZero</li>
	 * 								<li>RemoveAllEven</li>
 	 * 								<li>RemoveAllOdd</li>
	 * 							</ol>
	 *
	 */
	public static enum TestType {AddSortedOdd, AddSortedEven, AddAll, AddAllAtIndexZero, RemoveAllEven, RemoveAllOdd};
 
	
	
	
	/**
	 * 
	 * This method is used to create a new list of the specified <b>listType</b>. Depending on the 
	 * specified <b>testType</b>, this method may need to initialize the list with some entries. For example, for the 
	 * <b>AddSortedOdd</b> test case, the list will need to be initialized to contain all the even numbers from 2 to 10,000.
	 * In that case, this method will initialize the list to contain the even numbers after creating the list. See 
	 * {@Link initializeList}.
	 * 
	 * @param listType		This parameter specifies the type of list to create. See the enum {@link ListType}.
	 * 
	 * @param forTestType 	This parameter specifies the type of test that the list is being created for. See the enum
	 * {@link TestType}. 
	 * 
	 * @return	The method will return the created list as a ListInterface<I>.
	 * 
	 */
	public ListInterface<Integer> createList(ListType listType, TestType forTestType);
	

	
	/**
	 * 
	 * This method is called by the createList() method to initialize the test list. The test list could either
	 * be an ArrayList or a LinkedList. In either case, it will implement the ListInterface. 
	 * 
	 * @param 	list		The list to be initialized.
	 * @param 	firstNumber	The first number to be added to the list.
	 * @param 	lastNumber	The last number to be added to the list
	 * @param 	increment	The increment to be used by the for loop for each iteration. If the increment is zero, the
	 * 						test list is left empty.
	 * 
	 * @return	The initialized list.
	 * 
	 */
	public ListInterface<Integer> initializeList(ListInterface<Integer> list,  int firstNumber, int lastNumber, int increment);

	
	
	/**
	 * 
	 * This method is used to calculate the amount of memory being used in the JVM currently.
	 * 
	 * @return	a <code>double</code> representing the amount of memory in megabytes currently allocated in
	 * 			the JVM. Please note that you must convert from kilobytes to megabytes.
	 */
	public double memoryUsage();

	
	
	/**
	 * 
	 * This method is called to run a particular test case on a list type a total of ten times. The run time
	 * for each run is saved in the runTimes array.
	 * 
	 * @param 	listType		The type of list needed. See the enum {@link ListType}.
	 * @param 	testType		The type of test case being run. See the enum {@link TestType}.
	 * @param 	numberOfTimes 	This parameter specifies the number of times to run the specified test.
	 * 
	 * @return	
	 * 
	 */
	public RunTime runTestCase(ListType listType, TestType testType, int numberOfTimes); 

}
