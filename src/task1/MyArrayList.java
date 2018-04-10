package task1;

import java.util.*;



// для интереса реализовал больше методов, чем в задании
public class MyArrayList<E> implements List<E>
{
    private final int INIT_SIZE = 16;
    private Object[] elements = new Object[INIT_SIZE];
    private int size = 0;
    private int index;

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    @Override
    public boolean contains(Object o)
    {
        // return false;
        return indexOf(o) >= 0;
    }

    @Override
    public Object[] toArray()
    {
        // return new Object[0];
        return Arrays.copyOf(elements, size);
    }

    @Override
    public <T> T[] toArray(T[] a)
    {
        // return null;
        if (a.length < size)
           return (T[]) Arrays.copyOf(elements, size, a.getClass());
        System.arraycopy(elements, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }

    @Override
    public boolean add(E e)
    {
        if (index == elements.length) growArray();
        elements[index] = e;
        index++;
        size++;
        return true;
    }
    private void growArray()
    {
        Object[] newArray = new Object[elements.length * 2];
        System.arraycopy(elements, 0, newArray, 0, index - 1);
        elements = newArray;
    }

    @Override
    public boolean remove(Object o)
    {
        checkIndex(index);
        System.arraycopy(elements, index + 1, elements, index, this.index - index);
        size--;
        this.index--;
        return true;
    }

    @Override
    public void clear()
    {
        for (int i = 0; i < size; i++)
            elements[i] = null;
        size = 0;
        index = 0;
    }

    @Override
    public E get(int index)
    {
        checkIndex(index);
        return (E)elements[index];
    }
    private void checkIndex(int index)
    {
        if (index < 0 || index >= this.index)
            throw new IllegalArgumentException();
    }

    @Override
    public E set(int index, E element)
    {
        E oldValue = (E) elements[index];
        checkIndex(index);
        elements[index] = element;
        return oldValue;
    }

    @Override
    public void add(int index, E element)
    {
        checkIndex(index);
        if (index == elements.length)
            growArray();

        System.arraycopy(elements, index, elements, index + 1, this.index - index);
        elements[index] = element;
        this.index++;
        size++;
    }

    @Override
    public E remove(int index)
    {
        E oldValue = (E) elements[index];
        checkIndex(index);
        System.arraycopy(elements, index + 1, elements, index, this.index - index);
        size--;
        this.index--;
        return oldValue;
    }

    @Override
    public int indexOf(Object o)
    {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (elements[i]==null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(elements[i]))
                    return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o)
    {
        if (o == null) {
            for (int i = size-1; i >= 0; i--)
                if (elements[i]==null)
                    return i;
        } else {
            for (int i = size-1; i >= 0; i--)
                if (o.equals(elements[i]))
                    return i;
        }
        return -1;
    }

    @Override
    public Iterator<E> iterator()
    {
        //return null;
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c)
    {
        //return false;
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends E> c)
    {
        // return false;
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c)
    {
        //return false;
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c)
    {
        // return false;
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c)
    {
        // return false;
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator()
    {
        // return null;
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator(int index)
    {
        // return null;
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex)
    {
        // return null;
        throw new UnsupportedOperationException();
    }
}
