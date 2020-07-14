package Homework6;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestArray1 {
    private static MainTest mainTest;
    RuntimeException r = new RuntimeException();

    @BeforeClass
    public static void init(){
        System.out.println("начало тестирования Array1");
        mainTest = new MainTest();
    }

    @Test
    public void arr4(){
        int[] arr1 = { 1, 2, 1, 1, 2, 3, 4, 1, 7 };
        int[] arr2 = {1,7};
        Assert.assertArrayEquals(arr2, mainTest.arr4(arr1));
    }
    @Test
    public void arr4_1(){
        int[] arr1 = { 1, 2, 1, 1, 2, 3, 1, 1, 7 };
        int[] arr2 = {1,7};
        Assert.assertArrayEquals(arr2, mainTest.arr4(arr1));
    }
    @Test
    public void arr4_2(){
        int[] arr1 = { 1, 2, 4, 1, 2, 3, 1, 1, 7 };
        int[] arr2 = {1, 2, 3, 1, 1,7};
        Assert.assertArrayEquals(arr2, mainTest.arr4(arr1));
    }







}
