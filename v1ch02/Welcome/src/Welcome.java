/**
 * This program displays a greeting for the reader.
 *
 * @author Cay Horstmann
 * @version 1.30 2014-02-27
 */
public class Welcome {
    public static void main(String[] args) {
        // 定义字符串（详解位于 3.6）
        String greeting = "Welcome to Core Java!";

        // 使用 System.out 对象并调用了它的 println 方法，用于将文本行输出到控制台上（详解位于 3.1）
        System.out.println(greeting);

        // 循环打印与 greeting 字符串长度相同的等号（讲解位于 3.8.3）
        for (int i = 0; i < greeting.length(); i++)
            System.out.print("=");
        System.out.println();
    }
}