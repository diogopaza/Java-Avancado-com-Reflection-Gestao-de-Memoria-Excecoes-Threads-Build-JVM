package com.java.reflection;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Transformator {

    public Transformator() {
    }

    public <I, O> O transform(I input) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> source = input.getClass();
        Class<?> target = Class.forName(source + "Dto");

        O targetClass = (O) target.getDeclaredConstructor().newInstance();

        Field[] sourceFields = source.getDeclaredFields();
        Field[] targetFields = target.getDeclaredFields();

        Arrays.stream(sourceFields).forEach(sourceField ->
                Arrays.stream(targetFields).filter(targetField ->
                                targetField.getName().equals(sourceField.getName())
                                        && targetField.getType().equals(sourceField.getType()))
                        .forEach(targetField -> {
                            sourceField.setAccessible(true);
                            targetField.setAccessible(true);
                            try {
                                targetField.set(targetClass, sourceField.get(input));
                            } catch (IllegalAccessException e) {
                                throw new RuntimeException(e);
                            }
                            try {
                                targetField.set(targetClass, sourceField.get(input));
                            } catch (IllegalAccessException e) {
                                throw new RuntimeException(e);
                            }
                        }));

        return targetClass;

    }

}
