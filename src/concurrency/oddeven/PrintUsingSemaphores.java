package concurrency.oddeven;

import java.util.concurrent.Semaphore;

public class PrintUsingSemaphores {
	public static void main(String[] args) {
		SharedPrinter sp = new SharedPrinter();
		Thread tEven = new Thread(new PrintTask(sp, 100, 0), "even");
		Thread tOdd = new Thread(new PrintTask(sp, 100, 1), "odd");
		tOdd.start();
		tEven.start();
	}
}

class SharedPrinter {

	private Semaphore evenSem = new Semaphore(1);
	private Semaphore oddSem = new Semaphore(0);

	void printEven(int num) {
		try {
			evenSem.acquire();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		System.out.println(Thread.currentThread().getName() + num);
		oddSem.release();
	}

	void printOdd(int num) {
		try {
			oddSem.acquire();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		System.out.println(Thread.currentThread().getName() + num);
		evenSem.release();
	}
}

class PrintTask implements Runnable {

	private SharedPrinter printer;
	private int max;
	private int start;

	@Override
	public void run() {
		for (int i = start; i < max; i += 2) {
			if (start % 2 == 0)
				printer.printEven(i);
			else
				printer.printOdd(i);
		}
	}

	public PrintTask(SharedPrinter printer, int max, int start) {
		super();
		this.printer = printer;
		this.max = max;
		this.start = start;
	}

}