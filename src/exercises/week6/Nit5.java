package exercises.week6;

public class Nit5 {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			final int n = i; // anonymne triedy maju pristup iba k finalnym premennym

			int finalI = i;
			new Thread()  {
					public void run() {
						System.out.println("T" + n + ": " + finalI);
					}

			}.start();
		}
	}
}
