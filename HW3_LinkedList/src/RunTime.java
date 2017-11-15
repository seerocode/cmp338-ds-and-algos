public class RunTime implements RuntimeInterface {
	
	private long[] runTimeArray = new long[10];
	private int runTimeCounter = 0;


	/** This method is used to retrieve the last runtime. 
	* If no runtime has been added, the method will return a zero. 
	 */
	@Override
	public long getLastRunTime() {

		long lastIndex = 0;
										
		// start index at last number, while index greater than zero, go into loop
		for (int runTimeIndex = runTimeArray.length - 1; runTimeIndex >= 0; runTimeIndex--) {
			// set lastIndex if not zero
			if (runTimeArray[runTimeIndex] != 0) {
				lastIndex = runTimeArray[runTimeIndex];
				break;
			} 
		}
		return lastIndex;
	}

	/** This method returns an array of long values representing the last 10 runtimes. 
	* If less than 10 runtimes are available, the remaining runtimes should be zero. 
	* If more than 10 runtimes have been added, the array should contain the last 10 runtimes.
	* */
	@Override
	public long[] getRunTimes() {
		
		return runTimeArray;
	}

	/** This method is used to reset all 10 linear search times to zero.
	 */
	@Override
	public void resetRunTimes() {
		// for each element in the array, set to zero
		for (int runTimeIndex = 0; runTimeIndex < runTimeArray.length; runTimeIndex++) {
			runTimeArray[runTimeIndex] = 0;
		}
		// reset the runTimeCounter
		this.runTimeCounter = 0;

	}

	/* This method is used to add a runtime.
	 * 
	 */
	@Override
	public void addRuntime(long runTime) {		
		
		// have a counter for the num of elements have starting at zero
		// every time you add a runtime, if the counter is less than 10, place runtime
		// at counter and increment
		// when the counter reaches 10, you have your full array
		
		// start counter at zero
		
		// if counter is less than 10, add a runtime at that index number for the runTimeArray
		if (this.runTimeCounter < 10) {
			runTimeArray[this.runTimeCounter] = runTime;
			// increase the counter by one for the next slot in the array
			this.runTimeCounter++;
		}
		// otherwise, if the counter reaches the last element, shift all items to left
		else if (this.runTimeCounter >= 10) {
			for (int runTimeIndex = 0; runTimeIndex < runTimeArray.length - 1; runTimeIndex++) {
				runTimeArray[runTimeIndex] = runTimeArray[runTimeIndex + 1];
			}
			// add runtime to last slot in the array
				runTimeArray[runTimeArray.length - 1] = runTime;
		}
				
	}

	/** This method is used to obtain the average runtime. 
	* The method should average all the non-zero runtimes that are available. 
	* If no runtimes are available, the method returns a zero.
	* */
	@Override
	public double getAverageRunTime() {
		
		double countHolder = 0;
		double meanOfRunTimes;
		
		// if the counter is <= 10, go through array and add up the runtimes
		if (this.runTimeCounter <= 10) {
			for (int runTimeIndex = 0; runTimeIndex < this.runTimeCounter; runTimeIndex++) {
				countHolder = countHolder + runTimeArray[runTimeIndex];
			}
		}
		
		// if the counts are equal to zero, set the mean to zero
		if (countHolder == 0) {
			meanOfRunTimes = 0;
		}
		// otherwise, set the mean to the mean of the counts
		else {
			meanOfRunTimes = countHolder / this.runTimeCounter;
		}
		
		return meanOfRunTimes;
	}
	
	@Override
	public String toString() {
		String s = "Array = {";
		
		for ( int i = 0 ; i < runTimeCounter ; i++ ) {
			s = s.concat(runTimeArray[i] + ", ");
		}
		
		s = s.concat("}");
		
		return s;
	}
	
//// test of class
//	public static void main (String[] args) {
//		
//		BinarySearch driver = new BinarySearch();
//		RunTime rt = new RunTime();
//		
//		Driver getNums = new Driver();
//						
//		System.out.println(Arrays.toString(rt.getRunTimes()));
//		System.out.println(rt.getAverageRunTime());
//		System.out.println(rt.getLastRunTime());
//	}

}
