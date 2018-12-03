package concurrency.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueRunner {

	public static void main(String[] args) {

		int consumerCount = Runtime.getRuntime().availableProcessors();
		int consumerPerProducers = consumerCount / 10;
		BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);
		// start 10 producers
		for (int i = 0; i < 15; i++) {
			new Thread(new NumberProducer(queue, consumerPerProducers)).start();
		}

		// start 5 consumers
		for (int i = 0; i < consumerCount; i++) {
			new Thread(new NumbersConsumer(queue)).start();
		}
		new Thread(new NumberProducer(queue, consumerPerProducers + consumerCount % 10));
	}

}
