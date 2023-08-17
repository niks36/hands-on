package lld.log.subject;

import java.util.List;
import java.util.Map;

public class LogSubject {

  Map<Integer, List<LogObserver>> map;

  public void addObserver(int level, LogObserver logObserver){

  }

  public void notifyObserver(int level, String message){
    //get obeservs from map vby levlr and call observer.dispaly(meesagr)
  }
}
