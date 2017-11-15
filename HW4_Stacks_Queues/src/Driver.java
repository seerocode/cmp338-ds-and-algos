import java.util.Arrays;
import java.util.Vector;

public class Driver implements DriverInterface {

	@Override
	public QueueInterface<String> createQueue(QueueType queueType, QueueTestType queueTestType) {
		// TODO Auto-generated method stub
		switch (queueType) {
		case ArrayBasedQueue:
			switch (queueTestType) {
			case Enqueue:
				ArrayBasedQueue<String> arrayEnqueue = new ArrayBasedQueue<String>();

				return arrayEnqueue;
			case Dequeue:
				ArrayBasedQueue<String> arrayDequeue = new ArrayBasedQueue<String>();

				for (int i = 1; i <= 10000; i++) {
					arrayDequeue.enqueue("String " + i);
				}

				return arrayDequeue;

			case Iterate:

				ArrayBasedQueue<String> arrayIter = new ArrayBasedQueue<String>();

				for (int i = 1; i <= 10000; i++) {
					arrayIter.enqueue("String " + i);
				}

				// for (int i = 0; i < arrayIter.size(); i++) {
				while (arrayIter.iterator().hasNext()) {
					System.out.println(arrayIter.iterator().next());
				}
				// }

				return arrayIter;
			}
		case LinkedQueue:
			switch (queueTestType) {
			case Enqueue:
				LinkedQueue<String> linkEnqueue = new LinkedQueue<String>();

				return linkEnqueue;

			case Dequeue:
				LinkedQueue<String> linkDequeue = new LinkedQueue<String>();

				for (int i = 1; i <= 10000; i++) {
					linkDequeue.enqueue("String " + i);
				}

				return linkDequeue;

			case Iterate:

				LinkedQueue<String> linkIter = new LinkedQueue<String>();

				for (int i = 1; i <= 10000; i++) {
					linkIter.enqueue("String " + i);
				}

				// for (int i = 0; i < linkIter.size(); i++) {
				// while (linkIter.iterator().hasNext()) {
				// System.out.println(linkIter.iterator().next());
				//// }
				// }

				return linkIter;
			}
		}

		return null;
	}

	@Override
	public StackInterface<String> createStack(StackType stackType, StackTestType stackTestType) {
		switch (stackType) {
		case ArrayBasedStack:
			switch (stackTestType) {
			case Push:
				ArrayBasedStack<String> arrayStackPush = new ArrayBasedStack<String>();
				return arrayStackPush;
			case Pop:
				ArrayBasedStack<String> arrayStackPop = new ArrayBasedStack<String>();

				for (int i = 1; i <= 10000; i++) {
					arrayStackPop.push("String " + i);
				}
				return arrayStackPop;

			case Iterate:
				ArrayBasedStack<String> arrayStackIter = new ArrayBasedStack<String>();

				for (int i = 1; i <= 10000; i++) {
					arrayStackIter.push("String " + i);
				}
				// for (int i = 0; i < arrayStackIter.size(); i++) {
				while (arrayStackIter.iterator().hasNext()) {
					System.out.println(arrayStackIter.iterator().next());
					// }
				}
				return arrayStackIter;
			}
		case LinkedStack:
			switch (stackTestType) {
			case Push:
				LinkedStack<String> linkStackPush = new LinkedStack<String>();
				return linkStackPush;

			case Pop:
				LinkedStack<String> linkStackPop = new LinkedStack<String>();

				for (int i = 1; i <= 10000; i++) {
					linkStackPop.push("String " + i);
				}
				return linkStackPop;
			case Iterate:
				LinkedStack<String> linkStackIter = new LinkedStack<String>();

				for (int i = 1; i <= 10000; i++) {
					linkStackIter.push("String " + i);
				}

				while (linkStackIter.iterator().hasNext()) {
					System.out.println(linkStackIter.iterator().next());
				}
				// }

				return linkStackIter;
			}
		}

		return null;
	}

