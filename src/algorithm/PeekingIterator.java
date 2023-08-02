package algorithm;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer>{

  Integer next = null;
  Iterator<Integer> peekingIterator = null;
  public PeekingIterator(Iterator<Integer> iterator) {
    // initialize any member here.
    peekingIterator = iterator;
    if(peekingIterator.hasNext())
      next = peekingIterator.next();

  }

  // Returns the next element in the iteration without advancing the iterator.
  public Integer peek() {
    return next;
  }

  // hasNext() and next() should behave the same as in the Iterator interface.
  // Override them if needed.
  @Override
  public Integer next() {
    Integer returnVal = next;
    if (peekingIterator.hasNext()) {
      next = peekingIterator.next();
    }else{
      next = null;
    }
    return returnVal;
  }

  @Override
  public boolean hasNext() {
    return next != null;
  }
}
