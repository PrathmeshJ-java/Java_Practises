package threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.security.sasl.RealmCallback;

public class futureExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Callable<String> task = ()->{
			Thread.sleep(2000);
			return "42";
		};
		
		Runnable task2 = () -> {
		    System.out.println("Executing another task...");
		};
		executorService.submit(task2);
		
		Future<String> future = executorService.submit(task);
		
		try {
			System.out.println("Doing some other works .....");
			Integer result = Integer.parseInt(future.get());
			System.out.println("Result from the task: " + result);
		}catch (InterruptedException | ExecutionException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}finally {
			executorService.shutdown();
		}
	}

}
