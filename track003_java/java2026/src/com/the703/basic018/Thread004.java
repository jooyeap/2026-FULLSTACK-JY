package com.the703.basic018;

class Candy{
	String name;
	void sell() {
		System.out.println(this.name + "가 1개 팔렸습니다.");
	}
	public Candy(String name) { super(); this.name = name; }
	public Candy() { super(); }
	
}
// ver 1
//class MentolSeller extends Candy implements Runnable{
//
//	@Override
//	public void run() {
//		// 스레드 중단 요청 2)
//		for(int i=0; i<10; i++) {
//			sell();
//			try { Thread.sleep(1000); }
//			catch (InterruptedException e) {
//				System.out.println("판매 중 인터럽트(방해)발생");
//				break;
//			}
//		}
//	}
//
//	public MentolSeller(String name) {
//		super(name);
//	}
//	
//}

class MentolSeller extends Candy implements Runnable{

	@Override public void run() {
		// 스레드 중단 요청 2)
		for(int i=0; i<1000000000; i++) {
			// 1) 중단요청 확인
			if( Thread.currentThread().isInterrupted() ) { // 2) 중단요청 확인
				System.out.println("판매 중단됨");
				break;
			}
			sell();
		}
	}
	public MentolSeller(String name) {
		super(name);
	}
}

public class Thread004 {
	public static void main(String[] args) {
		
		MentolSeller ms = new MentolSeller("멘톨캔디");
//		System.out.println(ms.name);
		Thread th = new Thread(ms);
		th.start();
		
		for(int i=0; i<5; i++) {
			try { Thread.sleep(1000); } catch (InterruptedException e) {  e.printStackTrace(); }
			System.out.println("손님 기다리는 중...");
		}
		System.out.println("손님없음 판매 중단 ㅠㅠ");
		th.interrupt(); // 스레드 중단 요청 1)
		// interrupt() -> Thread.sleep이 무조건 걸려있어야 사용가능
	}
}
