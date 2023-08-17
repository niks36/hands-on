package lld.log;

import lld.log.subject.LogSubject;

public class InfoLogger extends AbstractLogger {

  public InfoLogger(int level) {
    this.level = level;
  }

  @Override
  protected void display(String message, LogSubject logSubject) {
    System.out.println("info  "+ message);
    logSubject.notifyObserver(level, message);
  }
}
