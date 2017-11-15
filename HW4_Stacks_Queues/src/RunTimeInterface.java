
/**
 * 
 * This interface will be used to organize and manage runtimes that are measured for specific operations.
 * In addition, memory usage is also captured and maintained every time the user adds a new run time.
 * 
 * The user will utilze <code>System.nanoTime()</code> to measure the runtime of an operation.
 * 
 * <p>Before the operation is started, you can obtain the start time:
 * <br>
 * <code>startTime = System.nanoTime()</code>.</p>
 * 
 * <p>After the operation is completed, you can obtain the end time:
 * <br>
 * <code>endTime = System.nanoTime()</code>.</p>
 * 
 * <p>Run Time is then:
 * <br>
 * <code>runTime = endTime - startTime</code>. </p>
 * 
 * @author Sameh A. Fakhouri
 *
 */
public interface RunTimeInterface {

	

	/**
	 * 
	 * Run times are measured in Nano Seconds. This enum will be used to specify what units of time the user
	 * wishes to obtain the run times when calling {@link #getLastRunTime()}, {@link #getRunTimes()}, and
	 * {@link #getAverageRunTime()}.
	 * 
	 * <ol>
	 * <li>Seconds 		- Return run times in seconds.</li>
	 * <li>MilliSeconds	- Return run times in milli-seconds.</li>
	 * <li>MicroSeconds - Return run times in micro-seconds.</li>
	 * <li>NanoSeconds 	- Return run times in nano-seconds.</li>
	 * </ol>
	 *
	 * See also {@link #getTimeUnits()} and {@link #setTimeUnits(TimeUnits timeUnits)}.
	 *
	 */
	public static enum TimeUnits {Seconds, MilliSeconds, MicroSeconds, NanoSeconds};

	

	/**
	 * 
	 * Memory usage is measured in Bytes. This enum will be used to specify what units of bytes the user
	 * wishes to obtain the memory usage when calling {@link #getLastMemoryUsage()}, {@link #getMemoryUsages()}, and
	 * {@link #getAverageMemoryUsage()}.
	 * 
	 * <ol>
	 * <li>Bytes 		- Return memory usage in bytes.</li>
	 * <li>KiloBytes	- Return memory usage in kilo-bytes.</li>
	 * <li>MegaBytes	- Return memory usage in mega-bytes.</li>
	 * </ol>
	 *
	 * See also {@link #getMemoryUnits()} and {@link #setMemoryUnits(MemoryUnits memoryUnits)}.
	 *
	 */
	public static enum MemoryUnits {Bytes, KiloBytes, MegaBytes};
	
	
	
	/**
	 * 
	 * This method is used to obtain the current {@link TimeUnits} configured for the <code>RunTime</code>
	 * class. Please note that the default <code>TimeUnits</code> is <code>NanoSeconds</code>
	 * 
	 * @return The currently configured <code>TimeUnits</code>.
	 * 
	 */
	
	public TimeUnits getTimeUnits();
	
	
	
	/**
	 * 
	 * This method is used to configure the desired {@link TimeUnits}.
	 * 
	 * @param timeUnits The desired <code>TimeUnits</code>
	 * 
	 */
	public void setTimeUnits(TimeUnits timeUnits);
	
	
	
	/**
	 * 
	 * This method is used to obtain the current {@link MemoryUnits} configured for the <code>RunTime</code>
	 * class. Please note that the default <code>MemoryUnits</code> is <code>Bytes</code>
	 * 
	 * @return The currently configured <code>MemoryUnits</code>.
	 * 
	 */
	public MemoryUnits getMemoryUnits();
	
	
	
	/**
	 * 
	 * This method is used to configure the desired {@link MemoryUnits}.
	 * 
	 * @param memoryUnits The desired <code>MemoryUnits</code>
	 * 
	 */
	public void setMemoryUnits(MemoryUnits memoryUnits);
	
	
	/**
	 * 
	 * This method is used to retrieve the last runtime. If no runtime
	 * has been added, the method will return a zero.
	 * 
	 * @return The last runtime, in nanoseconds, or zero.
	 *  
	 */
	public double getLastRunTime();
	
	
	
	/**
	 * 
	 * This method is used to retrieve the last runtime. If no runtime
	 * has been added, the method will return a zero.
	 * 
	 * @return The last runtime, converted to the configured {@link TimeUnits},
	 * or 0.0.
	 *  
	 */
	public double getLastMemoryUsage();
	
	
	
	/**
	 * 
	 * This method returns an array of <b>double</b> values representing the last 10 runtimes
	 * converted to the configured {@link TimeUnits}.If less than 10 runtimes are available, 
	 * the remaining runtimes should be zero. If more than 10 runtimes have been added, the array
	 * should contain the last 10 runtimes. 
	 * 
	 * @return An array of <b>double</b> values representing the last 10 runtimes.
	 * 
	 */
	public double[] getRunTimes();
	
	
	
	/**
	 * 
	 * This method returns an array of <b>double</b> values representing the last 10 memory usages
	 * converted to the configured {@link MemoryUnits}. 
	 * If less than 10 memory usages are available, the remaining
	 * memory usages should be zero. If more than 10 memory usages have been added, the array
	 * should contain the last 10 memory usages. 
	 * 
	 * @return An array of <b>double</b> values representing the last 10 memory usages.
	 * 
	 */
	public double[] getMemoryUsages();

	
	
	/**
	 * 
	 * This method is used to reset all 10 linear search times to zero.
	 * 
	 */
	public void resetRunTimes();

	
	
	/**
	 * 
	 * This method is used to add a runtime and capture the current memory usage.
	 * 
	 * @param runTime a <b>long</b> value representing the runtime in nanoseconds.
	 * 
	 */
	public void addRuntime(long runTime);
	
	
	
	/**
	 * 
	 * This method is used to obtain the average runtime. The method should average all
	 * the non-zero runtimes that are available. If no runtimes are available, the method
	 * returns a zero.
	 * 
	 * @return A <b>double</b> value representing the average of all the non-zero runtimes, or zero.
	 * 
	 */
	public double getAverageRunTime();
	
	
	
	/**
	 * 
	 * This method is used to obtain the average memory usage. The method should average all
	 * the non-zero memory usages that are available. If no memory usages are available, the method
	 * returns a zero.
	 * 
	 * @return A <b>double</b> value representing the average of all the non-zero memory usages, or zero.
	 * 
	 */
	public double getAverageMemoryUsage();
	
}
