package Homework_2;

public class Main {

    public static void main(String[] args) {
    ForSQlite.connect();
    ForSQlite.createDB();
    //ForSQlite.writeDB("Vasya","Doublev", "1234");
    //ForSQlite.writeDB("Pavel","Koleden", "1111");
    ForSQlite.readDB();
    //ForSQlite.auth("Doublev", "1234");
    //ForSQlite.updateName("Koleden","1111", "GreitPashka");
    //ForSQlite.readDB();
    ForSQlite.closeDB();
    }
}
