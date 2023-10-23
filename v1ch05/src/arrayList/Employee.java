package arrayList;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public boolean equals(Object otherObject) {
        // 检查 this 与 otherObject 是否相等（这条语句是一个优化，因为检查身份要比逐个比较字段的开销小）
        if (this == otherObject) return true;

        // 检查 otherObject 是否为 null；如果为 null，返回 false
        if (otherObject == null) return false;

        // 比较 this 与 otherObject 的类；因为 equals 语义可以在子类中改变，所以使用 getClass 检测
        if (getClass() != otherObject.getClass()) return false;

        // 将 otherObject 强制转换为相应类类型的变量
        var other = (Employee) otherObject;

        // 根据相等性概念的要求来比较字段；使用 == 比较基本类型字段，使用 Objects.equals 比较对象字段；如果所有的字段都匹配，则返回 true，否则返回 false
        return Objects.equals(name, other.name) && salary == other.salary && Objects.equals(hireDay, other.hireDay);
    }

    public int hashCode() {
        // 根据 name、salary 和 hireDay 对象的散列码组合得到 Employee 类的散列码
        return Objects.hash(name, salary, hireDay);
    }

    public String toString() {
        // 返回表示对象值的一个字符串
        return getClass().getName() + "[name=]" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";
    }
}
