package GetBoard;

import org.junit.runner.JUnitCore;

import com.sun.net.httpserver.Authenticator.Failure;
import com.sun.net.httpserver.Authenticator.Result;

public class Getboad_test {
   public static void main(String[] args) {
      org.junit.runner.Result result = JUnitCore.runClasses(getboard.class);
      	for(org.junit.runner.notification.Failure failure : result.getFailures())
      	{
      		System.out.println(failure.toString());
      	}
      	System.out.println("Test result for Acceptance Criteria 1 (get empty board): " + result.wasSuccessful() );
      }
   
   }
