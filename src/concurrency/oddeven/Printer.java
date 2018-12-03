package concurrency.oddeven;

public class Printer {

	private boolean isOdd;

	public synchronized void printOdd(int num) {
		while (!isOdd) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " : " + num);
		isOdd = false;
		notify();
	}

	public synchronized void printEven(int num) {
		while (isOdd) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " : " + num);
		isOdd = true;
		notify();
	}
}
