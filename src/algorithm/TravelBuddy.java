package algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TravelBuddy {

  private List<Buddy> buddies;
  private Set<String> myWishList;

  public static void main(String[] args) {
    //
  }

  public TravelBuddy(Set<String> myWishList, Map<String, Set<String>> friendsWishList) {
    this.buddies = new ArrayList<>();
    for (Entry<String, Set<String>> entry : friendsWishList.entrySet()) {
      Set<String> friendWishList = entry.getValue();
      Set<String> intersection = new HashSet<>(friendWishList);
      intersection.retainAll(myWishList);
      if (intersection.size() >= (myWishList.size() / 2)) {
        buddies.add(new Buddy(entry.getKey(), intersection.size(), entry.getValue()));
      }
    }
  }

  public List<Buddy> getSortedBuddies() {
    buddies.sort(Comparator.comparingInt(Buddy::getSimilarity).reversed());
    return buddies;
  }

  public List<String> recommendCities(int k) {
    List<String> result = new ArrayList<>();

    for (Buddy buddy : getSortedBuddies()) {
      Set<String> set = new HashSet<>(buddy.wishList);
      set.removeAll(myWishList);

      if (set.size() >= k) {
        result.addAll(set.stream().limit(k).toList());
        break;
      } else {
        result.addAll(set);
        k -= set.size();
      }
    }
    return result;
  }

  class Buddy {
    String name;
    Integer similarity;
    Set<String> wishList;

    public Integer getSimilarity() {
      return similarity;
    }

    public Buddy(String name, Integer similarity, Set<String> wishList) {
      this.name = name;
      this.similarity = similarity;
      this.wishList = wishList;
    }
  }
}
