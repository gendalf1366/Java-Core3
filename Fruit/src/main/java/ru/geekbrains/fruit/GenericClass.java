package ru.geekbrains.fruit;

import java.util.ArrayList;
import java.util.Arrays;

public class GenericClass<T> {
    private T[] obj;

    //Передаем конструктору ссылку на объект типа Т
    public GenericClass(T[] obj) {
        this.obj = obj;
    }

    // Возвращаем объект типа Т
    public T[] getObj() {
        return obj;
    }

    // Получаем информацию о типе объекта (это пишу для себя)
    public void showType() {
        System.out.println(obj.getClass().getName());
    }

    // Массив в лист
    public ArrayList<T> createArrayList() {
        ArrayList<T> arrayList = new ArrayList<T>(Arrays.asList(obj));
        System.out.println(arrayList);
        return arrayList;
    }

    // Меняем элементы местами (проверку выхода за рамки массива не пишу, так как массив только из 2х элементов:)
    public void changePositionOfElementsInArray() {
        T x = obj[0];
        obj[0] = obj[1];
        obj[1] = x;
        System.out.println(Arrays.toString(obj));
    }
}
