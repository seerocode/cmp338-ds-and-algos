public class Driver implements DriverInterface {
	
	private static int[] listOfNumbers = new int[10000000];
	private static long[] runTimes = new long[10];
	private static int[] targets = {500, 10000, 100000, 1000000, 5000000, 7500000, 10000000};

	
	/**
	 * This method returns a list of numbers from 1 to 10000000
	 */
	@Override
	public int[] getListOfNumbers() {
		
		int numCountUp = 1;
		
		// set array to numbers from 1 to 10000000
		for (int indexOfNum = 0; indexOfNum < listOfNumbers.length; indexOfNum++) {
			listOfNumbers[indexOfNum] = numCountUp++;
		}
		
		return this.listOfNumbers;
	}

	/**
	 * This method gets the targets array
	 */
	@Override
	public int[] getTargets() {

		return targets;
	}

	/**
	 * This method runs a linearsearch x amount of times
	 */
	@Override
	public RunTime runLinearSearch(int[] listOfNumbers, int target, int numberOfTimes) {
		listOfNumbers = getListOfNumbers();
		
		LinearSearch newLinearSearch = new LinearSearch();
		
		for (int counter = 0; counter < numberOfTimes; counter++) {
			newLinearSearch.search(listOfNumbers, target);
		}
		
		return newLinearSearch;
	}

	/**
	 * This method runs a binarysearch x amount of times
	 */
	@Override
	public RunTime runBinarySearch(int[] listOfNumbers, int target, int numberOfTimes) {
		listOfNumbers = getListOfNumbers();
		
		BinarySearch newBinarySearch = new BinarySearch();
		
		for (int counter = 0; counter < numberOfTimes; counter++) {
			newBinarySearch.search(listOfNumbers, target);
		}
		
		return newBinarySearch;
	}
	

	public static void main(String[] args) {
		Driver Driver = new Driver();
		
		//create an array to go through targets
		int [] numbers = Driver.getListOfNumbers();
		int[] targets = Driver.getTargets();
						
	}

}
