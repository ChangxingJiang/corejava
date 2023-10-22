package abstractClasses;

// 定义 Student 类并继承自抽象类 Person
public class Student extends Person {
    private String major;

    /**
     * @param name  the student's name
     * @param major the student's major
     */
    public Student(String name, String major) {
        super(name);  // 调用超类 Person 的构造器并传入 name 参数
        this.major = major;
    }

    // 实现超类 Person 中的抽象方法 getDescription
    public String getDescription() {
        return "a student majoring in " + major;
    }
}
