package inheritance;

// 定义 Manager 类并继承自超类 Employee
public class Manager extends Employee {
    private double bonus;

    /**
     * 子类 Manager 的构造器
     *
     * @param name   the employee's name
     * @param salary the salary
     * @param year   the hire year
     * @param month  the hire month
     * @param day    the hire day
     */
    public Manager(String name, double salary, int year, int month, int day) {
        // 调用超类 Employee 中带有 n, s, year, month 和 day 参数的构造器
        super(name, salary, year, month, day);

        bonus = 0;
    }

    /**
     * 提供一个新的 getSalary 方法来覆盖超类中的这个方法
     */
    public double getSalary() {
        // 调用超类 Employee 类中的 getSalary 方法
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    public void setBonus(double b) {
        bonus = b;
    }
}
