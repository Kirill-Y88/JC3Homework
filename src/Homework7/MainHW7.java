package Homework7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainHW7 {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        start(TestClass.class);
    }
    public  static void start(Class testClass) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = testClass.getDeclaredMethods();
        List<Method> list = new ArrayList<>();
        for (Method m: methods) {
            if(m.isAnnotationPresent(Test.class)) {
                int priority = m.getAnnotation(Test.class).priority();
                if(priority < 1 || priority > 10) throw  new RuntimeException();
                list.add(m);
            }
        }
        list.sort(new Comparator<Method>() {
            @Override
            public int compare(Method m1, Method m2) {
                return m2.getAnnotation(Test.class).priority() - m1.getAnnotation(Test.class).priority();
            }
        });
        for (Method m: methods) {
            if(m.isAnnotationPresent(BeforeSuite.class)) {
                if(list.get(0).isAnnotationPresent(BeforeSuite.class))
                    throw new RuntimeException();
                list.add(0, m);
            }
            if(m.isAnnotationPresent(AfterSuite.class)) {
                if(list.get(list.size() - 1).isAnnotationPresent(AfterSuite.class))
                    throw new RuntimeException();
                list.add(m);
            }
        }
        for (Method m: list) {
            m.invoke(null);
        }
    }

}
