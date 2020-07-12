package Homework7;

public class TestClass {
    @BeforeSuite
    public static void start() {
        System.out.println("start");
    }
    @Test(priority = 5)
    public static  void method1() {
        System.out.println("method1");
    }
    @Test(priority = 4)
    public static  void method2() {
        System.out.println("method2");
    }
    @Test(priority = 3)
    public static  void method3() {
        System.out.println("method3");
    }
    @Test(priority = 2)
    public static  void method4() {
        System.out.println("method4");
    }
    @Test(priority = 1)
    public static  void method5() {
        System.out.println("method5");
    }
    @AfterSuite
    public static void end() {
        System.out.println("end");
    }
}
