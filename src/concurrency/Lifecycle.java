package concurrency;

public class Lifecycle implements Runnable {
	public static Thread t3;
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread(new DemoThreadB()); // NEW State
		System.out.println("State t1: " + t1.getState());
		Thread t2 = new Thread(new DemoThreadB()); // NEW State
		t1.start(); // RUNNABLE STATE
		t2.start(); // RUNNABLE STATE

		Thread.sleep(1000);
		System.out.println("State t2: " + t2.getState());

		t3 = new Thread(new Lifecycle());
		t3.start();
		
		Thread t4 = new Thread(new DemoThreadWT());
		t4.start();
		Thread.sleep(1000);
		System.out.println("State t4: " + t4.getState());
		
		Thread t5 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
		t5.start();
		Thread.sleep(1000);
		System.out.println("State t5: " + t5.getState());
		
	}

	@Override
	public void run() {
		Thread tW = new Thread(new DemoThreadW());
		tW.start();
		try {
			tW.join();
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
			System.out.println("Thread Interrupted : " + ex);
		}
	}
}

class DemoThreadB implements Runnable {

	@Override
	public void run() {
		commonResource();
	}

	public static synchronized void commonResource() {
		while (true) {

		}
	}

}

class DemoThreadWT implements Runnable {
	@Override
	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
			System.out.println("Thread Interrupted : " + ex);
		}
	}
}

class DemoThreadW implements Runnable {
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
			System.out.println("Thread Interrupted : " + ex);
		}
		System.out.println("State t3 : " + Lifecycle.t3.getState()); // WAITING STATE since this is waiting for tW to finish execution.
	}
}
