package edu.gmu.cs475.examples;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;

public class SynchronizedExample {
	static int i;
	int j;
	public static synchronized void increment()
	{
		i = i + 1;
	}

	public HashMap monitor = new HashMap();
	public synchronized  void incrementOther()
	{
		j = j + 1;
	}

//	public void incrementOtherNotSynchronizedButSame(){
//		theLock.lock();
//		try{
//			j= j + 1;
//		}finally{
//			theLock.unlock();
//		}
//
//	}
//	Lock theLock;
	public static void main(String[] args) {


	}
}
