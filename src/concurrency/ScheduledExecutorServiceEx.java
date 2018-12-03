package concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceEx {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		execute();
	}
	
	public static void execute() throws InterruptedException, ExecutionException {
		ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		Future<String> result = executorService.schedule(()->{
			return "Hello World";
		},1,TimeUnit.SECONDS);
		if(result.isDone() && !result.isCancelled()) {
			try {
				System.out.println(result.get());
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		executorService.shutdown();
	}
}
