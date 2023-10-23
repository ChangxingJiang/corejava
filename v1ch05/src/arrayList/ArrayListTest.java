package arrayList;

import java.util.*;

/**
 * This program demonstrates the ArrayList class.
 *
 * @author Cay Horstmann
 * @version 1.11 2012-01-26
 */
public class ArrayListTest {
    public static void main(String[] args) {
        // 声明和构造一个保存 Employee 对象的数组列表
        var staff = new ArrayList<Employee>();

        // 使用 add 方法将元素添加到数组列表中
        staff.add(new Employee("Carl Cracker", 75000, 1987, 12, 15));
        staff.add(new Employee("Haray Hacker", 50000, 1989, 10, 1));
        staff.add(new Employee("Tony Tester", 40000, 1990, 3, 15));

        // 使用 for each 循环遍历数组列表的内容，并提高每个员工 5% 的 salary
        for (Employee e : staff)
            e.raiseSalary(5);

        // 使用 for each 循环遍历数组列表的内容，并打印每个 Employee 对象的信息
        for (Employee e : staff)
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary() + ",hireDay=" + e.getHireDay());
    }
}
