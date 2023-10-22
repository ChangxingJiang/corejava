package inheritance;

/**
 * This program demonstrates inheritance.
 *
 * @author Cay Horstmann
 * @version 1.21 2004-02-21
 */
public class ManagerTest {
    public static void main(String[] args) {
        // 构造一个 Manager 对象，并设置他的奖金
        var boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        boss.setBonus(5000);

        // 构造一个 staff 数组，并填入了 1 个 Manager 对象和 2 个 Employee 对象
        var staff = new Employee[3];
        staff[0] = boss;  // 利用了对象变量是多态的特性，一个 Employee 类型的变量既可以引用一个 Employee 类型的对象，也可以引用 Employee 类的任何一个子类的对象
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tommy Tester", 40000, 1990, 3, 15);

        // 打印每个 Employee 对象的信息
        for (Employee e : staff) {
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
        }
    }
}
