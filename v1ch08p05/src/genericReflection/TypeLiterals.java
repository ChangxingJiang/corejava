package genericReflection;

/**
 * @author Cay Horstmann
 * @version 1.01 2018-041-
 */

import java.lang.reflect.*;
import java.sql.Array;
import java.util.*;
import java.util.function.*;

/**
 * 一个用类型字面量描述的通用类型，类似 ArrayList<String>
 *
 * @param <T> 泛型
 */
class TypeLiteral<T> {
    private Type type;

    /**
     * 这个建造者必须被匿名子类调用，例如 new TypeLiteral<...>(){}
     */
    public TypeLiteral() {
        Type parentType = getClass().getGenericSuperclass();
        if (parentType instanceof ParameterizedType) {
            type = ((ParameterizedType) parentType).getActualTypeArguments()[0];
        } else {
            throw new UnsupportedOperationException("Construct as new TypeLiteral<...>(){}");
        }
    }

    private TypeLiteral(Type type) {
        this.type = type;
    }

    /**
     * 根据提供的类型生成一个类型字面量
     *
     * @param type 给定的类型
     * @return 类型字面量
     */
    public static TypeLiteral<?> of(Type type) {
        return new TypeLiteral<Object>(type);
    }

    public String toString() {
        if (type instanceof Class) return ((Class<?>) type).getName();
        else return type.toString();
    }

    public boolean equals(Object otherObject) {
        return otherObject instanceof TypeLiteral && type.equals(((TypeLiteral<?>) otherObject).type);
    }

    public int hashCode() {
        return type.hashCode();
    }
}

/**
 * 格式化对象：使用添加的格式化方法格式化对象的字段
 */
class Formatter {
    private Map<TypeLiteral<?>, Function<?, String>> rules = new HashMap<>();

    /**
     * 添加 type 对应的格式化方法 formatterForType
     *
     * @param type             适用格式化方法的类型
     * @param formatterForType 格式化方法
     * @param <T>              泛型
     */
    public <T> void forType(TypeLiteral<T> type, Function<T, String> formatterForType) {
        rules.put(type, formatterForType);
    }

    /**
     * 使用格式化方法格式化 obj 的所有字段
     *
     * @param obj 需要格式化的字段
     * @return 格式化的字段后的字符串
     */
    public String formatFields(Object obj) throws IllegalAccessException {
        var result = new StringBuilder();
        for (Field f : obj.getClass().getDeclaredFields()) {
            result.append(f.getName());
            result.append("=");
            f.setAccessible(true);
            Function<?, String> formatterForType = rules.get(TypeLiteral.of(f.getGenericType()));
            if (formatterForType != null) {
                @SuppressWarnings("unchecked")
                Function<Object, String> objectFormatter = (Function<Object, String>) formatterForType;
                result.append(objectFormatter.apply(f.get(obj)));
            } else result.append(f.get(obj).toString());
            result.append("\n");
        }
        return result.toString();
    }
}


public class TypeLiterals {
    public static class Sample {
        ArrayList<Integer> nums;
        ArrayList<Character> chars;
        ArrayList<String> strings;

        public Sample() {
            nums = new ArrayList<>();
            nums.add(42);
            nums.add(1729);
            chars = new ArrayList<>();
            chars.add('H');
            chars.add('i');
            strings = new ArrayList<>();
            strings.add("Hello");
            strings.add("World");
        }
    }

    private static <T> String join(String separator, ArrayList<T> elements) {
        var result = new StringBuilder();
        for (T e : elements) {
            if (result.length() > 0) result.append(separator);
            result.append(e.toString());
        }
        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        var formatter = new Formatter();
        formatter.forType(new TypeLiteral<ArrayList<Integer>>() {
        }, lst -> join(" ", lst));
        formatter.forType(new TypeLiteral<ArrayList<Character>>() {
        }, lst -> "\"" + join("", lst) + "\"");
        System.out.println(formatter.formatFields(new Sample()));
    }
}
