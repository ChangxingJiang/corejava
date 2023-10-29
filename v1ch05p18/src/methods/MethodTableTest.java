package methods;

import java.lang.reflect.*;

/**
 * 这个程序展示如何使用 Java 的反射机制调用方法。
 *
 * @author Cay Horstmann
 * @version 1.2 2012-05-04
 */
public class MethodTableTest {
    public static void main(String[] args) throws ReflectiveOperationException {
        // 获取 square 和 Math.sqrt 的方法指针
        Method square = MethodTableTest.class.getMethod("square", double.class);
        Method sqrt = Math.class.getMethod("sqrt", double.class);

        // 打印输入参数和输出返回值的表格
        printTable(1, 10, 10, square);
        printTable(1, 10, 10, sqrt);
    }

    /**
     * 返回一个数的平方
     *
     * @param x 数
     * @return 数 x 的平方
     */
    public static double square(double x) {
        return x * x;
    }

    /**
     * 打印一个方法的参数和返回值表格
     *
     * @param from 输入的参数的最小值
     * @param to   输入的参数的最大值
     * @param n    要输出表格的行数
     * @param f    一个包含 double 类型参数和 double 类型返回值的方法
     */
    public static void printTable(double from, double to, int n, Method f) throws ReflectiveOperationException {
        // 打印方法信息作为表头
        System.out.println(f);

        double dx = (to - from) / (n - 1);

        for (double x = from; x <= to; x += dx) {
            double y = (Double) f.invoke(null, x);
            System.out.printf("%10.4f | %10.4f%n", x, y);
        }
    }
}