	@Override
	public RunTime runQueueTestCase(QueueType queueType, QueueTestType queueTestType, int numberOfTimes) {
		
		switch (queueType) {
		case ArrayBasedQueue:

			RunTime runArrQueue = new RunTime(){{
				setTimeUnits(TimeUnits.MicroSeconds);
				setMemoryUnits(MemoryUnits.KiloBytes);
			}};

			for (int i = 0; i < numberOfTimes; i++) {
				long startTime = System.nanoTime();

				this.createQueue(QueueType.ArrayBasedQueue, queueTestType);

				long endTime = System.nanoTime();
				long runTime = endTime - startTime;
				runArrQueue.addRuntime(runTime);
			}

			return runArrQueue;

		case LinkedQueue:

			RunTime run = new RunTime(){{
				setTimeUnits(TimeUnits.MicroSeconds);
				setMemoryUnits(MemoryUnits.KiloBytes);
			}};

			for (int i = 0; i < numberOfTimes; i++) {
				long startTime = System.nanoTime();

				this.createQueue(QueueType.LinkedQueue, queueTestType);

				long endTime = System.nanoTime();
				long runTime = endTime - startTime;
				run.addRuntime(runTime);
			}

			return run;
		}

		return null;
	}

	@Override
	public RunTime runStackTestCase(StackType stackType, StackTestType stackTestType, int numberOfTimes) {

		switch (stackType) {
		case ArrayBasedStack:

			RunTime arrayStackRun = new RunTime();

			for (int i = 0; i < numberOfTimes; i++) {
				long startTime = System.nanoTime();

				this.createStack(StackType.ArrayBasedStack, stackTestType);

				long endTime = System.nanoTime();
				long runTime = endTime - startTime;
				arrayStackRun.addRuntime(runTime);
			}

			return arrayStackRun;

		case LinkedStack:
			RunTime linkedStackRun = new RunTime();

			for (int i = 0; i < numberOfTimes; i++) {
				long startTime = System.nanoTime();

				this.createStack(StackType.LinkedStack, stackTestType);

				long endTime = System.nanoTime();
				long runTime = endTime - startTime;
				linkedStackRun.addRuntime(runTime);
			}

			return linkedStackRun;
		}

		return null;
	}

