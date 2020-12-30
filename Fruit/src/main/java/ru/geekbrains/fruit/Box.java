package ru.geekbrains.fruit;

import java.util.ArrayList;
import java.util.List;

public class Box <F extends Fruit>{
    private ArrayList<F> fruits;
    private float totalWeight;

    public Box() {
        fruits = new ArrayList<>();
    }

    // В контруктор передаем ссылку на лист
    public Box(ArrayList<F> fruits) {
        this.fruits = fruits;
    }

    public Box(F fruit) {
        fruits = new ArrayList<>();
        fruits.add(fruit);

    }

    public ArrayList<F> getFruits() {
        return fruits;
    }

    public void setFruits(ArrayList<F> fruits) {
        this.fruits = fruits;
    }

    //The java.util.ArrayList.size() method returns the number of elements in this list i.e the size of the list.
    //ArrayList get(int index) method is used for fetching an element from the list. We need to specify the index while
    //calling get method and it returns the value present at the specified index.
    public float getTotalWeight() {
        if (fruits.size() != 0) {
            int i = 0;
            totalWeight = fruits.size() * fruits.get(i).getWeight();
        } else {
            System.out.println("We don't have fruits in a box. ");
        }
        return totalWeight;
    }

    public boolean compare(Box<?> otherBox) {
        return getTotalWeight() == otherBox.getTotalWeight();
    }
    public void replaceAllFruitsToOtherBox(Box<F> otherBox) {
        otherBox.fruits.addAll(fruits);
        fruits.clear();
    }

    public void addFruit(F fruitToAdd) {
        fruits.add(fruitToAdd);
    }
}
