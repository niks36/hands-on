package algorithm;

import java.util.TreeMap;

public class SnapshotArray {

  TreeMap<Integer, Integer>[] map;
  int snapId = 0;

  public SnapshotArray(int length) {
    map = new TreeMap[length];
    for(int i = 0; i<length; i++){
      map[i] = new TreeMap<>();
      map[i].put(0,0);
      }
  }

  public void set(int index, int val) {
      map[index].put(snapId,val);
  }

  public int snap() {
    return snapId++;
  }

  public int get(int index, int snap_id) {
      return map[index].floorEntry(snap_id).getValue();
  }

  public static void main(String[] args) {
    SnapshotArray snapshotArray = new SnapshotArray(10);
    snapshotArray.set(0,1);
    snapshotArray.snap();
    snapshotArray.set(0,2);
    snapshotArray.set(1,3);
    System.out.println(snapshotArray.get(0,0));
    System.out.println(snapshotArray.get(0,1));
    System.out.println(snapshotArray.get(1,0));
    System.out.println(snapshotArray.get(1,1));
  }
}


