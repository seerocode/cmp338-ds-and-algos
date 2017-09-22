
public class LinearSearch extends RunTime implements SearchInterface {
	
	private long runTime;
	private long startTime;
	private long endTime;

	/** This method is used for searching for a target value in an array representing a listOfNumbers.
	 */
	@Override
	public int search(int[] listOfNumbers, int target) {
		/*
		 * Pseudo code: Linear search is searching one by one for a number starting at the beginning
		 * 
		 * for each number in the array,
		 * check if it is equal to the target number,
		 * If not, equal before the end of the array, continue to the next index
		 * If reach end of array, return -1
		 * 
		 */
		
		int foundIndex = -1;
		
		this.startTime = System.nanoTime();
		
		for (int findNum = 0; findNum < listOfNumbers.length; findNum++) {
			if (listOfNumbers[findNum] == target) {
				foundIndex = findNum;
				break;
			} 
		}
		
		this.endTime = System.nanoTime();
		this.runTime = endTime - startTime;
		super.addRuntime(runTime);
		
		return foundIndex;
	}
	
////	 test for linearSeach
//public static void main (String[] args) {
//		
//		LinearSearch driver = new LinearSearch();		
//		Driver getNums = new Driver();
//		
//		System.out.println(driver.search(getNums.getListOfNumbers(), 100000));
//		
//		System.out.println(driver.runTime);
//		
////		rt.addRuntime(runTime);
//		
//		System.out.println(Arrays.toString(driver.getRunTimes()));
//		
//	}

}
