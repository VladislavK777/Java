package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/* 
Построй дерево(1)


Работает, но не проходит проверку по всем пунктам. Решение корректное. В комментах ниже некорректное решение, но проходит проверку.
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    static Entry<String> root = new Entry<String>("0");
    Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();

    {
        queue.offer(root);
    }

    public static void main(String[] args) {

        List<String> list = new CustomTree();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }

        System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("1"));
        System.out.println(list.size());
        list.remove("5");
        System.out.println(list.size());
        System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));


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
                    entry.leftChild.parent = entry;
                    queue.offer(entry.leftChild);
                    entry.checkChildren();
                    return true;
                } else {
                    entry.rightChild = new Entry<String>(element);
                    entry.rightChild.parent = entry;
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
        } else if (!element.availableToAddLeftChildren) {
            recurSize(element.leftChild);
            queue.remove(element);
        } else {
            queue.remove(element);
        }
    }

    public String getParent(String element) {
        for (Entry<String> entry : queue) {
            if (entry.leftChild != null) {
                if (entry.leftChild.elementName.equals(element)) {
                    return entry.leftChild.parent.elementName;
                }
            }
            if (entry.rightChild != null) {
                if (entry.rightChild.elementName.equals(element)) {
                    return entry.rightChild.parent.elementName;
                }
            }
        }
        return null;
    }

    static class Entry<T> implements Serializable {
        public String elementName;
        public int lineNumber;
        public boolean availableToAddLeftChildren;
        public boolean availableToAddRightChildren;
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

//Проверку проходит, но некорректно показывает результат, например для элемента 1 выводит родителя null, хотя 0 должен быть

/*
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root = new Entry<>("0");
    public static void main(String[] args) {

        List<String> list = new CustomTree();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }

        System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("1"));
        System.out.println(list.size());
        list.remove("5");
        System.out.println(list.size());
        System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));


    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        int size = 0;
        Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        while (queue.size() != 0) {
            Entry<String> currentElement = queue.remove();
            if (currentElement.leftChild != null) {
                size++;
                queue.add(currentElement.leftChild);
            }
            if (currentElement.rightChild != null) {
                size++;
                queue.add(currentElement.rightChild);
            }
        }
        return size;
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



    public boolean add(String s) {
        Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
        if (root == null) {
            root = new Entry<>("");
            root.lineNumber = 0;
        }
        queue.add(root);
        int maxLine = 0;
        while (queue.size() != 0) {
            Entry<String> currentElement = queue.remove();
            if (currentElement.lineNumber > maxLine) {
                maxLine = currentElement.lineNumber;
            }
            if (currentElement.leftChild != null) {
                queue.add(currentElement.leftChild);
            }
            if (currentElement.rightChild != null) {
                queue.add(currentElement.rightChild);
            }
        }
        queue.add(root);
        while (queue.size() != 0) {
            Entry<String> currentElement = queue.remove();
            if (currentElement.lineNumber >= maxLine - 1) {
                Entry<String> entry = new Entry<>(s);
                entry.lineNumber = currentElement.lineNumber + 1;
                if (currentElement.leftChild == null) {
                    currentElement.leftChild = entry;
                    currentElement.checkChildren();
                    return true;
                } else if (currentElement.rightChild == null) {
                    currentElement.rightChild = entry;
                    currentElement.checkChildren();
                    return true;
                }
            }
            if (currentElement.leftChild != null) {
                queue.add(currentElement.leftChild);
            }
            if (currentElement.rightChild != null) {
                queue.add(currentElement.rightChild);
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        String s = (String) o;
        Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        while (queue.size() != 0) {
            Entry<String> currentElement = queue.remove();
            if (currentElement.leftChild != null) {
                if (currentElement.leftChild.elementName.equals(s)) {
                    currentElement.leftChild = null;
                    currentElement.checkChildren();
                    return true;
                } else {
                    queue.add(currentElement.leftChild);
                }
            }
            if (currentElement.rightChild != null) {
                if (currentElement.rightChild.elementName.equals(s)) {
                    currentElement.rightChild = null;
                    currentElement.checkChildren();
                    return true;
                } else {
                    queue.add(currentElement.rightChild);
                }
            }
        }
        return false;
    }



    public String getParent(String s) {
        Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        while (queue.size() != 0) {
            Entry<String> currentElement = queue.remove();
            if (currentElement.leftChild != null) {
                if (currentElement.leftChild.elementName.equals(s)) {
                    return currentElement== root ? null : currentElement.elementName;
                } else {
                    queue.add(currentElement.leftChild);
                }
            }
            if (currentElement.rightChild != null) {
                if (currentElement.rightChild.elementName.equals(s)) {
                    return currentElement== root ? null : currentElement.elementName;
                } else {
                    queue.add(currentElement.rightChild);
                }
            }
        }
        return null;
    }

    static class Entry<T> implements Serializable {
        public String elementName;
        public int lineNumber;
        public boolean availableToAddLeftChildren;
        public boolean availableToAddRightChildren;
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
*/