package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceEx {
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(10);
		service.submit(new Task());
	}
}

class Task implements Runnable {

	@Override
	public void run() {
		System.out.println("Runnable Task");
	}
	
}
