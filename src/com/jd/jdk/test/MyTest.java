package com.jd.jdk.test;

public class MyTest {
	
	public static void main(String[] args) {
		final Object lock = new Object();
		final Object obj = new Object();
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				synchronized (lock) {
					try {
						Thread.sleep(1000l);
						Thread.currentThread().yield();
						System.out.println(Thread.currentThread().getName()+"--"+Thread.currentThread().getState());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				synchronized (lock) {
					try {
						System.out.println(Thread.currentThread().getName()+"--"+Thread.currentThread().getState());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			
		});
		try {
			t1.start();
			Thread.sleep(100l);
			t2.start();
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			for(int i=0;i<100;i++){
				System.out.println(t1.getName()+"--"+t1.getState());
				System.out.println(t2.getName()+"--"+t2.getState());
				Thread.sleep(50l);
			}
			
			Thread.sleep(100000l);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
