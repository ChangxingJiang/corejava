package pair2;

import java.time.*;

/**
 * @author Cay Horstmann
 * @version 1.02 2015-06-21
 */
public class PairTest2 {
    public static void main(String[] args) {
        LocalDate[] birthdays = {
                LocalDate.of(1906, 12, 9),  // G. Hopper
                LocalDate.of(1815, 12, 10),  // A. Lovelace
                LocalDate.of(1903, 12, 3),  // J. von Neumann
                LocalDate.of(1910, 6, 22),  // K. Zuse
        };
        Pair<LocalDate> mm = ArrayAlg.minmax(birthdays);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
    }
}


class ArrayAlg {
    /**
     * 计算一个实现了 Comparable 接口的 T 类型数组的最小值和最大值
     *
     * @param a 实现了 Comparable 接口的 T 类型数组
     * @return 最小值和最大值的 Pair 对象（如果数组为 null 或空，则返回 null）
     */
    public static <T extends Comparable> Pair<T> minmax(T[] a) {
        if (a == null || a.length == 0) return null;
        T min = a[0];
        T max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) min = a[i];
            if (max.compareTo(a[i]) < 0) max = a[i];
        }
        return new Pair<>(min, max);
    }
}


class Pair<T> {
    private T first;
    private T second;

    public Pair() {
        first = null;
        second = null;
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T newValue) {
        first = newValue;
    }

    public void setSecond(T newValue) {
        second = newValue;
    }
}