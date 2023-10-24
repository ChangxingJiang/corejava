import java.util.*;

/**
 * This program demonstrates console input.
 *
 * @author Cay Horstmann
 * @version 1.10 2004-02-10
 */
public class InputTest {
    public static void main(String[] args) {
        // 构造一个与 "标准输入流" System.in 关联的 Scanner 对象
        Scanner in = new Scanner(System.in);

        // 使用 nextLine 方法读取一行输入
        System.out.println("What is your name? ");
        String name = in.nextLine();

        // 使用 nextInt 方法读取一个整数
        System.out.println("How old are you? ");
        int age = in.nextInt();

        // 将读取的信息展示到控制台
        System.out.println("Hello, " + name + ". Next year, you'll be " + (age + 1));
    }
}