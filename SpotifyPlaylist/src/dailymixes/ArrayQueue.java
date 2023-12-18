// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Prakhar Pandey (prakhar28)

package dailymixes;

import queue.EmptyQueueException;
import queue.QueueInterface;

// -------------------------------------------------------------------------
/**
 * Represents a generic queue data structure implemented using an array.
 *
 * @param <T>
 *            The type of elements stored in the queue.
 * @author Prakhar Pandey
 * @version 31-Oct-2023
 */
public class ArrayQueue<T>
    implements QueueInterface<T>
{
    /**
     * default capacity of arrayqueue set to 20.
     */
    public static final int DEFAULT_CAPACITY = 20;
    private T[] queue;
    private int dequeueIndex;
    private int size;
    private int enqueueIndex;

    /**
     * Constructs an empty ArrayQueue with the default capacity.
     */
    public ArrayQueue()
    {
        this(DEFAULT_CAPACITY);
    }


    /**
     * Constructs an empty ArrayQueue with the specified capacity.
     *
     * @param capacity
     *            The initial capacity of the queue.
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity)
    {
        queue = (T[])new Object[capacity + 1];
        dequeueIndex = 0;
        enqueueIndex = queue.length - 1;
    }


    /**
     * Gets the number of elements in the queue.
     *
     * @return The number of elements in the queue.
     */
    public int getSize()
    {
        return size;
    }


    /**
     * Gets the length of the underlying array used to store the queue.
     *
     * @return The length of the underlying array.
     */
    public int getLengthOfUnderlyingArray()
    {
        return queue.length;
    }


    /**
     * Ensures that the queue has enough capacity for additional elements. If
     * the queue is full, it doubles its capacity.
     */
    @SuppressWarnings("unchecked")
    private void ensureCapacity()
    {
        if (isFull())
        {
            T[] oldQueue = queue;
            int oldSize = queue.length;
            int newSize = (oldSize - 1) * 2 + 1;
            queue = (T[])new Object[newSize];

            int k = dequeueIndex;
            for (int i = 0; i < oldSize - 1; i++)
            {
                queue[i] = oldQueue[k];
                k = (k + 1) % oldSize;
            }

            dequeueIndex = 0;
            enqueueIndex = oldSize - 2;
        }
    }


    /**
     * Increments an index while considering the circular nature of the queue.
     *
     * @param index
     *            The index to increment.
     * @return The incremented index.
     */
    private int incrementIndex(int index)
    {
        return (index + 1) % queue.length;
    }


    /**
     * Converts the elements in the queue to an array.
     *
     * @return An array containing the elements in the queue.
     * @throws EmptyQueueException
     *             if the queue is empty.
     */
    public Object[] toArray()
    {
        if (isEmpty())
        {
            throw new EmptyQueueException();
        }
        Object[] array = new Object[size];
        int i = 0;
        int index = dequeueIndex;
        while (i < size)
        {
            array[i] = queue[index];
            index = incrementIndex(index);
            i++;
        }
        return array;
    }


    /**
     * Returns a string representation of the elements in the queue.
     *
     * @return A string representing the elements in the queue.
     */
    public String toString()
    {
        if (isEmpty())
        {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        int index = dequeueIndex;
        for (int i = 0; i < size; i++)
        {
            sb.append(queue[index]);
            if (i < size - 1)
            {
                sb.append(", ");
            }
            index = incrementIndex(index);
        }
        sb.append("]");
        return sb.toString();
    }


    /**
     * Checks if this queue is equal to another object.
     *
     * @param obj
     *            The object to compare with this queue.
     * @return true if the objects are equal, false otherwise.
     */
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        ArrayQueue<?> other = (ArrayQueue<?>)obj;
        if (size != other.size)
        {
            return false;
        }
        int indexThis = dequeueIndex;
        int indexOther = other.dequeueIndex;
        for (int i = 0; i < size; i++)
        {
            if (!queue[indexThis].equals(other.queue[indexOther]))
            {
                return false;
            }
            indexThis = incrementIndex(indexThis);
            indexOther = other.incrementIndex(indexOther);
        }
        return true;
    }


    /**
     * Adds an item to the end of the queue.
     *
     * @param item
     *            The item to be added to the queue.
     */
    public void enqueue(T item)
    {
        ensureCapacity();
        enqueueIndex = (enqueueIndex + 1) % queue.length;
        queue[enqueueIndex] = item;
        size++;
    }


    /**
     * Removes and returns the item at the front of the queue.
     *
     * @return The item at the front of the queue.
     * @throws EmptyQueueException
     *             if the queue is empty.
     */
    public T dequeue()
    {
        if (isEmpty())
        {
            throw new EmptyQueueException();
        }
        T item = queue[dequeueIndex];
        queue[dequeueIndex] = null;
        dequeueIndex = incrementIndex(dequeueIndex);
        size--;
        return item;
    }


    /**
     * Gets the item at the front of the queue without removing it.
     *
     * @return The item at the front of the queue.
     * @throws EmptyQueueException
     *             if the queue is empty.
     */
    public T getFront()
    {
        if (isEmpty())
        {
            throw new EmptyQueueException();
        }
        return queue[dequeueIndex];
    }


    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return size == 0;
    }


    /**
     * Clears the queue, removing all elements.
     */
    @SuppressWarnings("unchecked")
    public void clear()
    {
        queue = (T[])new Object[DEFAULT_CAPACITY + 1];
        dequeueIndex = 0;
        size = 0;
        enqueueIndex = queue.length - 1;
    }


    /**
     * Checks if the queue is full.
     *
     * @return true if the queue is full, false otherwise.
     */
    private boolean isFull()
    {
        return (enqueueIndex + 2) % queue.length == dequeueIndex;
    }
}
