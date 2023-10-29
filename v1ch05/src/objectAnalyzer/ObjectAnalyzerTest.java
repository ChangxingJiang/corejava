package objectAnalyzer;

// 需要注意：在 Java 9 及之后的版本中，运行此脚本需添加 VM 参数：--add-opens java.base/java.util=ALL-UNNAMED  --add-opens java.base/java.lang=ALL-UNNAMED

import java.util.*;

/**
 * This program uses reflection to spy on objects.
 *
 * @author Cay Horstmann
 * @version 1.13 2018-03-16
 */
public class ObjectAnalyzerTest {
    public static void main(String[] args) throws ReflectiveOperationException {
        var squares = new ArrayList<Integer>();
        for (int i = 1; i <= 5; i++)
            squares.add(i * i);

        // 调用通用的 toString 方法
        System.out.println(new ObjectAnalyzer().toString(squares));
    }
}
