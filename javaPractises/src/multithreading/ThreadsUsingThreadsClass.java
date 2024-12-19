package multithreading;

public class ThreadsUsingThreadsClass extends Thread{
	
	String payload;
	
	
	
	public ThreadsUsingThreadsClass(String payload) {
		super();
		this.payload = payload;
	}



	public void run() {
		System.out.println("Starting Threads -"+Thread.currentThread().getName());
		
		System.out.println("Processing Threads -"+Thread.currentThread().getName()+" "+payload+" length is : "+payload.length());
		
		try {
			Thread.sleep(500);
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.println("Existing Threads -"+Thread.currentThread().getName());
	}

}
