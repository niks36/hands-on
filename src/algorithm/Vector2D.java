package algorithm;

public class Vector2D {

  public static void main(String[] args) {
    //
    Vector2D vector2D = new Vector2D(new int[][] {{}, {3,4,5,6,7}, {8,9, 10}, {11}});
    System.out.println(vector2D.next());
    System.out.println(vector2D.hasNext());
    System.out.println(vector2D.hasNext());
    System.out.println(vector2D.next());
    System.out.println(vector2D.hasNext());
    System.out.println(vector2D.next());
    System.out.println(vector2D.hasNext());
    System.out.println(vector2D.next());
    System.out.println(vector2D.hasNext());
    System.out.println(vector2D.next());
    System.out.println(vector2D.hasNext());
    System.out.println(vector2D.next());
    System.out.println(vector2D.hasNext());
    System.out.println(vector2D.next());
    System.out.println(vector2D.hasNext());
    System.out.println(vector2D.next());
    System.out.println(vector2D.hasNext());
    System.out.println(vector2D.next());
    System.out.println(vector2D.hasNext());
    System.out.println(vector2D.next());
    System.out.println(vector2D.hasNext());
    System.out.println(vector2D.hasNext());
   // System.out.println(vector2D.next());
    System.out.println(vector2D.hasNext());
  }

  int[][] arr;
  int rowIndex;
  int index;

  Vector2D(int[][] v) {
    index = 0;
    rowIndex = 0;
    arr = v;
  }

  public int next() {
   // System.out.println("RowIndex " + rowIndex);
    if (rowIndex >= arr.length) return -1;

    if (index < arr[rowIndex].length) {
      int val = arr[rowIndex][index];
      index++;
      return val;
    } else {
      rowIndex++;
      index = 0;
      return next();
    }

    // return  -1;

  }

  public boolean hasNext() {
    int j = rowIndex;
    int i = index;
    return checkNext(j,i);
  }

  public boolean checkNext(int j, int i){
    if (j >= arr.length) return false;
    if(i < arr[j].length) return true;
    return checkNext(++j, 0);
  }
}
