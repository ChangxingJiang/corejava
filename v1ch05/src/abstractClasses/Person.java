package abstractClasses;

// 使用 abstract 关键字定义包含抽象方法 getDescription 抽象类 Person
public abstract class Person {
    // 使用 abstract 关键字定义抽象方法 getDescription
    public abstract String getDescription();

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
