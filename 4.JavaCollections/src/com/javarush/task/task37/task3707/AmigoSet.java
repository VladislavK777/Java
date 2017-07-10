package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

/**
 * Created by vladislav.klochkov on 10.07.2017.
 */
public class AmigoSet<E> extends AbstractSet<E> implements Cloneable, Serializable, Set<E> {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        this.map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        int max = Math.max(16, (int) (collection.size() / .75f) + 1);
        this.map = new HashMap<>(max);
        addAll(collection);
    }

    @Override
    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        return map.keySet().remove(o);
    }

    @Override
    public Object clone() {
        try {
            AmigoSet copy = (AmigoSet) super.clone();
            copy.map = (HashMap) map.clone();
            return copy;
        } catch (Exception ex) {
            throw new InternalError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        for (E e : map.keySet())
            objectOutputStream.writeObject(e);
        objectOutputStream.writeFloat(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
        objectOutputStream.writeInt(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int capacity = objectInputStream.readInt();
        float loadFactor = objectInputStream.readFloat();
        map = new HashMap<E, Object>(capacity, loadFactor);
        for (int i = 0; i < size(); i++) {
            E e = (E) objectInputStream.readObject();
            map.put(e, PRESENT);
        }
    }
}
