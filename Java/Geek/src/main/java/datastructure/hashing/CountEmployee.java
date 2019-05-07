package datastructure.hashing;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class CountEmployee {

  public static void main(String args[]) {

    HashMap<String, String> dataset = new HashMap<String, String>();
    dataset.put("A", "C");
    dataset.put("B", "C");
    dataset.put("C", "F");
    dataset.put("D", "E");
    dataset.put("E", "F");
    dataset.put("F", "F");

    findEmployeeCount(dataset);
  }

  private static void findEmployeeCount(HashMap<String, String> dataset) {
    HashMap<String, List<String>> employee_count = new HashMap<String, List<String>>();
    for (Entry<String, String> d : dataset.entrySet()) {
      if (!d.getKey().equals(d.getValue())) {
        if (!employee_count.containsKey(d.getValue())) {
          List<String> employees = new LinkedList<String>();
          employees.add(d.getKey());
          employee_count.put(d.getValue(), employees);
        } else {
          String employee = d.getKey();
          List<String> employees = employee_count.get(d.getValue());
          employees.add(employee);
          employee_count.put(d.getValue(), employees);
        }
      }
    }

    System.out.println(employee_count);
  }
}
