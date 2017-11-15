
public class RunTime implements RunTimeInterface {

	private double[] runTimeArray = new double[10];
	private double[] memoryArray = new double[10];
	private int counter = 0;

	private TimeUnits timeUnit;
	private MemoryUnits memUnit;
	private double secs = 1000000000;
	private double milliSecs = 1000000;
	private double microSecs = 1000;
	
	private double megaB = 1048576;
	private double kiloB = 1024;


	// public static void main(String[] args) {
	// // TODO Auto-generated method stub
	//
	// }

	@Override
	public TimeUnits getTimeUnits() {
		return this.timeUnit;
	}

	@Override
	public void setTimeUnits(TimeUnits timeUnits) {
		this.timeUnit = timeUnits;
	}

	@Override
	public MemoryUnits getMemoryUnits() {
		return memUnit;
	}

	@Override
	public void setMemoryUnits(MemoryUnits memoryUnits) {
		this.memUnit = memoryUnits;
	}

	@Override
	public double getLastRunTime() {

		if (this.timeUnit == TimeUnits.Seconds) {
			return ((this.runTimeArray[this.counter - 1]) / this.secs);
		} else if (this.timeUnit == TimeUnits.MilliSeconds) {
			return ((this.runTimeArray[this.counter - 1]) / this.milliSecs);
		} else if (this.timeUnit == TimeUnits.MicroSeconds) {
			return ((this.runTimeArray[this.counter - 1]) / this.microSecs);
		} else {
			// nanoseconds
			return this.runTimeArray[this.counter - 1];
		}

	}

	@Override
	public double getLastMemoryUsage() {

		if (this.memUnit == MemoryUnits.KiloBytes) {
			return (this.memoryArray[this.counter - 1]) / this.kiloB;
		} else if (this.memUnit == MemoryUnits.MegaBytes) {
			return (memoryArray[this.counter - 1]) / this.megaB;
		} else {
			// bytes
			return memoryArray[counter - 1];
		}

	}

	@Override
	public double[] getRunTimes() {
		if (this.timeUnit == TimeUnits.Seconds) {
			double[] secsArray = new double[10];
			for (int i = 0; i < 10; i++) {
				secsArray[i] = (this.runTimeArray[i]) / this.secs;
			}
			return secsArray;
		}

		// if time units equals milliseconds
		else if (this.timeUnit == TimeUnits.MilliSeconds) {
			double[] milliArray = new double[10];
			for (int i = 0; i < 10; i++) {
				milliArray[i] = (this.runTimeArray[i]) / this.milliSecs;
			}
			return milliArray;
		}

		else if (this.timeUnit == TimeUnits.MicroSeconds) {
			double[] microArray = new double[10];
			for (int i = 0; i < 10; i++) {
				microArray[i] = ((runTimeArray[i]) / this.microSecs);
			}

			return microArray;
		}
		// nanoseconds
		return runTimeArray;
	}

	@Override
	public double[] getMemoryUsages() {

		if (this.memUnit == MemoryUnits.KiloBytes) {
			double[] kiloArray = new double[10];
			for (int i = 0; i < 10; i++) {
				kiloArray[i] = (this.memoryArray[i]) / this.kiloB;
			}
			return kiloArray;
		}

		else if (this.memUnit == MemoryUnits.MegaBytes) {
			double[] megaArray = new double[10];
			for (int i = 0; i < 10; i++) {
				megaArray[i] = (this.memoryArray[i]) / this.megaB;
			}
			return megaArray;
		}
		// bytes
		return memoryArray;
	}

	@Override
	public void resetRunTimes() {

		this.runTimeArray = new double[10];
		this.memoryArray = new double[10];

		// reset the runTimeCounter
		this.counter = 0;

	}

	@Override
	public void addRuntime(long runTime) {
		
		if (this.counter < this.runTimeArray.length) {
			this.runTimeArray[this.counter] = runTime;
			this.memoryArray[this.counter] = ((Runtime.getRuntime().totalMemory()) - (Runtime.getRuntime().freeMemory()));
			this.counter++;

		}

		else {
			for (int i = 0; i < (this.runTimeArray.length - 1); i++) {
				this.runTimeArray[i] = this.runTimeArray[i + 1];
				this.memoryArray[i] = this.memoryArray[i + 1];

			}
			this.memoryArray[this.memoryArray.length - 1] = ((Runtime.getRuntime().totalMemory())
					- (Runtime.getRuntime().freeMemory()));
			this.runTimeArray[this.runTimeArray.length - 1] = runTime;

		}

	}

	@Override
	public double getAverageRunTime() {
		
		double count = 0;
		
		for (int i = 0; i < this.counter; i++) {
			count += this.runTimeArray[i];
		}
		double meanRunTime = (double) count / this.counter;

		if (this.timeUnit == TimeUnits.Seconds) {
			return meanRunTime / this.secs;
		}
		else if (this.timeUnit == TimeUnits.MilliSeconds) {
			return meanRunTime / this.milliSecs;
		}
		else if (this.timeUnit == TimeUnits.MicroSeconds) {
			return meanRunTime / this.microSecs;
		}
		else {
			return meanRunTime;
		}
	}

	@Override
	public double getAverageMemoryUsage() {
		double count = 0;
		double meanMemoryUsage;

		for (int i = 0; i < this.counter; i++) {
			count += this.memoryArray[i];
		}
		meanMemoryUsage = count / this.counter;

		if (this.memUnit == MemoryUnits.KiloBytes) {
			return meanMemoryUsage / this.kiloB;
		}
		else if (this.memUnit == MemoryUnits.MegaBytes) {
			return meanMemoryUsage / this.megaB;
		}
		// bytes
		return meanMemoryUsage;
	}

}
