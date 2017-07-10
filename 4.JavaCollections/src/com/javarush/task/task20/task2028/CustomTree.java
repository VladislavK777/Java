package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)


Работает, но не проходит проверку по всем пунктам
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    static Entry<String> root = new Entry<String>("0");
    private Queue<Entry<String>> queue = new LinkedList<>();
    //int size = 0;

    {
        queue.offer(root);
    }

    public static void main(String[] args) {

        List<String> list = new CustomTree();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }

        //System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
       // System.out.println(list.size());
        list.remove("5");
       // System.out.println(list.size());
       // System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));


    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return queue.size() - 1;
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        return remove((String) o);
    }

    public boolean add(String element) {
        for (Entry<String> entry : queue) {
            if (entry.isAvailableToAddChildren()) {
                if (entry.availableToAddLeftChildren) {
                    entry.leftChild = new Entry<String>(element);
                    if (!"0".equals(entry.elementName)) {
                        entry.leftChild.parent = entry;
                    }
                   // size++;
                    queue.offer(entry.leftChild);
                    entry.checkChildren();
                    return true;

                } else {
                    entry.rightChild = new Entry<String>(element);
                    if (!"0".equals(entry.elementName)) {
                        entry.rightChild.parent = entry;
                    }
                   // size++;
                    queue.offer(entry.rightChild);
                    entry.checkChildren();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean remove(String element) {
        Entry<String> forRemove = null;
        for (Entry<String> entry : queue) {
            if (element.equals(entry.elementName)) {
                forRemove = entry;
                break;
            }
        }
        if (forRemove != null) {
            recurSize(forRemove);
            if (forRemove.parent.leftChild.elementName.equals(forRemove.elementName)) {
                forRemove.parent.leftChild = null;
                return true;
            } else {
                forRemove.parent.rightChild = null;
                return true;
            }
        } else {
            return false;
        }
    }

    public void recurSize(Entry<String> element) {
        if (!element.isAvailableToAddChildren()) {
            recurSize(element.leftChild);
            recurSize(element.rightChild);
            queue.remove(element);
          //  size--;
        } else if (!element.availableToAddLeftChildren) {
            recurSize(element.leftChild);
            queue.remove(element);
          //  size--;
        } else {
            queue.remove(element);
          //  size--;
        }
    }

    public String getParent(String element) {
        for (Entry<String> entry : queue) {
            if (element.equals(entry.elementName)) {
                return entry.parent.elementName;
            }
        }
        return null;
    }

    static class Entry<T> implements Serializable {
        public String elementName;
        public int lineNumber;
        public boolean availableToAddLeftChildren, availableToAddRightChildren;
        public Entry<T> parent;
        public Entry<T> leftChild;
        public Entry<T> rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        void checkChildren() {
            if (leftChild != null) {
                availableToAddLeftChildren = false;
            }
            if (rightChild != null) {
                availableToAddRightChildren = false;
            }
        }

        boolean isAvailableToAddChildren() {
            if (availableToAddLeftChildren || availableToAddRightChildren) {
                return true;
            } else {
                return false;
            }
        }
    }
}
