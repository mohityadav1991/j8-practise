package concurrency.pubsub;

public class PubSubRunner {

	private static PubSub pubsub;

	public static void main(String[] args) {
		pubsub = new PubSub();
		Thread sender = new Thread(new Sender(pubsub));
		Thread receiver = new Thread(new Receiver(pubsub));
		sender.start();
		receiver.start();
	}

}
