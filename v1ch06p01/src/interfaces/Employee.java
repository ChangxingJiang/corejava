package interfaces;

public class Employee implements Comparable<Employee> {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    /**
     * 比较员工的薪资（实现 Comparable 接口的方法）
     *
     * @param other 另一个需要比较的 Employee 对象
     * @return 与另几个 Employee 对象相比，如果当前对象的薪资更低，则返回负数；如果两个对象薪资一致，则返回 0；如果当前对象薪资更高，则返回正数
     */
    public int compareTo(Employee other) {
        return Double.compare(salary, other.salary);  // 使用静态 Double.compare 方法比较 Employee 对象的 salary 字段
    }
}
