package concurrency.oddeven;

public class OddEvenRunner {
	private static Printer printer;
	
	public static void main(String[] args) {
		printer = new Printer();
		Thread t1 = new Thread(new TaskOddEven(10,printer, 0), "even");
		Thread t2 = new Thread(new TaskOddEven(10,printer,1), "odd");
		t2.start();
		t1.start();

	}
}
