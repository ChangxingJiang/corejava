package equals;

public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        bonus = 0;
    }

    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public boolean equals(Object otherObject) {
        // 调用超类 Employee 的 equals 比较方法
        if (!super.equals(otherObject)) return false;

        // 通过超类 Employee 的 equals 比较方法后，可以确定 this 和 otherObject 的 class 相同，可以强制转换为 Manager 类型
        var other = (Manager) otherObject;

        // 根据相等性概念的要求来比较子类 Manager 中新增的字段；使用 == 比较基本类型字段；如果所有的字段都匹配，则返回 true，否则返回 false
        return bonus == other.bonus;
    }

    public int hashCode() {
        // 根据超类 Employee 类的散列码及子类新增字段 bonus 的组合得到 Manager 类的散列码
        return java.util.Objects.hash(super.hashCode(), bonus);
    }

    public String toString() {
        // 利用超类的 toString 方法并补充子类新增字段 bonus
        return super.toString() + "[bonus=" + bonus + "]";
    }
}
