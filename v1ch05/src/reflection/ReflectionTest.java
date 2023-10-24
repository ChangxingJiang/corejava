package reflection;


import java.util.*;
import java.lang.reflect.*;

/**
 * This program uses reflection to print all features of a class.
 *
 * @author Cay Horstmann
 * @version 1.11 2018-03-16
 */
public class ReflectionTest {
    public static void main(String[] args) throws ReflectiveOperationException {
        // 从命令行参数或命令行输入中读取需要处理的类名
        String name;
        if (args.length > 0) name = args[0];  // 从命令行参数中读取
        else {
            var in = new Scanner(System.in);
            System.out.println("Enter clas name(e.g. java.util.Data): ");
            name = in.next();  // 从命令行输入中读取
        }

        // 打印类名和超类名
        Class cl = Class.forName(name);  // 获取类名对应的 Class 对象；Class 实际上是泛型类，这里应写作 Class<?>
        Class supercl = cl.getSuperclass();  // 获取其超类的 Class 对象
        String modifiers = Modifier.toString(cl.getModifiers());  // 获取 Class 对象 cl 的的修饰符信息
        if (modifiers.length() > 0) System.out.print(modifiers + " ");  // 打印 cl 的修饰符
        System.out.println("class " + name);  // 打印 cl 的类名
        if (supercl != null && supercl != Object.class) System.out.print(" extends " + supercl.getName());  // 打印继承状态

        System.out.println("\n{\n");
        printConstructors(cl);  // 打印构造器信息
        System.out.println();
        printMethods(cl);  // 打印方法信息
        System.out.println();
        printFields(cl);  // 打印字段信息
        System.out.println("}");
    }

    /**
     * Prints all constructors of a class
     *
     * @param cl a class
     */
    public static void printConstructors(Class cl) {
        Constructor[] constructors = cl.getDeclaredConstructors();  // 获取 cl 类的所有构造器
        for (Constructor c : constructors) {
            String name = c.getName();  // 获取构造器名称
            System.out.print("    ");
            String modifiers = Modifier.toString(c.getModifiers());  // 获取构造器的修饰符
            if (modifiers.length() > 0) System.out.print(modifiers + " ");  // 打印构造器的修饰符

            System.out.print(name + "(");

            // 打印参数类型
            Class[] paramTypes = c.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0) System.out.println(", ");
                System.out.println(paramTypes[j].getName());
            }

            System.out.println(");");
        }
    }

    /**
     * Print all methods of a class
     *
     * @param cl a class
     */
    public static void printMethods(Class cl) {
        Method[] methods = cl.getDeclaredMethods();  // 获取 cl 的所有方法

        for (Method m : methods) {
            Class retType = m.getReturnType();  // 获取方法的返回值类型
            String name = m.getName();  // 获取方法的名称

            System.out.print("    ");

            // 打印方法的修饰器、返回类型和名称
            String modifiers = Modifier.toString(m.getModifiers());  // 获取构造器的修饰符
            if (modifiers.length() > 0) System.out.print(modifiers + " ");  // 打印构造器的修饰符
            System.out.print(retType.getName() + " " + name + "(");

            // 打印参数类型
            Class[] paramTypes = m.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0) System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * Prints all fields of a class
     *
     * @param cl a class
     */
    public static void printFields(Class cl) {
        Field[] fields = cl.getDeclaredFields();  // 获取 cl 的所有字段

        for (Field f : fields) {
            Class type = f.getType();  // 获取字段类型
            String name = f.getName();  // 获取字段名称
            System.out.print("    ");
            String modifiers = Modifier.toString(f.getModifiers());  // 获取构造器的修饰符
            if (modifiers.length() > 0) System.out.print(modifiers + " ");  // 打印构造器的修饰符
            System.out.println(type.getName() + " " + name + ";");
        }
    }
}
