package Homework6;

import java.io.IOException;
import java.util.logging.*;


public class MainTest {
    public static final Logger logger = Logger.getLogger(MainTest.class.getName());
    public static void main(String[] args) throws IOException {
        int[] array1 = { 1, 2, 1, 1, 2, 3, 4, 1, 7 };
        int [] array2;
        logger.setLevel(Level.ALL);

        Handler h = new FileHandler("loggerMainTest.txt");
        h.setFormatter(new XMLFormatter());
        h.setLevel(Level.ALL);
        logger.addHandler(h);

        try {
            array2 = arr4(array1);
            for (int i = 0; i < array2.length ; i++) {
                System.out.print(array2[i]);
                logger.log(Level.ALL, String.valueOf(array2[i]));
            }


        }catch (RuntimeException e){
            e.printStackTrace();
        }

        System.out.println(numberOnArray(array1));
        logger.log(Level.ALL, String.valueOf(numberOnArray(array1)));
    }

    public static int [] arr4 (int[] array) throws RuntimeException{
        int [] arrcut;
        int j = 0;
        int len;
        for (int i = 0; i < array.length ; i++) {
            if(array[i] == 4) j = i+1;
        }
        if (j == 0) {logger.log(Level.ALL, "Входной массив не содержит значений 4");
            throw new RuntimeException( "Входной массив не содержит значений 4");
             }
        else {
            len = array.length - (j);
            arrcut = new int[len];

            for (int i = 0; i < len; i++) {
                arrcut[i] = array[i + j];
            }
        }
        return arrcut;
    }

    public static boolean numberOnArray (int [] array){
        for (int i = 0; i < array.length ; i++) {
            if(array[i]==1 || array[i]==4) return true;
        }
        return false;
    }

}
