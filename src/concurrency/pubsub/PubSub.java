package concurrency.pubsub;

public class PubSub {

	private String packet;
	private boolean transfer = true;

	public synchronized void send(String packet) {
		while (!transfer) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
		this.transfer = false;
		this.packet = packet;
		notifyAll();
	}

	public synchronized String receive() {
		while (transfer) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
		this.transfer = true;
		notifyAll();
		return packet;
	}
}
