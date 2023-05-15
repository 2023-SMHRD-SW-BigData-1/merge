package Controller;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import JDBC.RecipeDAO;

public class CancelableScanner {
	RecipeDAO rdao = new RecipeDAO();
	Random ran = new Random();
    
    Callable<String> subCallable = new Callable<String>(){
        @Override
        public String call() throws Exception {
        
        
        	
        	
        	
            InputStreamReader inputStreamReader = new InputStreamReader(System.in); 
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            
            System.out.print("\t\t정답 >>  ");
         
            while (!bufferedReader.ready()) {
                
                Thread.sleep(200);
            }

          
            String inputString = bufferedReader.readLine();

        
            return inputString;
        }
    };

    // 응답이 왔을때 값을 받을 FutureTask 타입 객체
    FutureTask<String> futureTask;

    public String readLine() throws Exception {

         futureTask = new FutureTask<>(subCallable);
        // 서브 스레드 선언
        Thread subThread = new Thread(futureTask);
        subThread.start();

        String inputString = futureTask.get();
        return inputString;
    }

    public void cancel(){
        futureTask.cancel(true);
    }
    
}
