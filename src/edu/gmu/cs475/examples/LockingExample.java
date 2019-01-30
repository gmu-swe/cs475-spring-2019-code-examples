package edu.gmu.cs475.examples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockingExample {
	static int count;
	public static void main(String[] args) {
		final Lock lock = new ReentrantLock();
		final Lock lock2 = new ReentrantLock();
		final ExecutorService executor = Executors.newFixedThreadPool(20);
		for (int i = 0; i < 100; i++) {
			executor.submit(() -> {
				lock.lock();
				try {
					int tmp = count;
					tmp = tmp + 1;
					count = tmp;
					return null;
				} finally{
					lock.unlock();
				}
			});
		}
		executor.shutdown();
		try {
			executor.awaitTermination(100, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			//uh oh
		}
		System.out.println("Final count: " + count);
	}
}
