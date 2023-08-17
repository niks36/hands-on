package tesco.shiftInterval.model;

public class Shift {

  Integer start;
  Integer end;

  public Integer getStart() {
    return start;
  }

  public Integer getEnd() {
    return end;
  }

  public Shift(Integer start, Integer end) {
    this.start = start;
    this.end = end;
  }

  @Override
  public String toString() {
    return "Shift{" +
        "start=" + start +
        ", end=" + end +
        '}';
  }
}
