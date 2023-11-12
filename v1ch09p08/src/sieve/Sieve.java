package sieve;

import java.util.*;

/**
 * 这个程序使用 埃拉托色尼筛选法 实现素数计算
 *
 * @author Cay Horstmann
 * @version 1.21 2004-08-03
 */
public class Sieve {
    public static void main(String[] s) {
        int n = 2000000;
        long start = System.currentTimeMillis();
        var bitSet = new BitSet(n + 1);  // 初始化位集（位图），其中 True 表示可能为素数，False 表示不可能为素数（即它是前面某个素数的整数倍）
        int count = 0;
        int i;
        for (i = 2; i <= n; i++)
            bitSet.set(i);  // 将 2 以后的所有位置标注位可能是素数
        i = 2;
        while (i * i <= n) {  // 如果 i^2 大于 n，则说明更大的非素数一定是之前某个素数的整数倍，不需要继续遍历
            if (bitSet.get(i)) {  // 如果当前这个数是素数，则将它的所有整数倍标注为 False（不可能为素数）
                count++;
                int k = 2 * i;
                while (k <= n) {
                    bitSet.clear(k);
                    k += i;
                }
            }
            i++;
        }
        while (i <= n) {  // 统计剩余未遍历部分的素数数量
            if (bitSet.get(i)) count++;
            i++;
        }
        long end = System.currentTimeMillis();
        System.out.println(count + " primes");
        System.out.println((end - start) + " milliseconds");
    }
}
