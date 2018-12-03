package concurrency.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class NumberProducer implements Runnable {

	private BlockingQueue<Integer> queue;
	private int stop = Integer.MIN_VALUE;
	private int consumerCount;

	public NumberProducer(BlockingQueue<Integer> queue, int consumerCount) {
		super();
		this.queue = queue;
		this.consumerCount = consumerCount;
	}

	@Override
	public void run() {
		try {
			generateNumbers();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
	}

	private void generateNumbers() throws InterruptedException {
		for (int i = 0; i < 100; i++) {
			queue.put(ThreadLocalRandom.current().nextInt(100));
		}
		for (int j = 0; j < consumerCount; j++) {
			queue.put(stop);
		}
	}

}
