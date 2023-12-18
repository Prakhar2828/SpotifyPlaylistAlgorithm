package dailymixes;

import queue.EmptyQueueException;

// -------------------------------------------------------------------------
/**
 * A test class for ArrayQueue, which is used to test the functionality of the
 * ArrayQueue class.
 * 
 * @author Prakhar Pandey
 * @version 31-Oct-2023
 */
public class ArrayQueueTest
    extends student.TestCase
{
    private ArrayQueue<Song> queue;

    /**
     * Set up the test environment by creating a new ArrayQueue instance.
     */
    public void setUp()
    {
        queue = new ArrayQueue<Song>();
    }


    /**
     * Tests the custom constructor for the ArrayQueue class.
     */
    public void testArrayQueueConstructor()
    {
        ArrayQueue<Song> customQueue = new ArrayQueue<Song>(10);
        assertEquals(0, customQueue.getSize());
        assertEquals(11, customQueue.getLengthOfUnderlyingArray());
        Song song1 = new Song("This is America", 15, 25, 35, "Rap");
        Song song2 = new Song("Here Now", 15, 25, 35, "Country");
        Song song3 = new Song("Never Not", 15, 25, 35, "Pop");
        customQueue.enqueue(song1);
        customQueue.enqueue(song2);
        customQueue.enqueue(song3);
        assertEquals(3, customQueue.getSize());

        for (int i = 0; i < 17; i++)
        {
            customQueue.enqueue(song1);
        }
        assertEquals(customQueue.getSize(), 20);
        customQueue.enqueue(song1);
        assertEquals(customQueue.getLengthOfUnderlyingArray(), 41);
    }


    /**
     * Test the clear() method, which empties the queue. Ensures that the queue
     * is empty after clearing it.
     */
    public void testClear()
    {
        assertEquals(0, queue.getSize());
        Song song1 = new Song("This is America", 15, 25, 35, "Rap");
        Song song2 = new Song("Here Now", 15, 25, 35, "Country");
        Song song3 = new Song("Never Not", 15, 25, 35, "Pop");
        queue.enqueue(song1);
        queue.enqueue(song2);
        queue.enqueue(song3);
        queue.clear();
        assertEquals(0, queue.getSize());
    }


    /**
     * Test the toString() method, which returns a string representation of the
     * queue. Verifies that the string representation matches the expected
     * format.
     */
    public void testToString()
    {
        assertEquals("[]", queue.toString());
        Song song1 = new Song("This is America", 15, 25, 35, "Rap");
        Song song2 = new Song("Here Now", 15, 25, 35, "Country");
        Song song3 = new Song("Never Not", 15, 25, 35, "Pop");
        queue.enqueue(song1);
        queue.enqueue(song2);
        queue.enqueue(song3);

        assertEquals(
            "[This is America Pop:15 Rock:25 Country:35 Suggested: Rap, "
                + "Here Now Pop:15 Rock:25 Country:35 Suggested: Country, "
                + "Never Not Pop:15 Rock:25 Country:35 Suggested: Pop]",
            queue.toString());
    }


    /**
     * Test the equals() method to check if two queues are equal. Compares
     * queues for equality and handles different cases.
     */
    public void testEquals()
    {
        assertEquals(queue, queue);

        ArrayQueue<Song> queue2 = new ArrayQueue<Song>();
        assertEquals(queue, queue2);

        ArrayQueue<Song> queue3 = new ArrayQueue<Song>();
        Song song1 = new Song("This is America", 15, 25, 35, "Rap");
        queue3.enqueue(song1);
        assertFalse(queue.equals(queue3));
        queue.enqueue(song1);
        assertEquals(queue, queue3);

        String name = "Prakhar Pandey";
        assertFalse(queue.equals(name));

        ArrayQueue<Song> queue4 = null;
        assertFalse(queue.equals(queue4));

        Object queue5 = new Object();
        assertFalse(queue.equals(queue5));

        Object obj = queue;
        assertEquals(queue, obj);

    }


    /**
     * Test the isEmpty() method, which checks if the queue is empty. Verifies
     * that the isEmpty() method correctly identifies empty and non-empty
     * queues.
     */
    public void testIsEmpty()
    {
        assertTrue(queue.isEmpty());

        Song song1 = new Song("This is America", 15, 25, 35, "Rap");
        queue.enqueue(song1);
        assertFalse(queue.isEmpty());

        queue.dequeue();
        assertTrue(queue.isEmpty());
    }


    /**
     * Test the dequeue() method, which removes and returns the front element
     * from the queue. Validates that dequeue() correctly removes elements from
     * the queue and handles exceptions.
     */
    public void testDequeue()
    {
        @SuppressWarnings("unused")
        Exception thrown = null;
        try
        {
            queue.dequeue();
            fail();
        }
        catch (EmptyQueueException e)
        {
            thrown = e;
        }

        Song song1 = new Song("This is America", 15, 25, 35, "Rap");
        Song song2 = new Song("Here Now", 15, 25, 35, "Country");
        Song song3 = new Song("Never Not", 15, 25, 35, "Pop");
        queue.enqueue(song1);
        queue.enqueue(song2);
        queue.enqueue(song3);
        assertEquals(queue.dequeue(), song1);
        assertEquals(queue.dequeue(), song2);
        assertEquals(queue.dequeue(), song3);
    }


    /**
     * Test the enqueue() method, which adds an element to the queue. Checks if
     * elements are added correctly and if the underlying array size is
     * adjusted.
     */
    public void testEnqueue()
    {
        Song song1 = new Song("This is America", 15, 25, 35, "Rap");
        Song song2 = new Song("Here Now", 15, 25, 35, "Country");
        Song song3 = new Song("Never Not", 15, 25, 35, "Pop");
        queue.enqueue(song1);
        assertEquals(queue.getSize(), 1);
        queue.enqueue(song2);
        assertEquals(queue.getSize(), 2);
        queue.enqueue(song3);
        assertEquals(queue.getSize(), 3);
        assertEquals(queue.getLengthOfUnderlyingArray(), 21);

        for (int i = 0; i < 17; i++)
        {
            queue.enqueue(song1);
        }
        assertEquals(queue.getSize(), 20);

        queue.enqueue(song1);
        assertEquals(queue.getSize(), 21);
        assertEquals(queue.getLengthOfUnderlyingArray(), 41);
    }


    /**
     * Test the getLengthOfUnderlyingArray() method, which returns the length of
     * the underlying array. Ensures that the length of the underlying array is
     * updated correctly.
     */
    public void testGetLengthOfUnderlyingArray()
    {
        assertEquals(queue.getLengthOfUnderlyingArray(), 21);

        Song song1 = new Song("This is America", 15, 25, 35, "Rap");
        for (int i = 0; i < 20; i++)
        {
            queue.enqueue(song1);
        }
        queue.enqueue(song1);
        assertEquals(queue.getLengthOfUnderlyingArray(), 41);

        for (int i = 0; i < 20; i++)
        {
            queue.enqueue(song1);
        }
        queue.enqueue(song1);
        assertEquals(queue.getLengthOfUnderlyingArray(), 81);
    }


    /**
     * Test the getFront() method, which returns the front element of the queue.
     * Validates that getFront() returns the correct element and handles
     * exceptions.
     */
    public void testGetFront()
    {
        @SuppressWarnings("unused")
        Exception thrown = null;
        try
        {
            queue.getFront();
            fail();
        }
        catch (EmptyQueueException e)
        {
            thrown = e;
        }

        Song song1 = new Song("This is America", 15, 25, 35, "Rap");
        Song song2 = new Song("Here Now", 15, 25, 35, "Country");
        Song song3 = new Song("Never Not", 15, 25, 35, "Pop");
        queue.enqueue(song1);
        queue.enqueue(song2);
        queue.enqueue(song3);
        assertEquals(song1, queue.getFront());
        queue.dequeue();
        assertEquals(song2, queue.getFront());
        queue.dequeue();
        assertEquals(song3, queue.getFront());
    }


    /**
     * Test the getSize() method, which returns the number of elements in the
     * queue. Checks if getSize() returns the correct size of the queue.
     */
    public void testGetSize()
    {
        Song song1 = new Song("This is America", 15, 25, 35, "Rap");
        Song song2 = new Song("Here Now", 15, 25, 35, "Country");
        Song song3 = new Song("Never Not", 15, 25, 35, "Pop");
        queue.enqueue(song1);
        assertEquals(queue.getSize(), 1);
        queue.enqueue(song2);
        assertEquals(queue.getSize(), 2);
        queue.enqueue(song3);
        assertEquals(queue.getSize(), 3);

        for (int i = 0; i < 17; i++)
        {
            queue.enqueue(song1);
        }
        assertEquals(queue.getSize(), 20);

        queue.enqueue(song1);
        assertEquals(queue.getSize(), 21);
    }


    /**
     * Test the toArray() method, which converts the queue to an array. Verifies
     * that toArray() returns an array containing the elements of the queue.
     */
    public void testToArray()
    {
        @SuppressWarnings("unused")
        Exception thrown = null;
        try
        {
            queue.toArray();
            fail();
        }
        catch (EmptyQueueException e)
        {
            thrown = e;
        }

        Song song1 = new Song("This is America", 15, 25, 35, "Rap");
        Song song2 = new Song("Here Now", 15, 25, 35, "Country");
        Song song3 = new Song("Never Not", 15, 25, 35, "Pop");
        queue.enqueue(song1);
        queue.enqueue(song2);
        queue.enqueue(song3);
        Object[] array = queue.toArray();
        assertEquals(array.length, 3);
        assertEquals(array[0], song1);
        assertEquals(array[1], song2);
        assertEquals(array[2], song3);
    }
}
