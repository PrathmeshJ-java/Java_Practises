package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableTestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
    List<String> tasksList = new ArrayList<>();
		
		tasksList.add("One");
		tasksList.add("Two");
		tasksList.add("Three");
		tasksList.add("Four");
		tasksList.add("Five");
		tasksList.add("Six");
		tasksList.add("Seven");
		tasksList.add("Eight");
		tasksList.add("Nine");
		tasksList.add("Ten");
		
		int threadPoolSize = 4;
		
		ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);
		
		System.out.println("Starting Main Threads -"+Thread.currentThread().getName()+" - "+Thread.currentThread().getPriority());
		
		for(String payload : tasksList) {
			executorService.submit(new Thread(new ThreadsUsingRunnableInterface(payload)));
		}
        
//		Thread t = new ThreadsUsingThreadsClass(null);
//		t.start();
		
		executorService.shutdown();
		
		
		System.out.println("Existing Main Threads -"+Thread.currentThread().getName()+" - "+Thread.currentThread().getPriority());
		

	}

}
