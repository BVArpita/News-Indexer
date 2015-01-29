package edu.buffalo.cse.irf14.index;
//tutorials point @reference : http://www.tutorialspoint.com/javaexamples/thread_procon.htm

public class TokenIndexerThread {
	
		   public static void main(String[] args) {
		      CubbyHole c = new CubbyHole();
		      Producer p1 = new Producer(c, 1);
		      Consumer c1 = new Consumer(c, 1);
		      p1.start(); 
		      c1.start();
		   }
		}
class CubbyHole {
		   private int contents;
		   private boolean available = false;
		   public synchronized int Index() {
		      while (available == false) {
		         try {
		            wait();
		         }
		         catch (InterruptedException e) {
		         }
		      }
		      available = false;
		      notifyAll();
		      return contents;
		   }
		   public synchronized void Tokenize(int value) {
		      while (available == true) {
		         try {
		            wait();
		         }
		         catch (InterruptedException e) { 
		         } 
		      }
		      contents = value;
		      available = true;
		      notifyAll();
		   }
		}

		class Consumer extends Thread {
		   private CubbyHole cubbyhole;
		   private int number;
		   public Consumer(CubbyHole c, int number) {
		      cubbyhole = c;
		      this.number = number;
		   }
		   public void run() {
		      int value = 0;
		         for (int i = 0; i < 10; i++) {
		            value = cubbyhole.Index();
		            System.out.println("Consumer #" 
					+ this.number
		+ " got: " + value);
		}
		}
		}

		class Producer extends Thread {
		private CubbyHole cubbyhole;
		private int number;

		public Producer(CubbyHole c, int number) {
		cubbyhole = c;
		this.number = number;
		}

		public void run() {
		for (int i = 0; i < 10; i++) {
		cubbyhole.Tokenize(i);
		System.out.println("Producer #" + this.number
		+ " put: " + i);
		try {
		sleep((int)(Math.random() * 100));
		} catch (InterruptedException e) { }
		}
		}
		}

