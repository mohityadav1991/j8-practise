package concurrency.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class NumbersConsumer implements Runnable {

	private BlockingQueue<Integer> queue;
	private final int stop = Integer.MIN_VALUE;

	public NumbersConsumer(BlockingQueue<Integer> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			while (true) {
				Integer num = queue.take();
				if(num == stop) {
					return;
				}
				System.out.println(Thread.currentThread().getName() + " : result : "+ num);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
	}

}