	public void printQueue() {
		
		System.out.println("////////////////////////////////////////////////// QUEUES ////////////////////////////////////////////////////////////");
		System.out.println();
		
		for (QueueTestType type: QueueTestType.values()) {
		
		String format = "                  %-7s   %-7s   %-7s   %-7s   %-7s   %-7s   %-7s   %-7s   %-7s   %-7s   %-7s";
		
		/* ENQUEUE METHOD*/
		
		System.out.printf("Running test: %s \n", type);
		System.out.printf(format, 
				"Run 1", "Run 2", "Run 3", "Run 4", "Run 5", "Run 6", "Run 7", "Run 8", "Run 9", "Run 10", "Average\n");
		System.out.printf(format, 
				"Micro", "Micro", "Micro", "Micro", "Micro", "Micro", "Micro", "Micro", "Micro", "Micro", "Micro\n");
		System.out.printf(format, 
				"Seconds", "Seconds", "Seconds", "Seconds", "Seconds", "Seconds", "Seconds", "Seconds", "Seconds", "Seconds", "Seconds\n");
		System.out.printf(format, 
				"_______", "_______", "_______", "_______", "_______", "_______", "_______", "_______", "_______", "_______", "_______\n");
		
		//////////////////////////////////////////////////
		
		double [] printRuns = this.runQueueTestCase(QueueType.ArrayBasedQueue, type, 10).getRunTimes();
		double avgSeconds = this.runQueueTestCase(QueueType.ArrayBasedQueue, type, 10).getAverageRunTime();
		
		System.out.printf("%s ", QueueType.ArrayBasedQueue);
		
		for(int i = 0; i < printRuns.length; i++) {
			System.out.printf(" %9s", printRuns[i]);
		}
		System.out.printf("   %-7s   ", avgSeconds);
		
		//////////////////////////////////////////////////
		
		double [] printLRuns = this.runQueueTestCase(QueueType.LinkedQueue, type, 10).getRunTimes();
		double avgLSeconds = this.runQueueTestCase(QueueType.LinkedQueue, type, 10).getAverageRunTime();
		
		System.out.println();
		System.out.printf("%s ", QueueType.LinkedQueue);
		
		for(int i = 0; i < printLRuns.length; i++) {
			System.out.printf("     %-2s", printLRuns[i]);
		}
		System.out.printf("      %-2s", avgLSeconds);
		
		System.out.println();
		System.out.println();
		
		//////// BYTES //////
		
		String lineFormat = "                %9s  %9s  %9s  %9s  %9s  %9s  %9s  %9s  %9s  %9s  %9s  ";
		String lines = "----------";
		
		System.out.printf("Running test: %s \n", type);
		System.out.printf(format, 
				"Run 1", "Run 2", "Run 3", "Run 4", "Run 5", "Run 6", "Run 7", "Run 8", "Run 9", "Run 10", "Average\n");
		System.out.printf(format, "Kilo", "Kilo", "Kilo", "Kilo", "Kilo", "Kilo", "Kilo", "Kilo", "Kilo", "Kilo", "Kilo\n");
		System.out.printf(format, 
				"Bytes", "Bytes", "Bytes", "Bytes", "Bytes", "Bytes", "Bytes", "Bytes", "Bytes", "Bytes", "Bytes\n");
		System.out.printf(lineFormat, 
				lines, lines, lines, lines, lines, lines, lines, lines, lines, lines, "---------\n");
		
		//////////////////////////////////////////////////
		
		double [] printSize = this.runQueueTestCase(QueueType.ArrayBasedQueue, type, 10).getMemoryUsages();
		double avgSize = this.runQueueTestCase(QueueType.ArrayBasedQueue, type, 10).getAverageMemoryUsage();
		
		System.out.printf("%s", QueueType.ArrayBasedQueue);
		
		for(int i = 0; i < printSize.length; i++) {
			System.out.printf(" %9s", printSize[i]);
		}
		System.out.printf("   %-7s   ", avgSize);
		
		//////////////////////////////////////////////////
		
		double [] printLSize = this.runQueueTestCase(QueueType.LinkedQueue, type, 10).getRunTimes();
		double avgLSize = this.runQueueTestCase(QueueType.LinkedQueue, type, 10).getAverageRunTime();
		
		System.out.println();
		System.out.printf("%s ", QueueType.LinkedQueue);
		
		for(int i = 0; i < printLSize.length; i++) {
			System.out.printf("     %-2s", printLSize[i]);
		}
		System.out.printf("      %-2s", avgLSize);
		
		System.out.println();
		System.out.println();
		System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
		
		}
	}
	
