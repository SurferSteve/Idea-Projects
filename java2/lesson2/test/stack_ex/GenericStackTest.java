package stack_ex;

import org.junit.After;
//import org.junit.Assert;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Steve on 27.05.2016.
 */
public class GenericStackTest {
    GenericStack<Integer> genericStack;

    @Before
    public void setUp() throws Exception {
        genericStack = new GenericStack<>(3);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void push() throws Exception {

    }

    @Test(expected = StackException.class)
    public void IsExceptionIfStackIsEmptyAndWePop() throws Exception {
        genericStack.push(1);
        genericStack.pop();
        genericStack.pop();
    }

    @Test
    public void peek() throws Exception {

    }

    @Test
    public void getSizeForEmptyStack() throws Exception {
//        Assert.assertEquals(0, genericStack.getSize());
        assertEquals(0, genericStack.getSize());
//        genericStack.getSize();
    }

    @Test
    public void isEmpty() throws Exception {

    }

    @Test
    public void testIsFullForEmptyStack() throws Exception {
//        assertTrue(genericStack.isFull());
    }

    @Test
    public void pushAll() throws Exception {

    }

    @Test
    public void popAll() throws Exception {

    }

}