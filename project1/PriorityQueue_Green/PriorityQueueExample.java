import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {

  public static void main(String[] args) {
    PriorityQueue<Integer> intQ = new PriorityQueue<Integer>();

    intQ.add(51);
    intQ.offer(6);
    intQ.add(72);
    intQ.add(1);
    intQ.add(2);
    intQ.offer(3);
    intQ.offer(4);
    intQ.add(11);
    intQ.add(19);

    System.out.println("Size: " + intQ.size());

    while(!intQ.isEmpty()){
      System.out.println(intQ.remove());
    }

    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new MaxHeapComparator());

    pq.add(10);
    pq.add(30);
    pq.add(20);

    while (!pq.isEmpty()) {
      System.out.println(pq.poll());
    }
  }

  static class MaxHeapComparator implements Comparator<Integer> {
    public int compare(Integer a, Integer b) {
      return b - a;
    }
  }
}
