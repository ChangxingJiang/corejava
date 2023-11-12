package treeSet;

import java.util.*;

/**
 * 这个程序利用 TreeSet 根据默认排序和根据 descriptions 排序了一些 Item 对象
 *
 * @author Cay Horstmann
 * @version 1.13 2018-04-10
 */
public class TreeSetTest {
    public static void main(String[] args) {
        var parts = new TreeSet<Item>();
        parts.add(new Item("Toaster", 1234));
        parts.add(new Item("Widget", 4562));
        parts.add(new Item("Modem", 9912));
        System.out.println(parts);

        var sortByDescription = new TreeSet<Item>(Comparator.comparing(Item::getDescription));
        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);
    }
}
