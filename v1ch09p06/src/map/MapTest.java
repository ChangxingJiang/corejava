package map;

import java.util.*;

/**
 * 这个程序展示了如何使用键为字符串，值为 Employee 的 map 对象
 *
 * @author Cay Horstmann
 * @version 1.12 2015-06-21
 */
public class MapTest {
    public static void main(String[] args) {
        var staff = new HashMap<String, Employee>();
        staff.put("144-25-5464", new Employee("Amy Lee"));
        staff.put("567-24-2546", new Employee("Harry Hacker"));
        staff.put("157-62-7935", new Employee("Gary Cooper"));
        staff.put("456-62-5527", new Employee("Francesca Cruz"));

        // 打印所有元素
        System.out.println(staff);

        // 移除一个元素
        staff.remove("567-24-2546");

        // 替换一个元素
        staff.put("456-62-5527", new Employee("Francesca Miller"));

        // 查看一个元素
        System.out.println(staff.get("157-62-7935"));

        // 迭代执行所有元素
        staff.forEach((k, v) -> System.out.println("key=" + k + ", value=" + v));
    }
}


class Employee {
    private final String name;

    public Employee(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee[name=" + name + "]";
    }
}