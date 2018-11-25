package com.epam;
import org.junit.After;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;


public class TaskTest {
    private Task task;

    @Before
    public void setUp() {
        task = new Task("This is a testing message. Test for the fourth task: 00 111 2222");
    }

    @After
    public void tearDown() {
        System.setIn(System.in);
    }

    @Test
    public void testDoFirstTask() {
        assertEquals('i', task.doFirstTask(task));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDoFirstTask_ForIllegalArgumentException() {
        Task exceptionTask = new Task("ao");
        Task exceptionTask1 = new Task("a");
        Task exceptionTask2 = new Task("");
        exceptionTask.doFirstTask(exceptionTask);
        exceptionTask1.doFirstTask(exceptionTask1);
        exceptionTask2.doFirstTask(exceptionTask1);
        Task anotherExceptionTask = new Task(null);
        anotherExceptionTask.doFirstTask(anotherExceptionTask);
    }

    @Test
    public void testDoSecondTask() {
        assertEquals('e', task.doSecondTask(task));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDoSecondTask_ForIllegalArgumentException() {
        Task exceptionTask = new Task("");
        exceptionTask.doSecondTask(exceptionTask);
        Task anotherExceptionTask = new Task(null);
        anotherExceptionTask.doSecondTask(anotherExceptionTask);
    }

    @Test
    public void testDoFourthTask() {
        assertEquals(11, task.doFourthTask(task));
    }

    @Test
    public void testDoFifthTask() {
        assertEquals("T ishis a testing message. Test for the fourth task: 00 111 2222", task.doFifthTask(task));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDoFifthTask_ForIllegalArgumentException() {
        Task exceptionTask = new Task("");
        exceptionTask.doFifthTask(exceptionTask);
        Task exceptionTask1 = new Task("a");
        exceptionTask1.doFifthTask(exceptionTask1);
        Task anotherExceptionTask = new Task(null);
        anotherExceptionTask.doFifthTask(anotherExceptionTask);
        Task anotherExceptionTask1 = new Task("abc");
        anotherExceptionTask1.doFifthTask(anotherExceptionTask1);
    }
}