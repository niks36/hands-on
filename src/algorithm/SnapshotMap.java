package algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SnapshotMap {

  Map<String,TreeMap<Integer, String>> map;
  int snapId = 0;

  public SnapshotMap() {
    map = new HashMap<>();

  }

  public void put(String key, String val) {
      map.putIfAbsent(key, new TreeMap<>());
      map.get(key).put(snapId, val);
  }

  public int snap() {
    return snapId++;
  }

  public String get(String key, int snap_id) {
      return map.get(key).floorEntry(snap_id) != null? map.get(key).floorEntry(snap_id).getValue() : null;
  }

  public static void main(String[] args) {
    SnapshotMap snapshotArray = new SnapshotMap();
    snapshotArray.put("name","niket");
    snapshotArray.snap();
    snapshotArray.put("name","punit");
    snapshotArray.put("add","abad");
    System.out.println(snapshotArray.get("name",0));
    System.out.println(snapshotArray.get("name",1));
    System.out.println(snapshotArray.get("add",0));
    System.out.println(snapshotArray.get("add",1));
  }
}


