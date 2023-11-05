package clone;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Cloneable {
    private String name;
    private double salary;
    private Date hireDay;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        hireDay = new Date();
    }

    // 创建深拷贝的 clone 方法
    public Employee clone() throws CloneNotSupportedException {
        // 调用 Object.clone()
        Employee cloned = (Employee) super.clone();

        // 克隆对象中可变的实例字段
        cloned.hireDay = (Date) hireDay.clone();

        return cloned;
    }

    /**
     * 将 hireDay 设置为指定的日期
     *
     * @param year  年
     * @param month 月
     * @param day   日
     */
    public void setHireDay(int year, int month, int day) {
        Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();

        // 修改实例字段的样例
        hireDay.setTime(newHireDay.getTime());
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public String toString() {
        return "Employee[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";
    }
}
