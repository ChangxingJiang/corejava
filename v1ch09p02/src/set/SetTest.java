package set;

import java.util.*;

/**
 * 这个程序使用 set 打印标 System.in 中的所有不同单词
 * 结束控制台输入，可以使用 Ctrl + D
 *
 * @author Cay Horstmann
 * @version 1.12 2015-06-21
 */
public class SetTest {
    public static void main(String[] args) {
        var words = new HashSet<String>();
        long totalTime = 0;

        // 将标准输入中的文本添加到 HashSet 中
        try (var in = new Scanner(System.in)) {
            while (in.hasNext()) {
                String word = in.next();
                long callTime = System.currentTimeMillis();
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTime += callTime;
            }
        }

        Iterator<String> iter = words.iterator();
        for (int i = 1; i <= 20 && iter.hasNext(); i++)
            System.out.println(iter.next());
        System.out.println("...");
        System.out.println(words.size() + " distinct words. " + totalTime + " milliseconds. ");
    }
}
