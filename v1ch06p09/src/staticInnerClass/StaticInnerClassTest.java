package staticInnerClass;

/**
 * 这个程序展示了静态内部类的使用方法
 *
 * @author Cay Horstmann
 * @version 1.02 2015-05-12
 */
public class StaticInnerClassTest {
    public static void main(String[] args) {
        // 初始化长度为 20 个的双精度浮点数样例数组
        var values = new double[20];
        for (int i = 0; i < values.length; i++)
            values[i] = 100 * Math.random();

        // 同时计算样例数组中的最小值和最大值
        ArrayAlg.Pair p = ArrayAlg.minmax(values);
        
        System.out.println("min = " + p.getFirst());
        System.out.println("max = " + p.getSecond());
    }
}

class ArrayAlg {
    /**
     * 两个浮点数的 Pair
     */
    public static class Pair {
        private double first;
        private double second;

        /**
         * 使用两个浮点数构造浮点数的 Pair
         *
         * @param f 第 1 个浮点数
         * @param s 第 2 个浮点数
         */
        public Pair(double f, double s) {
            first = f;
            second = s;
        }

        /**
         * 返回 Pair 中的第 1 个浮点数
         *
         * @return 第 1 个浮点数
         */
        public double getFirst() {
            return first;
        }

        /**
         * 返回 Pair 中的第 2 个浮点数
         *
         * @return 第 2 个浮点数
         */
        public double getSecond() {
            return second;
        }
    }

    /**
     * 同时计算浮点数数组 values 中的最小值和最大值
     *
     * @param values 浮点数数组
     * @return 返回 values 中的最小值和最大值的 Pair，Pair 中的地 1 个浮点数对应最小值，第 2 个浮点数对应最大值
     */
    public static Pair minmax(double[] values) {
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        for (double v : values) {
            if (min > v) min = v;
            if (max < v) max = v;
        }
        return new Pair(min, max);
    }
}