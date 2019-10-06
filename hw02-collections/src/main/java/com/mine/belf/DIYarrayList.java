package com.mine.belf;

import java.util.*;

public class DIYarrayList<T> implements List<T> {

    private int size = 0;

    private T[] array = (T[]) new Object[2];

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        for(int i = 0; i < size(); i ++) {
            if(array[i].equals(o))
                return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new ElementsIterator();
    }

    @Override
    public Object[] toArray() {
        T[] newArr = (T[]) new Object[array.length - 1];
        System.arraycopy(array, 0, newArr, 0, array.length - 1);
        return newArr;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(T t) {
        if (this.size() == array.length) {
            T[] newArr = (T[]) new Object[array.length * 2];
            System.arraycopy(array, 0, newArr, 0, array.length);
            array = newArr;
        }

        array[size++] = t;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T t : c) {
            this.add(t);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        array = (T[]) new Object[2];
        size = 0;
    }

    @Override
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public T set(int index, T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    private class ElementsIterator implements Iterator<T> {
        int size = 0;
        @Override
        public boolean hasNext() {
            return DIYarrayList.this.size() > size;
        }

        @Override
        public T next() {
            return DIYarrayList.this.array[size++];
        }

        @Override
        public void remove() {
        }
    }
}
