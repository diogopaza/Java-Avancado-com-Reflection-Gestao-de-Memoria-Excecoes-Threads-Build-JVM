package org.generics;

//T e um tipo genérico. É possível subistituir T por qualquer tipo ao instanciar BoxGenerics.
public class BoxGenerics<T> {

    private T object;

    public T getObject() {
        return object;
    }
    public void setObject(T object) {
        this.object = object;
    }

    public static <T> void percorrerArray(T[] array){
        for (T element: array){
            System.out.println("OBJETO == " + element);
        }
    }
}
