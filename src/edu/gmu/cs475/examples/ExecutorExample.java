package edu.gmu.cs475.examples;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorExample {
	public static void main(String[] args) {
		final ExecutorService executor = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 100; i++) {
			final boolean shoudlSleep = (i % 2) == 0;
			executor.submit(() -> {
				System.out.println("Hello from my task, running in thread" + Thread.currentThread());
				try {
					if(shoudlSleep)
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
			});
		}
		executor.shutdown();
		try {
			executor.awaitTermination(100, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			//uh oh
		}
	}
}
