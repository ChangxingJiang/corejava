package lambda;

import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 * 这个程序展示了如何使用 lambda 表达式
 *
 * @author Cay Horstmann
 * @version 1.0 2015-05-12
 */
public class LambdaTest {
    public static void main(String[] args) {
        // 初始化一个用于排序的样例字符串数组
        var planets = new String[]{"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        System.out.println(Arrays.toString(planets));

        // 使用字典序排序数组中的字符串
        System.out.println("Sorted in dictionary order:");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));

        // 使用 Lambda 表达式实现按字符串长度排序字符串
        System.out.println("Sorted by length:");
        Arrays.sort(planets, (first, second) -> first.length() - second.length());
        System.out.println(Arrays.toString(planets));

        // 使用 Lambda 表达式实现定时器的回调方法
        var timer = new Timer(1000, event -> System.out.println("This time is " + new Date()));
        timer.start();

        // 打开一个对话框，当用户点击 "OK" 时则结束程序
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}
