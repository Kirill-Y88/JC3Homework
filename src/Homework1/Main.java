package Homework1;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
    Integer [] arr = {0, 5, 6, 7};
    ArrayList arr2;
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        System.out.println(arr[3]);

        arr2 = arrayToArrayList(arr);
        System.out.println(arr2.get(0));
        System.out.println(arr2.get(1));
        System.out.println(arr2.get(2));
        System.out.println(arr2.get(3));

    Box <Apple> appleBox = new Box<>();
    Box <Orange> orangeBox = new Box<>();
       appleBox.putFruit(new Apple());
        appleBox.putFruit(new Apple());
        appleBox.putFruit(new Apple());
       orangeBox.putFruit(new Orange());
       orangeBox.putFruit(new Orange());

        System.out.println(appleBox.compare(orangeBox));
        System.out.println(appleBox.getWeight());
        System.out.println(orangeBox.getWeight());

        appleBox.sendFruit(orangeBox);
        System.out.println();
        System.out.println(appleBox.compare(orangeBox));
        System.out.println(appleBox.getWeight());
        System.out.println(orangeBox.getWeight());



    }
//№1 Метод меняющий местами два элемента массива
    public static void replace (Object [] arr, int on, int to){
        Object x;
        x = arr[on];
        arr[on] = arr[to];
        arr[to] = x;
    }
//№2 Метод преобразования массива в Эррейлист
    public static <T> ArrayList<T> arrayToArrayList  (T [] arr) {
        ArrayList <T> alist = new ArrayList();
        for (int i = 0; i <arr.length ; i++) {
            alist.add(arr[i]);
        }
        return alist;
    }

}

class Fruit {
    float weight;
public Fruit(float weight){
    this.weight= weight;
}
    public float getWeightFruit() {
        return weight;
    }

}

class Apple extends Fruit{
   public Apple (){
        super(1.0f);
    }
}

class Orange extends Fruit{
    public Orange (){
        super(1.5f);
    }
}


class Box <T extends Fruit>{
    ArrayList <T> fruit = new ArrayList();

   void  putFruit  (T putfruit) {
       fruit.add(putfruit);
    }
    void info(int i){
        System.out.println(fruit.get(i));
    }

    float getWeight (){
       if(fruit.size()==0) return 0f;
       else { return  fruit.get(0).getWeightFruit()*fruit.size(); }
    }

    boolean compare(Box box){
       if(this.getWeight() == box.getWeight()) return true;
       else return false;
    }

    void sendFruit (Box box){
    box.putFruit( fruit.get(fruit.size()-1));
    fruit.remove(fruit.size()-1);
    }
}