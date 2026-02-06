import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListBasics {

  public static void main(String[] args) {
    List<Object> listAnything = new ArrayList<Object>();
    List<String> listWords = new ArrayList<String>();
    List<Integer> listNumbers = new ArrayList<Integer>();
    List<String> linkedWords = new LinkedList<String>();

    List<Integer> listNumberOne = new ArrayList<Integer>();
    List<Integer> listNumberTwo = new ArrayList<Integer>(listNumberOne);

    List<String> listStrings = new ArrayList<String>();
    listStrings.add("One");
    listStrings.add("Two");
    listStrings.add("Three");
    listStrings.add(1, "Four");
    listStrings.addAll(listWords);

    List<Number> linkedNumbers = new LinkedList<Number>();
    linkedNumbers.add(new Integer(123));
    linkedNumbers.add(new Float(3.1415));
    linkedNumbers.add(new Double(299.988));
    linkedNumbers.add(new Long(67000));

    String element = listStrings.get(1);
    Number number = linkedNumbers.get(3);

    LinkedList<Number> numbers = new LinkedList<Number>();
    numbers.add(new Integer(100));
    numbers.add(new Integer(200));
    Number first = numbers.getFirst();
    Number last = numbers.getLast();

    listStrings.set(2, "Hi");

    listStrings.remove(2);
    listStrings.remove("Two");

    if (listStrings.remove("Ten")) {
      System.out.println("Removed");
    } else {
      System.out.println("There is no such element");
    }

    listStrings.clear();

    for (String elem : listStrings) {
      System.out.println(elem);
    }

    Iterator<String> iterator = listStrings.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }

    Iterator<Number> listIterator = linkedNumbers.listIterator();
    while (listIterator.hasNext()) {
      System.out.println(listIterator.next());
    }

    listStrings.forEach(s -> System.out.println(s));

    if (listStrings.contains("Hello")) {
      System.out.println("Found the element");
    } else {
      System.out.println("There is no such element");
    }

    int firstIndex = linkedNumbers.indexOf(1234);
    int lastIndex = listStrings.lastIndexOf("Hello");

    listStrings.add("D");
    listStrings.add("C");
    listStrings.add("E");
    listStrings.add("A");
    listStrings.add("B");
    System.out.println("listStrings before sorting: " + listStrings);
    Collections.sort(listStrings);
    System.out.println("listStrings after sorting: " + listStrings);

    List<String> sourceList = new ArrayList<String>();
    sourceList.add("A");
    sourceList.add("B");
    sourceList.add("C");
    sourceList.add("D");

    List<String> destList = new ArrayList<String>();
    destList.add("V");
    destList.add("W");
    destList.add("X");
    destList.add("Y");
    destList.add("Z");

    System.out.println("destList before copy: " + destList);
    Collections.copy(destList, sourceList);
    System.out.println("destList after copy: " + destList);

    List<Integer> nums = new ArrayList<Integer>();
    for (int i = 0; i <= 10; i++) nums.add(i);
    System.out.println("List before shuffling: " + nums);
    Collections.shuffle(nums);
    System.out.println("List after shuffling: " + nums);

    List<Integer> revNumbers = new ArrayList<Integer>();
    for (int i = 0; i <= 10; i++) revNumbers.add(i);
    System.out.println("List before reversing: " + revNumbers);
    Collections.reverse(revNumbers);
    System.out.println("List after reversing: " + revNumbers);

    List<String> listNames = Arrays.asList("Tom", "John", "Mary", "Peter", "David", "Alice");
    System.out.println("Original list: " + listNames);
    List<String> subList = listNames.subList(2, 5);
    System.out.println("Sub list: " + subList);

    List<String> arrListNames = Arrays.asList("John", "Peter", "Tom", "Mary", "David", "Sam");
    List<Integer> arrListNumbers = Arrays.asList(1, 3, 5, 7, 9, 2, 4, 6, 8);

    List<String> listWordsArr = new ArrayList<String>();
    Object[] arrayWords = listWordsArr.toArray();

    String[] words = listWordsArr.toArray(new String[0]);
    Integer[] arrNumbers = arrListNumbers.toArray(new Integer[0]);
  }
}
