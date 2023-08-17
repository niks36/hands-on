package lld.log;

import lld.log.subject.LogSubject;

public abstract  class AbstractLogger {

  int level;
  AbstractLogger nextLogger;
  public void next(AbstractLogger abstractLogger){
    nextLogger = abstractLogger;
  }
  public void logMessage(int level, String message, LogSubject subject){
    if(this.level == level){
      display(message,subject);
    }else{
      nextLogger.logMessage(level,message,subject);
    }
  }

  protected abstract void display(String message, LogSubject subject);

}
