import java.util.Arrays;

public class Driver implements DriverInterface {

	QuickSort.PivotType pivotType = null;
	RunTime run = new RunTime();

	@Override
	public Integer[] createArray(ArrayType arrayType, int arraySize) {
		switch (arrayType) {
		case Equal:
			Integer[] equalArray = new Integer[arraySize];
			for (int value = 0; value < equalArray.length; value++) {
				equalArray[value] = 1;
			}
			return equalArray;
		case Random:
			Integer[] randArray = new Integer[arraySize];
			for (int value = 0; value < randArray.length; value++) {
				randArray[value] = (int) (Math.random() * 100000);
			}
			return randArray;
		case Increasing:
			Integer[] incArray = new Integer[arraySize];
			for (int i = 0; i < incArray.length; i++) {
				incArray[i] = i + 1;
			}
			return incArray;
		case Decreasing:
			Integer[] decArray = new Integer[arraySize];
			int counter = arraySize;
			for (int i = 0; i < decArray.length; i++) {
				// assign and then decrement
				decArray[i] = counter--;
			}
			return decArray;
		case IncreasingAndRandom:
			// 90% increasing and 10% random
			// 90% of 1000 = 100 random numbers
			// 90% of 10,000 = 1000 random numbers
			Integer[] incAndRandArray = new Integer[arraySize];
			incAndRandArray[0] = 1;
			// - 1 so it doesnt go up to 901
			int arrayAt90Percent = (int) (incAndRandArray.length * .90);
			for (int i = 1; i < arrayAt90Percent; i++) {
				incAndRandArray[i] = i + 1;
			}
			for (int i = arrayAt90Percent; i < incAndRandArray.length; i++) {
				incAndRandArray[i] = (int) (Math.random() * 100000);
			}
			return incAndRandArray;
		}

		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public RunTime[] runSorts(ArrayType arrayType, int arraySize, int numberOfTimes) {
		
		// instantiate classes
		MergeSort ms = new MergeSort();
		QuickSort qs = new QuickSort();
		HeapSort hs = new HeapSort();
		
		// initialize array of runtimes
		RunTime[] rts = new RunTime[5];
		
		switch (arrayType) {
		case Decreasing:

			// create array
			Integer[] mergeArray = createArray(ArrayType.Decreasing, arraySize);
			
			// run the sort
			for (int i = 0; i < numberOfTimes; i++) {
				ms.sort(mergeArray);
			}
			// add runtime
			rts[0] = ms.mergeRun;
			
		/************************ Quick Sort FirstElement *****************************/
			
			// create quick sort integer object
//			QuickSort<Integer> qsFirstElement = new QuickSort<Integer>();
			
			
			// create array
			Integer[] qsFirstArray = createArray(ArrayType.Decreasing, arraySize);
			
			// run the sort
				for (int i = 0; i < numberOfTimes; i++) {
					// set the pivot type
					qs.setPivotType(pivotType.FirstElement);
					qs.sort(qsFirstArray);
				}
			// add runtime
			rts[1] = qs.qsRun;
				
		/************************ Quick Sort RandomElement *****************************/
				
			// create quick sort integer object
//			QuickSort<Integer> qsRandomElement = new QuickSort<Integer>();
				
				
			// create array
			Integer[] qsRandArray = createArray(ArrayType.Decreasing, arraySize);
				
			// run the sort
				for (int i = 0; i < numberOfTimes; i++) {
					// set the pivot type
					qs.setPivotType(pivotType.RandomElement);
					qs.sort(qsRandArray);
				}
		
			// add runtime
			rts[2] = qs.qsRun;
				
		/******************** Quick Sort MidofFirstMidLastElement **********************/
			
			// create quick sort integer object
//			QuickSort<Integer> qsMidElement = new QuickSort<Integer>();
			
			
				
			// create array
			Integer[] midFirstArray = createArray(ArrayType.Decreasing, arraySize);
				
			// run the sort
				for (int i = 0; i < numberOfTimes; i++) {
					// set the pivot type
					qs.setPivotType(pivotType.MidOfFirstMidLastElement);
					qs.sort(midFirstArray);
				}
			
			// add runtime
			rts[3] = qs.qsRun;
			
		
		/************************        Heap Sort         *****************************/
				
			// create array
			Integer[] heapArray = createArray(ArrayType.Decreasing, arraySize);
			
			// run the sort
			for (int i = 0; i < numberOfTimes; i++) {
				hs.sort(heapArray);
			}
			// add runtime
			rts[4] = hs.hsRun;
			
			return rts;
		
		case Equal:
			
		/************************       Merge Sort        ******************************/

			/*RunTime[] eqRuns = new RunTime[5];*/
			
			// create array
			Integer[] eqMergeArray = createArray(ArrayType.Equal, arraySize);
			
			// run the sort
			for (int i = 0; i < numberOfTimes; i++) {
				ms.sort(eqMergeArray);
			}
			// add runtime
			rts[0] = ms.mergeRun;
			
		/************************ Quick Sort FirstElement *****************************/
		
			// create quick sort integer object
//			QuickSort<Integer> qsEqFirstElement = new QuickSort<Integer>();
			
			// set pivot type
			qs.setPivotType(pivotType.FirstElement);
			
			// create array
			Integer[] qsEqFirstArray = createArray(ArrayType.Equal, arraySize);
				
			// run the sort
				for (int i = 0; i < numberOfTimes; i++) {
					qs.sort(qsEqFirstArray);
				}
			
			// add runtime
			rts[1] = qs.qsRun;
				
		
		/************************ Quick Sort RandomElement ***************************/
				
			// create quick sort integer object
//			QuickSort<Integer> qsEqRandomElement = new QuickSort<Integer>();
			
			// set pivot type
			qs.setPivotType(pivotType.RandomElement);
				
			// create array
			Integer[] qsEqRandArray = createArray(ArrayType.Equal, arraySize);
				
			// run the sort
				for (int i = 0; i < numberOfTimes; i++) {
					qs.sort(qsEqRandArray);
				}
				
			// add runtime
			rts[2] = qs.qsRun;
				
		
		/************************ Quick Sort MidElement *****************************/
			
			// create quick sort integer object
//			QuickSort<Integer> qsEqMidElement = new QuickSort<Integer>();
			
			// set pivot type
			qs.setPivotType(pivotType.MidOfFirstMidLastElement);
				
			// create array
			Integer[] midEqFirstArray = createArray(ArrayType.Equal, arraySize);
				
			// run the sort
				for (int i = 0; i < numberOfTimes; i++) {
					qs.sort(midEqFirstArray);
				}
			
			// add runtime
			rts[3] = qs.qsRun;
			
		
		/************************        Heap Sort         *****************************/
				
			// create array
			Integer[] heapEqArray = createArray(ArrayType.Equal, arraySize);
			
			// run the sort
			for (int i = 0; i < numberOfTimes; i++) {
				hs.sort(heapEqArray);
			}
			// add runtime
			rts[4] = hs.hsRun;
			
//			System.out.println(Arrays.asList(rts));
			return rts;

			
		case Increasing:
			// create array
			Integer[] mergeIncArray = createArray(ArrayType.Increasing, arraySize);
			
			// run the sort
			for (int i = 0; i < numberOfTimes; i++) {
				ms.sort(mergeIncArray);
			}
			// add runtime
			rts[0] = ms.mergeRun;
			
		//FirstElement
			
//			QuickSort<Integer> qsIncFirstElement = new QuickSort<Integer>();
			
			qs.setPivotType(pivotType.FirstElement);
			
				// create array
				Integer[] qsIncFirstArray = createArray(ArrayType.Increasing, arraySize);
				
				// run the sort
				for (int i = 0; i < numberOfTimes; i++) {
					qs.sort(qsIncFirstArray);
				}
				// add runtime
				rts[1] = qs.qsRun;
				
			//RandomElement:
				
//				QuickSort<Integer> qsIncRandomElement = new QuickSort<Integer>();
				
				qs.setPivotType(pivotType.RandomElement);
				
				// create array
				Integer[] qsIncRandArray = createArray(ArrayType.Increasing, arraySize);
				
				// run the sort
				for (int i = 0; i < numberOfTimes; i++) {
					qs.sort(qsIncRandArray);
				}
				// add runtime
				rts[2] = qs.qsRun;
				
			//MidOfFirstMidLastElement:
				
//				QuickSort<Integer> qsIncMidElement = new QuickSort<Integer>();
				qs.setPivotType(pivotType.MidOfFirstMidLastElement);
				
				// create array
				Integer[] midIncFirstArray = createArray(ArrayType.Increasing, arraySize);
				
				// run the sort
				for (int i = 0; i < numberOfTimes; i++) {
					qs.sort(midIncFirstArray);
				}
				// add runtime
				rts[3] = qs.qsRun;
			
		
			//HeapSort:
				
			// create array
			Integer[] heapIncArray = createArray(ArrayType.Increasing, arraySize);
			
			// run the sort
			for (int i = 0; i < numberOfTimes; i++) {
				hs.sort(heapIncArray);
			}
			// add runtime
			rts[4] = hs.hsRun;
			
			return rts;
			
			
		case IncreasingAndRandom:
			// create array
			Integer[] mergeIncRandArray = createArray(ArrayType.IncreasingAndRandom, arraySize);
			
			// run the sort
			for (int i = 0; i < numberOfTimes; i++) {
				ms.sort(mergeIncRandArray);
			}
			// add runtime
			rts[0] = ms.mergeRun;
			
		//FirstElement
			
//			QuickSort<Integer> qsIncRandFirstElement = new QuickSort<Integer>();
			
			qs.setPivotType(pivotType.FirstElement);
			
				// create array
				Integer[] qsIncRandFirstArray = createArray(ArrayType.IncreasingAndRandom, arraySize);
				
				// run the sort
				for (int i = 0; i < numberOfTimes; i++) {
					qs.sort(qsIncRandFirstArray);
				}
				// add runtime
				rts[1] = qs.qsRun;
				
			//RandomElement:
				
//				QuickSort<Integer> qsIncRandRandomElement = new QuickSort<Integer>();
				
				qs.setPivotType(pivotType.RandomElement);
				
				// create array
				Integer[] qsIncRandRElementArray = createArray(ArrayType.IncreasingAndRandom, arraySize);
				
				// run the sort
				for (int i = 0; i < numberOfTimes; i++) {
					qs.sort(qsIncRandRElementArray);
				}
				// add runtime
				rts[2] = qs.qsRun;
				
			//MidOfFirstMidLastElement:
				
//				QuickSort<Integer> qsRandIncMidElement = new QuickSort<Integer>();
				qs.setPivotType(pivotType.MidOfFirstMidLastElement);
				
				// create array
				Integer[] midRandIncFirstArray = createArray(ArrayType.IncreasingAndRandom, arraySize);
				
				// run the sort
				for (int i = 0; i < numberOfTimes; i++) {
					qs.sort(midRandIncFirstArray);
				}
				// add runtime
				rts[3] = qs.qsRun;
			
		
			//HeapSort:
				
			// create array
			Integer[] heapRandIncArray = createArray(ArrayType.IncreasingAndRandom, arraySize);
			
			// run the sort
			for (int i = 0; i < numberOfTimes; i++) {
				hs.sort(heapRandIncArray);
			}
			// add runtime
			rts[4] = hs.hsRun;
			
			return rts;
			
		case Random:
			// create array
			Integer[] mergeRandomArray = createArray(ArrayType.Random, arraySize);
			
			// run the sort
			for (int i = 0; i < numberOfTimes; i++) {
				ms.sort(mergeRandomArray);
			}
			// add runtime
			rts[0] = ms.mergeRun;
			
		//FirstElement
			
//			QuickSort<Integer> qsRandomFirstElement = new QuickSort<Integer>();
			
			qs.setPivotType(pivotType.FirstElement);
			
				// create array
				Integer[] qsRandomFirstArray = createArray(ArrayType.Random, arraySize);
				
				// run the sort
				for (int i = 0; i < numberOfTimes; i++) {
					qs.sort(qsRandomFirstArray);
				}
				// add runtime
				rts[1] = qs.qsRun;
				
			//RandomElement:
				
//				QuickSort<Integer> qsRandomRandomElement = new QuickSort<Integer>();
				
				qs.setPivotType(pivotType.RandomElement);
				
				// create array
				Integer[] qsRandomElementArray = createArray(ArrayType.Random, arraySize);
				
				// run the sort
				for (int i = 0; i < numberOfTimes; i++) {
					qs.sort(qsRandomElementArray);
				}
				// add runtime
				rts[2] = qs.qsRun;
				
			//MidOfFirstMidLastElement:
				
//				QuickSort<Integer> qsRandomMidElement = new QuickSort<Integer>();
				qs.setPivotType(pivotType.MidOfFirstMidLastElement);
				
				// create array
				Integer[] midRandomFirstArray = createArray(ArrayType.Random, arraySize);
				
				// run the sort
				for (int i = 0; i < numberOfTimes; i++) {
					qs.sort(midRandomFirstArray);
				}
				// add runtime
				rts[3] = qs.qsRun;
			
		
			//HeapSort:
				
			// create array
			Integer[] heapRandomArray = createArray(ArrayType.Random, arraySize);
			
			// run the sort
			for (int i = 0; i < numberOfTimes; i++) {
				hs.sort(heapRandomArray);
			}
			// add runtime
			rts[4] = hs.hsRun;
			
			return rts;
			}
		return rts;

		}
	
	public void showHeaders(String sortName, String runType, String runMeasure) {
		System.out.println("=============== " + sortName + " ===============" + "\n");

		for (int i = 1; i < 12; i++) {
			if (i < 11) {
				System.out.print("Run " + i + "\t\t\t");
			} else {
				System.out.println("Average");
			}

		}
		for (int i = 0; i < 11; i++) {
			System.out.print(runType + "\t\t\t");
		}
		System.out.println();
		for (int i = 0; i < 11; i++) {
			System.out.print(runMeasure + "\t\t\t");
		}
		System.out.println();
		for (int i = 0; i < 11; i++) {
			System.out.print("-------" + "\t\t\t");
		}
		System.out.println();
	}
	
	public void showSeconds(ArrayType arrayType, int size, int sortIndex) {
		RunTime[] runs = runSorts(arrayType, size, 10);
		
		double[] array = runs[sortIndex].getRunTimes();

		for (int i = 0; i < array.length; i++) {
			System.out.printf("%-18s\t", array[i]);
		}

		System.out.print(runs[sortIndex].getAverageRunTime());
		System.out.println();
	}
	
	public void showBytes(ArrayType arrayType, int size, int sortIndex) {
		RunTime[] bytes = runSorts(arrayType, size, 10);
		
		double[] array = bytes[sortIndex].getMemoryUsages();

		for (int i = 0; i < array.length; i++) {
			System.out.printf("%-18s\t", array[i]);
		}

		System.out.print(bytes[sortIndex].getAverageMemoryUsage());
		System.out.println();
	}
	
	public void showFullStats(String arraytype, ArrayType arrayType, int size) {
		String ms = "MergeSort";	
        String qsfe = "QuickSort FirstElement";
        String qsrand = "QuickSort RandomElement";
        String qsmid = "QuickSort MidOfFirstMidLastElement";
        String hs = "HeapSort";
        
        // seconds
        System.out.println(arraytype + ", " + size);
        System.out.println("---------------------");
        // Merge
        showHeaders(ms, "Micro", "Seconds");
        showSeconds(arrayType, size, 0);
        // QuickSort First Element
        showHeaders(qsfe, "Micro", "Seconds");
        showSeconds(arrayType, size, 1);
        // QuickSort RandomElement
        showHeaders(qsrand, "Micro", "Seconds");
        showSeconds(arrayType, size, 2);
        // QuickSort Mid
        showHeaders(qsmid, "Micro", "Seconds");
        showSeconds(arrayType, size, 3);
        // Heap
        showHeaders(hs, "Micro", "Seconds");
        showSeconds(arrayType, size, 4);
        
        System.out.println();
        System.out.println("//////////// Bytes ///////////");
        
        // bytes
        // Merge
        showHeaders(ms, "Kilo", "Bytes");
        showBytes(arrayType, size, 0);
        // QuickSort First Element
        showHeaders(qsfe, "Kilo", "Bytes");
        showBytes(arrayType, size, 1);
        // QuickSort RandomElement
        showHeaders(qsrand, "Kilo", "Bytes");
        showBytes(arrayType, size, 2);
        // QuickSort Mid
        showHeaders(qsmid, "Kilo", "Bytes");
        showBytes(arrayType, size, 3);
        // Heap
        showHeaders(hs, "Kilo", "Bytes");
        showBytes(arrayType, size, 4);
	}


	public static void main(String[] args) {
		
		Driver test = new Driver();
		
		test.showFullStats("Equal", ArrayType.Equal, 1000);
		System.out.println();
		test.showFullStats("Random", ArrayType.Random, 1000);
		System.out.println();
		test.showFullStats("Increasing", ArrayType.Increasing, 1000);
		System.out.println();
		test.showFullStats("Increasing & Random", ArrayType.IncreasingAndRandom, 1000);
		System.out.println();
		
		System.out.println();
		
		test.showFullStats("Equal", ArrayType.Equal, 10000);
		System.out.println();
		test.showFullStats("Random", ArrayType.Random, 10000);
		System.out.println();
		test.showFullStats("Increasing", ArrayType.Increasing, 10000);
		System.out.println();
		test.showFullStats("Increasing & Random", ArrayType.IncreasingAndRandom, 10000);
		System.out.println();
        
      
       
		
	}

}
