package pt.bugalho.day;

import pt.bugalho.Main;

import java.io.File;
import java.util.Objects;

public abstract class BaseDay {
    public static File file;

    public BaseDay(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        file = new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());
    }

    abstract void run();
}
