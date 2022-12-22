package primes;

import java.util.HashSet;
import java.util.Set;

public class ThreadedCountPrimes implements Runnable {
	private long min;
	private long max;
	private long primescount;
	
	
	public ThreadedCountPrimes(long min, long max) {
		this.min = min;
		this.max = max;
		this.primescount=0;
	}

	@Override
	public void run() {
		for(long i=this.min;i<this.max;i++) {
			if(CountPrimes.isPrime(i))
				this.primescount++;
		}
	}
	public long getPrimesCount() {
		return primescount;
	}
	
	public static void main(String[] args) {

		long min = 10_000_000;
		long max = 20_000_000;
		
		long startTime = System.currentTimeMillis();
		long numPrimes = CountPrimes.numPrimes(min, max);

		long endTime = System.currentTimeMillis();
		System.out.println("number of primes from "+ min + " to " + max + " is " + numPrimes);
		System.out.println("this took  " + (endTime - startTime) + " ms ");
		//System.exit(0);
		numPrimes = 0;
		Set<Thread> threadSet = new HashSet<Thread>();
		Set<ThreadedCountPrimes> primesSet = new HashSet<ThreadedCountPrimes>();
		
		startTime = System.currentTimeMillis();

		/* you're going to start a bunch of threads, and you want them
		 * all to complete and get the total number of primes within
		 * the interval min, max when the threads are complete.
		 * 
		 * Figure this out. Specifically, figure out how to wait until
		 * a bunch of threads finish until continuing your code
		 */
		int numThreads=100; //Number of threads
		long currMin=min;
		long interval=(max-min)/numThreads;
		for(int i=0;i<numThreads;i++) {
			long currMax=currMin+interval;
			if(i==numThreads-1) // increase currMax by 1 to incorporate the upper bound for final thread
				currMax++;
			ThreadedCountPrimes tcp=new ThreadedCountPrimes(currMin,currMax);
			primesSet.add(tcp);
			threadSet.add(new Thread(tcp));
			currMin=currMax;
		}
		for (Thread t : threadSet) {
			t.start();
		}
		// wait until a bunch of threads finish
		for (Thread t : threadSet) {
			try {
				t.join();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//combined the results of each thread 
		for(ThreadedCountPrimes tcp:primesSet) {
			numPrimes+=tcp.getPrimesCount();
		}
		endTime = System.currentTimeMillis();
		System.out.println("Threaded: number of primes from "+ min + " to " + max + " is " + numPrimes);
		System.out.println("this took  " + (endTime - startTime) + " ms ");
	}
}
