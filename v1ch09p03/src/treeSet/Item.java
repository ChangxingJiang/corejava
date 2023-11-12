package treeSet;

import java.util.*;

/**
 * 每个 Item 包含一个 description 和一个 partNumber
 */
public class Item implements Comparable<Item> {
    private String description;
    private int partNumber;

    /**
     * Item 的构造器
     *
     * @param aDescription 构造的 Item 的 description
     * @param aPartNumber  构造的 Item 的 partNumber
     */
    public Item(String aDescription, int aPartNumber) {
        description = aDescription;
        partNumber = aPartNumber;
    }

    /**
     * 返回 Item 的 description
     *
     * @return Item 对象的 description
     */
    public String getDescription() {
        return description;
    }

    public String toString() {
        return "[description=" + description + ", partNumber=" + partNumber + "]";
    }

    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        var other = (Item) otherObject;
        return Objects.equals(description, other.description) && partNumber == other.partNumber;
    }

    public int hashCode() {
        return Objects.hash(description, partNumber);
    }

    public int compareTo(Item other) {
        int diff = Integer.compare(partNumber, other.partNumber);
        return diff != 0 ? diff : description.compareTo(other.description);
    }
}
