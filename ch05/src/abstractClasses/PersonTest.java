package abstractClasses;

/**
 * This program demonstrates abstract classes.
 *
 * @author Cay Horstmann
 * @version 1.01 2004-02-21
 */
public class PersonTest {
    public static void main(String[] args) {
        var people = new Person[2];

        // 将员工和学生对象填充到 Person 引用数组
        people[0] = new Employee("Harry Hacker", 550000, 1989, 10, 1);
        people[1] = new Student("Maria Morris", "computer science");

        // 打印 Person 引用数组中对象的名称和描述
        for (Person p : people) {
            System.out.println(p.getName() + ", " + p.getDescription());
        }
    }
}
