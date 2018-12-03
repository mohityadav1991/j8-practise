package concurrency.pubsub;

import java.util.concurrent.ThreadLocalRandom;

public class Receiver implements Runnable {

	private PubSub pubSub;

	public Receiver(PubSub pubSub) {
		super();
		this.pubSub = pubSub;
	}

	@Override
	public void run() {
		for (String msg = pubSub.receive(); !msg.equals("end"); msg = pubSub.receive()) {
			System.out.println(msg);
		}
		try {
			Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
			System.out.println(ex.getMessage());
		}
	}

}
