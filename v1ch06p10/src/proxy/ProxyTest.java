package proxy;

import java.lang.reflect.*;
import java.util.*;

/**
 * 这个程序展示了代理的使用方法
 *
 * @author Cay Horstmann
 * @version 1.01 2018-04-10
 */
public class ProxyTest {
    public static void main(String[] args) {
        var elements = new Object[1000];

        // 向数组 elements 中添加包含 TraceHandler 代理的整型 1 - 1000
        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            // 构造包装器
            var handler = new TraceHandler(value);
            // 构造针对 Comparable 接口的包装器
            Object proxy = Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Comparable.class}, handler);
            elements[i] = proxy;
        }

        // 生成一个随机整数
        Integer key = new Random().nextInt(elements.length) + 1;

        // 使用二分查找在 elements 中查找随机整数
        int result = Arrays.binarySearch(elements, key);

        // 打印二分查找匹配的结果
        if (result >= 0) System.out.println(elements[result]);
    }
}

/**
 * 打印调用方法和参数的包装器
 */
class TraceHandler implements InvocationHandler {
    private Object target;

    /**
     * TraceHandler 的构造器
     *
     * @param t 调用方法的隐式参数（方法所在的对象）
     */
    public TraceHandler(Object t) {
        target = t;
    }

    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
        // 打印隐式参数
        System.out.print(target);
        // 打印方法名称
        System.out.print("." + m.getName() + "(");
        // 打印显式参数
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if (i < args.length - 1) System.out.print(", ");
            }
        }
        System.out.println(")");

        // 调用实际方法
        return m.invoke(target, args);
    }
}
