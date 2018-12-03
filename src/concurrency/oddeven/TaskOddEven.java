package concurrency.oddeven;

public class TaskOddEven implements Runnable {

	private int max;
	private Printer printer;
	private int start;

	@Override
	public void run() {
		for (int i = start; i < max; i += 2) {
			if (i % 2 == 0) {
				printer.printEven(i);
			} else {
				printer.printOdd(i);
			}
		}
	}

	public TaskOddEven(int max, Printer printer, int start) {
		super();
		this.max = max;
		this.printer = printer;
		this.start = start;
	}

}
