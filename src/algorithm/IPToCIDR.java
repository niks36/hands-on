package algorithm;

import java.util.ArrayList;
import java.util.List;

public class IPToCIDR {

  public static void main(String[] args) {
    //
    IPToCIDR ipToCIDR = new IPToCIDR();
    List<String> strings = ipToCIDR.ipToCIDR("255.0.0.7", 10);
    System.out.println(strings);
  }

  public List<String> ipToCIDR(String ip, int n) {
    List<String> res = new ArrayList<>();
    long start = ipToLong(ip);
    long end = start + n -1;

    while (start <= end){
      long locOfFirstOne = start & (-start);

      int mask1 = 32 - (int) (Math.log(locOfFirstOne) / Math.log(2));
      int mask2 = 32 - (int) Math.floor(Math.log(end - start + 1) / Math.log(2));

      mask1 = Math.max(mask1,mask2);

      String ip1 = longToIP(start);
      res.add(ip1 + "/" + mask1);

      start += Math.pow(2, 32-mask1);

    }
    System.out.println(start);

    return res;
  }

  private long ipToLong(String ip) {
    String[] parts = ip.split("\\.");
    long res = 0;
    int offset = 0;

    for(int i = parts.length-1; i >= 0; i--){
      res += Long.parseLong(parts[i]) << offset;
      offset += 8;
    }
    return res;
  }

  private String longToIP(long longIP) {
    StringBuffer sb = new StringBuffer("");
    sb.append(longIP >>> 24);
    sb.append(".");
    sb.append((longIP & 0x00FFFFFF) >>> 16);
    sb.append(".");
    sb.append((longIP & 0x0000FFFF) >>> 8);
    sb.append(".");
    sb.append(longIP & 0x000000FF);

    return sb.toString();
  }

}
