package concurrency.pubsub;

import java.util.concurrent.ThreadLocalRandom;

public class Sender implements Runnable {

	private PubSub pubsub;

	public Sender(PubSub pubsub) {
		super();
		this.pubsub = pubsub;
	}

	@Override
	public void run() {
		String[] msges = { "1", "2", "3", "4", "end" };
		for (String msg : msges) {
			pubsub.send(msg);
		}
		try {
			Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
	}
}
