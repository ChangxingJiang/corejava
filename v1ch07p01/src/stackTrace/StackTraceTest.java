package stackTrace;

import java.util.*;

/**
 * 这个程序展示了递归调用的方法的堆栈特性
 *
 * @author Cay Horstmann
 * @version 1.10 2017-12-14
 */
public class StackTraceTest {
    /**
     * 计算整数 n 的阶乘
     *
     * @param n 一个非负整数
     * @return 非负整数 n 的阶乘
     */
    public static int factorial(int n) {
        System.out.println("factorial(" + n + ")");

        // 生成一个 StackWalker.StackFrame 实例流，其中每个实例分别描述一个栈帧
        var walker = StackWalker.getInstance();

        // 迭代并打印这些栈帧
        walker.forEach(System.out::println);

        // 递归地计算阶乘并返回
        int r;
        if (n <= 1) r = 1;
        else r = n * factorial(n - 1);
        System.out.println("return " + r);
        return r;
    }

    public static void main(String[] args) {
        // 使用 try-with-Resources 语句保证 Scanner 能够被关闭
        try (var in = new Scanner(System.in)) {
            System.out.print("Enter n: ");
            int n = in.nextInt();
            factorial(n);
        }
    }
}
