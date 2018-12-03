package concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierEx {
	public static void main(String[] args) throws InterruptedException {
		CyclicBarrier barrier = new CyclicBarrier(3, () ->  {
			System.out.println("Runnable Inside barrier");
		});
		Thread t1 = new Thread(new BarrierTask(barrier));
		Thread t2 = new Thread(new BarrierTask(barrier));
		Thread t3 = new Thread(new BarrierTask(barrier));
		
		if(!barrier.isBroken()) {
			t1.start();
			t2.start();
			t3.start();
		}
	}
}

class BarrierTask implements Runnable {

	private CyclicBarrier barrier;

	public BarrierTask(CyclicBarrier barrier) {
		super();
		this.barrier = barrier;
	}

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " : barrier await");
			barrier.await();
			System.out.println(Thread.currentThread().getName() + " : barrier passed");
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}

	}

}
