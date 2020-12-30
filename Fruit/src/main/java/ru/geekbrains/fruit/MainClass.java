package ru.geekbrains.fruit;

import java.util.ArrayList;
import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {

        // Exercise 1

        //Создаем ссылку и объект типа gen и все упоковываем
        GenericClass<String> catsNames = new GenericClass<String>(new String[]{"Lulu", "Tom"});
        GenericClass<Integer> catsAges = new GenericClass<Integer>(new Integer[]{4, 5});
        GenericClass<Double> catsWieghts = new GenericClass<Double>(new Double[]{5.5, 7.1});

        //Смотрим на тип
        System.out.println("\nLook at the type of the array. We have: ");
        catsNames.showType();
        catsAges.showType();
        catsWieghts.showType();

        //Создаем листы
        System.out.println("\nCreate the array list with old positions of elements");
        catsNames.createArrayList();
        catsAges.createArrayList();
        catsWieghts.createArrayList();

        //Меняем местами
        System.out.println("\nCreate the array with new positions of elements");
        catsNames.changePositionOfElementsInArray();
        catsAges.changePositionOfElementsInArray();
        catsWieghts.changePositionOfElementsInArray();

        // Exercise 2

        //Создаем коробку для яблок и создаем яблоки
        Box<Apple> appleBox = new Box<>();
        Apple a1 = new Apple();
        Apple a2 = new Apple();
        Apple a3 = new Apple();

        // Кидаем яблоки в коробку
        appleBox.addFruit(a1);
        appleBox.addFruit(a2);
        appleBox.addFruit(a3);

        // Вес коробки с яблоками
        System.out.println("\nThe total weight of the apple box is " + appleBox.getTotalWeight());

        //Создаем коробку для апельсинов и создаем апельсины
        Box<Orange> orangeBox = new Box<>();
        Orange o1 = new Orange();
        Orange o2 = new Orange();
        Orange o3 = new Orange();

        // Кидаем апельсины в коробку
        orangeBox.addFruit(o1);
        orangeBox.addFruit(o2);
        orangeBox.addFruit(o3);

        // Вес коробки с апельсинами
        System.out.println("The total weight of the orange box is " + orangeBox.getTotalWeight());

        // Сравниваем коробки
        System.out.println("The result of matching boxes is " + appleBox.compare(orangeBox));

        // Создаем новую пустую коробку и закидываем туда яблоки
        Box<Apple> newAppleBox = new Box<>();
        appleBox.replaceAllFruitsToOtherBox(newAppleBox);

        //Создадим еще одно яблоко и закинем его в новую коробку и потом посмотрим вес
        Apple a4 = new Apple();
        newAppleBox.addFruit(a4);
        System.out.println("The total weight of the new apple box is " + newAppleBox.getTotalWeight());
    }
}
