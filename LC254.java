package fakru.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC254 {

  public static void main(String[] args) {
    LC254Demo demo = new LC254Demo();
    List<List<Integer>> result = demo.getFactors(12);
    result.forEach(System.out::println);
  }
}

class LC254Demo {

  public List<List<Integer>> getFactors(int n) {
    List<List<Integer>> result = new ArrayList<>();
    helper(result, new ArrayList<>(), n, 2);
    return result;
  }

  void helper(List<List<Integer>> result, List<Integer> item, int n, int start) {
    if (n <= 1) {
      if (item.size() > 1) {
        result.add(new ArrayList<>(item));
      }
      return;
    }

    for (int i = start; i <= n; ++i) {
      if (n % i == 0) {
        item.add(i);
        helper(result, item, n / i, i);
        item.remove(item.size() - 1);
      }
    }
  }
}