package algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlattenList {

  class NestedIterator implements Iterator<Integer> {

    List<Integer> list;
    int current = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
      list = new ArrayList<>();
      for(NestedInteger nestedInteger : nestedList){
        helper(nestedInteger);
      }
    }

    private void helper(NestedInteger nestedInteger) {
      if(nestedInteger.isInteger()){
        list.add(nestedInteger.getInteger());
      }else{
        for(NestedInteger nested : nestedInteger.getList()){
          helper(nested);
        }
      }
    }

    @Override
    public Integer next() {
     return list.get(current++);

    }

    @Override
    public boolean hasNext() {
      return current < list.size();
    }
  }

  public interface NestedInteger {
    public boolean isInteger();

    public Integer getInteger();

    public List<NestedInteger> getList();
  }
}
