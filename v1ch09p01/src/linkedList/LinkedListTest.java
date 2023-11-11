package linkedList;

import java.util.*;

/**
 * 这个程序展示了 LinkedList 的操作方法
 *
 * @author Cay Horstmann
 * @version 1.12 2018-04-10
 */
public class LinkedListTest {
    public static void main(String[] args) {
        // 初始化包含 3 个元素的链表 a
        var a = new LinkedList<String>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        // 初始化包含 4 个元素的链表 b
        var b = new LinkedList<String>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");

        // 将 b 中的单词合并到 a 中
        ListIterator<String> aIter = a.listIterator(); // 初始化支持 add 操作的迭代器
        Iterator<String> bIter = b.iterator();  // 初始化不支持 add 操作的迭代器

        // 每跳过 1 个 a 的单词后插入 1 个 b 的单词，直至 a 中没有单词后则连续插入 b 的单词
        while (bIter.hasNext()) {
            if (aIter.hasNext()) aIter.next();
            aIter.add(bIter.next());
        }

        System.out.println(a);

        // 每个 1 个单词移除 b 中的 1 个单词
        bIter = b.iterator();  // 重新初始化不支持 add 操作的迭代器
        while (bIter.hasNext()) {
            bIter.next();  // 跳过第 1 个元素
            if (bIter.hasNext()) {
                bIter.next();  // 跳过第 2 个元素
                bIter.remove();  // 移除第 2 个元素
            }
        }

        System.out.println(b);

        // 移除 removeAll 方法移除 a 中所有 b 中的元素
        a.removeAll(b);

        System.out.println(a);
    }
}
