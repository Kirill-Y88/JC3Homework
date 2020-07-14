package Homework6;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestArray2 {
    private static MainTest mainTest;

    @BeforeClass
    public static void init(){
        System.out.println("начало тестирования Array2");
        mainTest = new MainTest();
    }

    @Test
    public void arr1(){
        int[] arr1 = { 1, 2, 1, 1, 2, 3, 4, 1, 7 };
        Assert.assertEquals(true, mainTest.numberOnArray(arr1));
    }
    @Test
    public void arr2(){
        int[] arr1 = { 2, 2, 2, 2, 2, 3, 2, 2, 7 };
        Assert.assertEquals(false, mainTest.numberOnArray(arr1));
    }


}
