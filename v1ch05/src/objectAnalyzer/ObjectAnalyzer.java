package objectAnalyzer;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class ObjectAnalyzer {
    private ArrayList<Object> visited = new ArrayList<>();  // 存储已访问过元素的列表

    /**
     * Converts an object to a string representation that lists all fields.
     *
     * @param obj an object
     * @return a string with the object's class name and all field names and values
     */
    public String toString(Object obj) throws ReflectiveOperationException {
        if (obj == null) return "null";  // 如果当前对象为 NULL，则返回 "null"
        if (visited.contains(obj)) return "...";  // 如果当前对象已经访问过，则返回 "..."
        visited.add(obj);  // 记录已经访问过的元素

        Class cl = obj.getClass();
        if (cl == String.class) return (String) obj;  // 如果当前对象为字符串，则强制类型转换后直接返回

        if (cl.isArray()) {  // 如果当前对象为数组，则将其每个元素用逗号间隔输出
            String r = cl.getComponentType() + "[]{";
            for (int i = 0; i < Array.getLength(obj); i++) {
                if (i > 0) r += ",";
                Object val = Array.get(obj, i);
                if (cl.getComponentType().isPrimitive()) r += val;
                else r += toString(val);
            }
            return r + "}";
        }

        // 如果当前对象为其他类型对象
        String r = cl.getName();
        // 检查当前类及其父类的字段
        do {
            r += "[";
            Field[] fields = cl.getDeclaredFields(); // 获得类中所有声明的字段的一个数组
            AccessibleObject.setAccessible(fields, true);  // 设置 fields 对象的可访问标志
            // 获取字段的名称和值
            for (Field f: fields) {
                if (!Modifier.isStatic(f.getModifiers())) {  // 检查这个字段是否为静态字段
                    if (!r.endsWith("[")) r += ",";
                    r += f.getName() + "=";
                    Class t = f.getType();
                    Object val = f.get(obj);
                    if (t.isPrimitive()) r += val;
                    else r += toString(val);
                }
            }
            r += "]";
            cl = cl.getSuperclass();
        }
        while(cl != null);

        return r;
    }
}
