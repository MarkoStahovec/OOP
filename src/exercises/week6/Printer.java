package exercises.week6;

public class Printer extends Thread {
	Values val = new Values();
	public void run() {
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			val.print();
		}
	}
}
