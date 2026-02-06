import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class QueueExamples {

  public static void main(String[] args) {
    Queue<String> namesQueue = new LinkedList<String>();
    Queue<Integer> numbersDeque = new ArrayDeque<Integer>();

    Queue<String> queueNames = new LinkedList<String>();
    queueNames.add("Mary");
    queueNames.offer("John");

    Queue<String> queueCustomers = new LinkedList<String>();
    queueCustomers.offer("Jack");
    String next = queueCustomers.remove();
    String polled = queueCustomers.poll();

    Queue<String> queuePeeks = new LinkedList<String>();
    queuePeeks.offer("Jack");
    System.out.println(queuePeeks.peek());
    System.out.println(queuePeeks.element());

    for (String name : queueNames) {
      System.out.println(name);
    }

    queueNames.forEach(name -> System.out.println(name));
  }
}
