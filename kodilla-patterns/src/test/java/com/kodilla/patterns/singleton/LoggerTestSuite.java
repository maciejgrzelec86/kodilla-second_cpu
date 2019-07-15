package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {

   @Test
    public void testLog() {
    //Given
    Logger loggerInstance = Logger.getInstance();
    //When
    loggerInstance.log("first log");
    String testLog = loggerInstance.getLastLog();
    //Then
    Assert.assertEquals("first log", testLog);
   }
}