	public void printStack() {
		
		System.out.println();
		System.out.println();
		System.out.println("/////////////////////////////////////////// STACKS //////////////////////////////////////////////////////////");
		
		
		for (StackTestType type: StackTestType.values()) {
		
		String format = "                  %-7s   %-7s   %-7s   %-7s   %-7s   %-7s   %-7s   %-7s   %-7s   %-7s   %-7s";
		
		/* ENQUEUE METHOD*/
		
		System.out.printf("Running test: %s \n", type);
		System.out.printf(format, 
				"Run 1", "Run 2", "Run 3", "Run 4", "Run 5", "Run 6", "Run 7", "Run 8", "Run 9", "Run 10", "Average\n");
		System.out.printf(format, 
				"Micro", "Micro", "Micro", "Micro", "Micro", "Micro", "Micro", "Micro", "Micro", "Micro", "Micro\n");
		System.out.printf(format, 
				"Seconds", "Seconds", "Seconds", "Seconds", "Seconds", "Seconds", "Seconds", "Seconds", "Seconds", "Seconds", "Seconds\n");
		System.out.printf(format, 
				"_______", "_______", "_______", "_______", "_______", "_______", "_______", "_______", "_______", "_______", "_______\n");
		
		//////////////////////////////////////////////////
		
		double [] printRuns = this.runStackTestCase(StackType.ArrayBasedStack, type, 10).getRunTimes();
		double avgSeconds = this.runStackTestCase(StackType.ArrayBasedStack, type, 10).getAverageRunTime();
		
		System.out.printf("%s ", StackType.ArrayBasedStack);
		
		for(int i = 0; i < printRuns.length; i++) {
			System.out.printf(" %9s", printRuns[i]);
		}
		System.out.printf("   %-7s   ", avgSeconds);
		
		//////////////////////////////////////////////////
		
		double [] printLRuns = this.runStackTestCase(StackType.LinkedStack, type, 10).getRunTimes();
		double avgLSeconds = this.runStackTestCase(StackType.LinkedStack, type, 10).getAverageRunTime();
		
		System.out.println();
		System.out.printf("%s ", StackType.LinkedStack);
		
		for(int i = 0; i < printLRuns.length; i++) {
			System.out.printf("     %-2s", printLRuns[i]);
		}
		System.out.printf("      %-2s", avgLSeconds);
		
		System.out.println();
		System.out.println();
		
		//////// BYTES //////
		
		String lineFormat = "                %9s  %9s  %9s  %9s  %9s  %9s  %9s  %9s  %9s  %9s  %9s  ";
		String lines = "----------";
		
		System.out.printf("Running test: %s \n", type);
		System.out.printf(format, 
				"Run 1", "Run 2", "Run 3", "Run 4", "Run 5", "Run 6", "Run 7", "Run 8", "Run 9", "Run 10", "Average\n");
		System.out.printf(format, "Kilo", "Kilo", "Kilo", "Kilo", "Kilo", "Kilo", "Kilo", "Kilo", "Kilo", "Kilo", "Kilo\n");
		System.out.printf(format, 
				"Bytes", "Bytes", "Bytes", "Bytes", "Bytes", "Bytes", "Bytes", "Bytes", "Bytes", "Bytes", "Bytes\n");
		System.out.printf(lineFormat, 
				lines, lines, lines, lines, lines, lines, lines, lines, lines, lines, "---------\n");
		
		//////////////////////////////////////////////////
		
		double [] printSize = this.runStackTestCase(StackType.ArrayBasedStack, type, 10).getMemoryUsages();
		double avgSize = this.runStackTestCase(StackType.ArrayBasedStack, type, 10).getAverageMemoryUsage();
		
		System.out.printf("%s", StackType.ArrayBasedStack);
		
		for(int i = 0; i < printSize.length; i++) {
			System.out.printf(" %9s", printSize[i]);
		}
		System.out.printf("   %-7s   ", avgSize);
		
		//////////////////////////////////////////////////
		
		double [] printLSize = this.runStackTestCase(StackType.LinkedStack, type, 10).getRunTimes();
		double avgLSize = this.runStackTestCase(StackType.LinkedStack, type, 10).getAverageRunTime();
		
		System.out.println();
		System.out.printf("%s ", StackType.LinkedStack);
		
		for(int i = 0; i < printLSize.length; i++) {
			System.out.printf("     %-2s", printLSize[i]);
		}
		System.out.printf("      %-2s", avgLSize);
		
		System.out.println();
		System.out.println();
		System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
		
		}
	}
	
	
	public static void main(String[] args) {

		Driver driver = new Driver();
		
//		String format = "%-40s%s%n";
		
		driver.printQueue();
		driver.printStack();
		
	}

}
