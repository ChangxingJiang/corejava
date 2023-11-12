package shuffle;

import java.util.*;

/**
 * 这个程序展示了随机洗牌算法和排序算法
 *
 * @author Cay Horstmann
 * @version 1.12 2018-04-10
 */
public class ShuffleTest {
    public static void main(String[] args) {
        // 初始化包含 1 - 49 的有序数组
        var numbers = new ArrayList<Integer>();
        for (int i = 1; i <= 49; i++) {
            numbers.add(i);
        }
        // 随机打乱数组
        Collections.shuffle(numbers);

        // 获取前 6 个元素的子范围视图
        List<Integer> winningCombination = numbers.subList(0, 6);

        // 排序子范围视图中的前 6 个元素
        Collections.sort(winningCombination);

        System.out.println(winningCombination);
    }
}
