public class BinarySearch extends RunTime implements SearchInterface {
	
	private long startTime;
	private long endTime;
	protected long runTime;

	@Override
	public int search(int[] listOfNumbers, int target) {
		
		// start time for loop execution
		this.startTime = System.nanoTime();
		
		// beginning search index
		int lowNum = 0;
		// end search index
		int highNum = listOfNumbers.length - 1;
				
		int foundIndex = -1;

		// while the last number is <= to the first number
			while (highNum >= lowNum) {
				// set the middle number to 1/2 of the first and last index
				int midNum = (lowNum + highNum) / 2;
				// if the middle number of the array is equal to the target, set foundIndex to that number and break out of loop
				if (listOfNumbers[midNum] == target) {
					foundIndex = midNum;
					break;
				}
				// otherwise, if middle num of array is less than target, set the beginning of search to the next middle number
				else if (listOfNumbers[midNum] < target) {
					lowNum = midNum + 1;
				}
				// if great than target, set the beginning of search to the left most middle number
				else {
					highNum = midNum - 1;
				}
			}
		
			// endtime for loop execution
			this.endTime = System.nanoTime();
			// grab end run time for loop execution
			this.runTime = endTime - startTime;
			// add runtime to runtime method in RunTime class
			this.addRuntime(runTime);	
			
		return foundIndex;
	}
	
	// main method is just for testing
//public static void main (String[] args) {
//		
//		BinarySearch driver = new BinarySearch();
//		
//		Driver getNums = new Driver();
//		
//		System.out.println("Index at " + driver.search(getNums.getListOfNumbers(), 10));
//		
//		System.out.println("Runtime = " + driver.runTime);
////		System.out.println(rt.runTime);
////		rt.addRuntime(driver.runTime);
////		rt.addRuntime(driver.runTime);
//		System.out.println(Arrays.toString(driver.getRunTimes()));
//		
//	}

}
