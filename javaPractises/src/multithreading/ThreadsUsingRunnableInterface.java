package multithreading;

public class ThreadsUsingRunnableInterface implements Runnable{
	
	String payload;
	
	

	public ThreadsUsingRunnableInterface(String payload) {
		super();
		this.payload = payload;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		
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
