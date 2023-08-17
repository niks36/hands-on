package lld.log;

import lld.log.subject.LogSubject;

public class Logger {
    //static singleton
  private AbstractLogger chainOfLogger;

  private LogSubject logSubject;

  public Logger getInstacne(){
   // chainOfLogger = LogMamanger.buildchainOfLoggeR();
    // logSubject = LogMamanger.buildLogSubject();
    return null;
  }

  public void display(int level, String message){
    chainOfLogger.logMessage(level, message, logSubject);
  }

}
