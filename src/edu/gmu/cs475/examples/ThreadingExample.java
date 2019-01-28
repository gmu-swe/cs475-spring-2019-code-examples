package edu.gmu.cs475.examples;

public class ThreadingExample {

	static boolean otherThreadHasPrinted = false;
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				//This code will now run in a new thread
				System.out.println("Hello from " + Thread.currentThread());
				otherThreadHasPrinted = true;
			}
		});
		t.start();
		while(!otherThreadHasPrinted)
		{
			//wait
		}
		System.out.println("Hello from " + Thread.currentThread());
		t.join();
	}

}
