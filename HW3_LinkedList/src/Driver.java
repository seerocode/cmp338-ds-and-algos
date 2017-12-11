public class Driver implements DriverInterface {

	// This method is used to create a new list of the specified listType. Depending
	// on the specified testType, this method may need to initialize the list with
	// some entries. For example, for the AddSortedOdd test case, the list will need
	// to be initialized to contain all the even numbers from 2 to 10,000. In that
	// case, this method will initialize the list to contain the even numbers after
	// creating the list.
	@Override
	public ListInterface<Integer> createList(ListType listType, TestType forTestType) {

		switch (listType) {
		case ArrayBasedList:
			switch (forTestType) {
			case AddAll:
				ArrayBasedList<Integer> arrayAddAll = new ArrayBasedList<Integer>();				
//				for (int i = 1; i <= 10000; i++) {
//					arrayAddAll.add(new Integer(i));
//				}
//				
				return arrayAddAll;
			case AddAllAtIndexZero:
				ArrayBasedList<Integer> arrayAddAllZero = new ArrayBasedList<Integer>();
								
//				for (int i = 1; i < 10000; i++) {
//					arrayAddAllZero.add(new Integer(i), 0);
//				}
//				
//				for (int i = 0; i < arrayAddAllZero.size(); i++) {
//					System.out.println(test2.getArray()[i]);
//				}
				
				return arrayAddAllZero;
			case AddSortedEven:
				ListInterface<Integer> arrayAddSortedEven = new ArrayBasedList<Integer>();
				arrayAddSortedEven = this.initializeList(arrayAddSortedEven, 1, 10000, 2);				
//				
				for (int i = 0; i < 10000/2; i = i + 2) {
					arrayAddSortedEven.addSorted(new Integer(i + 2));
				}
				
				return arrayAddSortedEven;
			case AddSortedOdd:
				ArrayBasedList<Integer> arrayAddSortedOdd = new ArrayBasedList<Integer>();
//				arrayAddSortedEven = this.initializeList(arrayAddSortedOdd, 0, 10000, 2);
				
//				for (int i = 1; i < 10000; i = i + 2) {
//					arrayAddSortedOdd.addSorted(new Integer(i));
//				}
				
				return arrayAddSortedOdd;
			case RemoveAllEven:
				ListInterface<Integer> arrayRemoveEven = new ArrayBasedList<Integer>();
				arrayRemoveEven = this.initializeList(arrayRemoveEven, 1, 10001, 1);
				
//				for (int index = 5; index < arrayRemoveEven.size(); index++) {
//					arrayRemoveEven.remove(index);
//					
//				}
				
				return arrayRemoveEven;
			case RemoveAllOdd:
				ListInterface<Integer> arrayRemoveOdd = new ArrayBasedList<Integer>();
				arrayRemoveOdd = this.initializeList(arrayRemoveOdd, 1, 10001, 1);
				
//				for (int i = 1; i < 10000; i = i + 2) {
//					arrayRemoveOdd.remove(1000 - 1);
//				}
				
				return arrayRemoveOdd;
			
			}

		case LinkedList:
			switch (forTestType) {
			case AddSortedEven:
				ListInterface<Integer> llAddSortedEven = new LinkedList<Integer>();
				//odd numbers les than 10,000
				llAddSortedEven = this.initializeList(llAddSortedEven, 1, 5001, 2);
				
//				for (int i = 2; i <= llAddSortedEven.size(); i = i + 2) {
//					llAddSortedEven.addSorted(new Integer(i));
//				}
				
				return llAddSortedEven;
				
			case AddAll:
				ListInterface<Integer> llAddAll = new LinkedList<Integer>();
//				llAddAll= this.initializeList(llAddAll, 0, 10000, 0);
				
				for (int i = 1; i <= 10000; i++) {
					llAddAll.add(new Integer(i));
				}
				
				return llAddAll;
			case AddAllAtIndexZero:
				ListInterface<Integer> llAddAllZero = new LinkedList<Integer>();
//				llAddAll= this.initializeList(llAddAll, 0, 10000, 0);
				
				for (int i = 1; i < 10001; i++) {
					llAddAllZero.add(new Integer(i), 0);
				}
				
				return llAddAllZero;
			case AddSortedOdd:
				
				ListInterface<Integer> llAddSortedOdd = new LinkedList<Integer>();
//				llAddSortedOdd = this.initializeList(llAddSortedOdd, 0, 10000, 0);
				
				for (int i = 1; i < 10000; i = i + 2) {
					llAddSortedOdd.addSorted(new Integer(i));
				}
				
				return llAddSortedOdd;
				
			case RemoveAllEven:
				ListInterface<Integer> llRemoveEven = new LinkedList<Integer>();
				llRemoveEven = this.initializeList(llRemoveEven, 0, 10000, 1);
				
				for (int i = 2; i <= llRemoveEven.size(); i = i + 2) {
					llRemoveEven.remove(i);
				}
				
				return llRemoveEven;
			case RemoveAllOdd:
				ListInterface<Integer> llRemoveOdd = new LinkedList<Integer>();
				llRemoveOdd = this.initializeList(llRemoveOdd, 1, 10000, 1);
				
				for (int i = 1; i <= llRemoveOdd.size(); i = i + 2) {
					llRemoveOdd.remove(llRemoveOdd.size() - 1);
					i++;
				}
				
				return llRemoveOdd;
			}

		}

		return null;
	}

	@Override
	public ListInterface<Integer> initializeList(ListInterface<Integer> list, int firstNumber, int lastNumber,
			int increment) {
		
//		list.removeAll();

		for (int i = firstNumber; i < lastNumber; i = i + increment) {
			list.add(i);
		}

		return list;
	}

	@Override
	public double memoryUsage() {

		long mb = 1024L * 1024L;
		Runtime run = Runtime.getRuntime();
		Double memory = (double) (run.totalMemory() - run.freeMemory());
		Double memoryUsed = memory / mb;

		return memoryUsed;
	}

	@Override
	public RunTime runTestCase(ListType listType, TestType testType, int numberOfTimes) {
		

		RunTime run = new RunTime();

		for (int i = 0; i < numberOfTimes; i++) {
			long startTime = System.nanoTime();
			
			this.createList(listType, testType);
			
			long endTime = System.nanoTime();
			long runTime = endTime - startTime;
			run.addRuntime(runTime);
		}
		
		
		return run;

	}
	

	public static void main(String[] args) {

		Driver test = new Driver();
		
//		TestType AddAllAtIndexZero;
//		ListType ArrayBasedList;
		System.out.println(test.createList(ListType.ArrayBasedList, TestType.AddSortedEven));
		
	}

}
