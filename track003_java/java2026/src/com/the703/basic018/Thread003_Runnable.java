package com.the703.basic018;

class Animal{ String name;}

class Dog extends Animal implements Runnable{ // #1 extends Thread

	@Override public void run() {	// #2 해야 할 일
		for(int i=0; i<5; i++) {
			System.out.println("멍");
			try { Thread.sleep(1000); }
			catch (InterruptedException e) { e.printStackTrace(); }
		}
	}
}

public class Thread003_Runnable {
	public static void main(String[] args) {
		Thread sound = new Thread(new Dog()); sound.start();
		
		for(int i=0; i<5; i++) {
			System.out.println("◖⚆ᴥ⚆◗");
			try { Thread.sleep(1000); }
			catch (InterruptedException e) { e.printStackTrace(); }
		}
	}
}
