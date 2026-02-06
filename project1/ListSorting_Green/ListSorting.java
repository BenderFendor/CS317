import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class ListSorting {

  public static void main(String[] args) {
    List<String> listStrings = Arrays.asList("Orange", "Grape", "Apple", "Lemon", "Banana");
    System.out.println("Before sorting: " + listStrings);
    Collections.sort(listStrings);
    System.out.println("After sorting: " + listStrings);

    List<Character> listCharacters = Arrays.asList('F', 'C', 'A', 'B', 'Z', 'E', 'K', 'P');
    System.out.println("Before sorting: " + listCharacters);
    Collections.sort(listCharacters);
    System.out.println("After sorting: " + listCharacters);

    List<Integer> listIntegers = Arrays.asList(1, 6, 9, 3, 2, 0, 8, 4, 7, 5);
    System.out.println("Before sorting: " + listIntegers);
    Collections.sort(listIntegers);
    System.out.println("After sorting: " + listIntegers);

    List<Date> listDates = new ArrayList<Date>();
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    try {
      listDates.add(dateFormatter.parse("2013-09-30"));
      listDates.add(dateFormatter.parse("2013-07-06"));
      listDates.add(dateFormatter.parse("2013-11-28"));
    } catch (ParseException ex) {
      System.err.print(ex);
    }
    System.out.println("Before sorting: " + listDates);
    Collections.sort(listDates);
    System.out.println("After sorting: " + listDates);

    List<Integer> listForReverse = new ArrayList<Integer>(Arrays.asList(1, 6, 9, 3, 2, 0, 8, 4, 7, 5));
    System.out.println("Before sorting: " + listForReverse);
    Collections.sort(listForReverse);
    System.out.println("After sorting: " + listForReverse);
    Collections.reverse(listForReverse);
    System.out.println("After reversing: " + listForReverse);

    List<Employee> listEmployees = new ArrayList<Employee>();
    listEmployees.add(new Employee("Tom", 45, 80000));
    listEmployees.add(new Employee("Sam", 56, 75000));
    listEmployees.add(new Employee("Alex", 30, 120000));
    listEmployees.add(new Employee("Peter", 25, 60000));
    System.out.println("Before sorting: " + listEmployees);
    Collections.sort(listEmployees);
    System.out.println("After sorting: " + listEmployees);

    List<Employee> listEmployees2 = new ArrayList<Employee>();
    listEmployees2.add(new Employee("Tom", 45, 80000));
    listEmployees2.add(new Employee("Sam", 56, 75000));
    listEmployees2.add(new Employee("Alex", 30, 120000));
    listEmployees2.add(new Employee("Peter", 25, 60000));
    System.out.println("Before sorting: " + listEmployees2);
    Collections.sort(listEmployees2, new EmployeeAgeComparator());
    System.out.println("After sorting: " + listEmployees2);
  }

  static class Employee implements Comparable<Employee> {
    private String name;
    private int age;
    private int salary;

    public Employee(String name, int age, int salary) {
      this.name = name;
      this.age = age;
      this.salary = salary;
    }

    public String getName() {
      return name;
    }

    public int getAge() {
      return age;
    }

    public int getSalary() {
      return salary;
    }

    public int compareTo(Employee employee) {
      return employee.salary - this.salary;
    }

    public String toString() {
      return String.format("(%s, %d, %d)", name, age, salary);
    }
  }

  static class EmployeeAgeComparator implements Comparator<Employee> {
    public int compare(Employee emp1, Employee emp2) {
      return emp1.getAge() - emp2.getAge();
    }
  }
}
