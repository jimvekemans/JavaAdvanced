package threading2.demo.parallel;

import java.util.ArrayList;
import java.util.List;

public class ParallellStreams {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<Employee>();
        for (int i = 0; i < 100; i++) {
            employees.add(new Employee("A", 20000));
            employees.add(new Employee("B", 3000));
            employees.add(new Employee("C", 15002));
            employees.add(new Employee("D", 7856));
            employees.add(new Employee("E", 200));
            employees.add(new Employee("F", 50000));
        }
        long t1 = System.currentTimeMillis();
        System.out.println("Sequential Stream Count?= " + employees.stream().filter(e -> e.getSalary() > 15000).count());
        long t2 = System.currentTimeMillis();
        System.out.println("Sequential Stream Time Taken?= " + (t2 - t1) + "\n");

        t1 = System.currentTimeMillis();
        System.out.println("Parallel Stream Count?= " + employees.parallelStream().filter(e -> e.getSalary() > 15000).count());
        t2 = System.currentTimeMillis();
        System.out.println("Parallel Stream Time Taken?= " + (t2 - t1));
    }
}
