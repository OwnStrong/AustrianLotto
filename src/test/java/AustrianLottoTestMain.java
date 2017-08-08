/*
Author: Own Daghagheleh
Problem statement: Solving Austrian Lotto "6 aus 45" problem, gathered from https://community.topcoder.com/stat?c=problem_statement&pm=1934 on 18/07/2017
Class Description: Test Driver for AustrianLottoTest class
*/
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class AustrianLottoTestMain {
    public static void main(String[] args) {
      Result result = JUnitCore.runClasses(AustrianLottoTest.class);
		
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
      System.out.println(result.wasSuccessful());
   }
}
