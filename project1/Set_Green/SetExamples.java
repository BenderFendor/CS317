import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetExamples {

  public static void main(String[] args) {
    Set<Integer> numbers = new HashSet<Integer>();
    Set<String> names = new HashSet<String>();

    Set<String> linkedNames = new LinkedHashSet<String>();

    Set<String> treeNames = new TreeSet<String>();

    List<Integer> listNumbers = Arrays.asList(3, 9, 1, 4, 7, 2, 5, 3, 8, 9, 1, 3, 8, 6);
    System.out.println(listNumbers);
    Set<Integer> uniqueNumbers = new HashSet<Integer>(listNumbers);
    System.out.println(uniqueNumbers);

    names.add("Tom");
    names.add("Mary");

    if (names.add("Peter")) {
      System.out.println("Peter is added to the set");
    }

    if (!names.add("Tom")) {
      System.out.println("Tom is already added to the set");
    }

    names.add(null);

    if (names.remove("Mary")) {
      System.out.println("Marry is removed");
    }

    if (names.isEmpty()) {
      System.out.println("The set is empty");
    } else {
      System.out.println("The set is not empty");
    }

    names.clear();

    if (names.isEmpty()) {
      System.out.println("The set is empty");
    }

    names.add("Tom");
    names.add("Mary");
    names.add("Peter");
    names.add("Alice");

    System.out.printf("The set has %d elements", names.size());
    System.out.println();

    Iterator<String> iterator = names.iterator();
    while (iterator.hasNext()) {
      String name = iterator.next();
      System.out.println(name);
    }

    for (String name : names) {
      System.out.println(name);
    }

    names.forEach(System.out::println);

    if (names.contains("Mary")) {
      System.out.println("Found Mary");
    }

    Set<Integer> s1 = new HashSet<Integer>(Arrays.asList(20, 56, 89, 31, 8, 5));
    Set<Integer> s2 = new HashSet<Integer>(Arrays.asList(8, 89));

    if (s1.containsAll(s2)) {
      System.out.println("s2 is a subset of s1");
    }

    Set<Integer> s3 = new HashSet<Integer>(Arrays.asList(1, 3, 5, 7, 9));
    Set<Integer> s4 = new HashSet<Integer>(Arrays.asList(2, 4, 6, 8));

    System.out.println("s1 before union: " + s3);
    s3.addAll(s4);
    System.out.println("s1 after union: " + s3);

    Set<Integer> s5 = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 7, 9));
    Set<Integer> s6 = new HashSet<Integer>(Arrays.asList(2, 4, 6, 8));

    System.out.println("s1 before intersection: " + s5);
    s5.retainAll(s6);
    System.out.println("s1 after intersection: " + s5);

    Set<Integer> s7 = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 7, 9));
    Set<Integer> s8 = new HashSet<Integer>(Arrays.asList(2, 4, 6, 8));

    System.out.println("s1 before difference: " + s7);
    s7.removeAll(s8);
    System.out.println("s1 after difference: " + s7);

    TreeSet<String> tree_set = new TreeSet<String>();
    tree_set.add("G");
    tree_set.add("E");
    tree_set.add("E");
    tree_set.add("K");
    tree_set.add("S");
    tree_set.add("4");

    System.out.println("Tree Set values are: " + tree_set);

    Comparator comp = tree_set.comparator();

    System.out.println("Since the Comparator value is: " + comp);
    System.out.println("it follows natural ordering");

    TreeSet<String> tree_set1 = new TreeSet<String>(new Helper());

    tree_set1.add("G");
    tree_set1.add("E");
    tree_set1.add("E");
    tree_set1.add("K");
    tree_set1.add("S");
    tree_set1.add("4");

    System.out.println("The elements sorted in descending order:" + tree_set1);
  }

  static class Helper implements Comparator<String> {
    public int compare(String str1, String str2) {
      String first_Str;
      String second_Str;
      first_Str = str1;
      second_Str = str2;
      return second_Str.compareTo(first_Str);
    }
  }
}
