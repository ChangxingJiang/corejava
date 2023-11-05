package clone;

/**
 * 这个程序展示了 clone 的用法
 *
 * @author Cay Horstmann
 * @version 1.11 2018-03-16
 */
public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        var original = new Employee("John Q. Public", 50000);
        original.setHireDay(2000, 1, 1);

        // 克隆 original 对象
        Employee copy = original.clone();

        // 修改克隆后的对象
        copy.raiseSalary(10);
        copy.setHireDay(2002, 10, 31);

        // 打印克隆前的对象和克隆后的对象
        System.out.println("original=" + original);
        System.out.println("copy=" + copy);
    }
}
