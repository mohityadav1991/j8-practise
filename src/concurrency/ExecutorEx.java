package concurrency;

import java.util.concurrent.Executor;

public class ExecutorEx implements Executor {
	@Override
	public void execute(Runnable command) {
		command.run();
	}

	public static void main(String[] args) {
		ExecutorEx executor = new ExecutorEx();
		executor.execute(() -> {
			System.out.println("test");
		});
	}
}
