package ru.ifmo.collections;


import java.util.AbstractSet;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Iterator;

/**
 * Represents sorted set of unique values.
 * create() returns a SortedSet instance with natural ordering. (i.e. from smallest to largest in case of integer numbers)
 * from() is used to create a SortedSet instance with given Comparator.
 * Instances of a class can be created using only these two methods above.
 * <p>
 * This class should not be abstract and should be capable of adding/removing single/multiple elements.
 * It has two more methods: getSorted() and getReversed() which return an array of set contents in forward and reverse order respectively.
 * <p>
 * NB! This class must have only map(s) as an internal data structure(s).
 *
 * @param <T> set contents type
 */

public class SortedSet<T> extends AbstractSet<T> {
    private final TreeMap<T, Integer> elements;

    private SortedSet(TreeMap<T, Integer> temp) {
        elements = temp;
    }

    public static <T> SortedSet<T> create() {
        return new SortedSet<>(new TreeMap<>());
    }

    public static <T> SortedSet<T> from(Comparator<T> comparator) {
        return new SortedSet<>(new TreeMap<>(comparator));
    }

    public List<T> getSorted() {
        return new ArrayList<>(elements.keySet());
    }

    public List<T> getReversed() {
        return new ArrayList<>(elements.descendingKeySet());
    }

    public Iterator<T> iterator() {
        return elements.keySet().iterator();
    }

    public boolean add(T element) {
        int temp = elements.size();
        elements.put(element, 1);
        return temp != elements.size();
    }

    public boolean addAll(Collection<? extends T> collection) {
        int temp = elements.size();
        for (T i : collection) {
            this.add(i);
        }
        return temp != elements.size();
    }

    public boolean remove(Object object) {
        return elements.remove(object, 1);
    }

    public boolean removeAll(Collection<?> collection) {
        int temp = elements.size();
        for (Object object : collection) {
            this.remove(object);
        }
        return temp != elements.size();
    }

    public int size() {
        return elements.size();
    }
}