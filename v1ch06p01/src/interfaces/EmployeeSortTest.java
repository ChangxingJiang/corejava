package interfaces;

import java.util.*;

/**
 * 这段程序展示如何使用 Comparable 接口
 *
 * @author Cay Horstmann
 * @version 1.30 2004-02-28
 */
public class EmployeeSortTest {
    public static void main(String[] args) {
        // 初始化包含 3 个 Employee 对象的数组
        var staff = new Employee[3];
        staff[0] = new Employee("Harry Hacker", 35000);
        staff[1] = new Employee("Carl Cracker", 75000);
        staff[2] = new Employee("Tony Tester", 38000);

        // 将数组中的元素排序（Employee 对象必须支持 Comparable 接口方能支持排序）
        Arrays.sort(staff);

        // 打印排序后的 Employee 对象数组的信息
        for (Employee e : staff)
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
    }
}
