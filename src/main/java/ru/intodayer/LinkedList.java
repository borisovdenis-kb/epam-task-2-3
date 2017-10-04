package ru.intodayer;


//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class LinkedList<T> implements Iterable<T> {
    private Node<T> first;
    private Node<T> last;
    private Predicate<T> condition;
    private int size;

    public LinkedList(Predicate<T> condition) {
        this.condition = condition;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public Node<T> getFirst() {
        return first;
    }

    public Node<T> getLast() {
        return last;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<T>(data);
        if (first == null) {
            last = newNode;
            first = newNode;
            newNode.next = null;
            newNode.prev = null;
        } else {
            first.prev = newNode;
            newNode.next = first;
            newNode.prev = null;
            first = newNode;
        }
        size++;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<T>(data);
        if (last == null) {
            last = newNode;
            first = newNode;
            newNode.next = null;
            newNode.prev = null;
        } else {
            last.next = newNode;
            newNode.prev = last;
            newNode.next = null;
            last = newNode;
        }
        size++;
    }

    public void addBefore(T key, T data) {
        Node<T> newNode = new Node<T>(data);
        Node<T> current = first;
        while (current != null && !current.getData().equals(key)) {
            current = current.next;
        }
        if (current == null) {
            addLast(data);
        } else if (current.prev == null) {
            addFirst(data);
        } else {
            current.prev.next = newNode;
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev = newNode;
        }
        size++;
    }

    public Node<T> deleteFirst() {
        Node<T> tmp = first;
        if (last == first) {
            last = null;
            first = null;
            return tmp;
        }
        first = first.next;
        first.prev = null;
        size--;
        return tmp;
    }

    public Node<T> deleteLast() {
        Node<T> tmp = last;
        if (last == first) {
            last = null;
            first = null;
            return tmp;
        }
        last = last.prev;
        last.next = null;
        size--;
        return tmp;
    }

    public Node<T> delete(T key) {
        for (Node<T> x = first; x != null; x = x.next) {
            if (x.getData().equals(key)) {
                if (x == first) {
                    return deleteFirst();
                } else if (x == last) {
                    return deleteLast();
                } else {
                    x.prev.next = x.next;
                    x.next.prev = x.prev;
                }
                size--;
                return x;
            }
        }
        return null;
    }

    public int getSize() {
        return size;
    }

    public void clear() {
        first = null;
        last = null;
    }

    public ArrayList<T> toArray() {
        ArrayList<T> array = new ArrayList<T>();
        int i = 0;
        for (Node<T> x = first; x != null; x = x.next) {
            array.add(x.getData());
        }
        return array;
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    public Iterator<Node<T>> firstIterator() {
        return new FirstIterator();
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder("null<--");
        for (Node<T> x = first; x != null; x = x.next) {
            stringBuilder.append("[" + x.getData().toString() + "]");
            if (x.next == null) {
                stringBuilder.append("-->null");
            } else {
                stringBuilder.append("<-->");
            }
        }
        return stringBuilder.toString();
    }

    class FirstIterator implements Iterator<Node<T>> {
        private Node<T> current;

        public FirstIterator() {
            this.current = getFirst();
        }

        public boolean hasNext() {
            return !(current == null);
        }

        public Node<T> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Node<T> tmp = current;
            current = current.next;
            return tmp;
        }
    }

    class LinkedListIterator implements Iterator<T> {
        private Iterator<Node<T>> itr;
        private Node<T> tmp;

        public LinkedListIterator() {
            this.itr = firstIterator();
        }

        public boolean hasNext() {
//            if (tmp != null && tmp.next == null) {
//                if (condition.test(tmp.getData())) {
//                    return false;
//                }
//            } else if (tmp != null && tmp.next.next == null) {
//                if (condition.test(tmp.next.getData())) {
//                    return false;
//                }
//            }
            return itr.hasNext();
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            tmp = itr.next();
            while (condition.test(tmp.getData())) {
                if (tmp.next == null) {
                    return null;
                }
                tmp = itr.next();
            }
            return tmp.getData();
        }

//        public void remove() {
//            delete(array.get(index)); // TODO: Тут можно оптимизировать. Т.к. мы уже нашли нужные элемент!! и его можно удалить.
//        }
    }
}