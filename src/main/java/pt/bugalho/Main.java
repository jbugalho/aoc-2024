package pt.bugalho;

import pt.bugalho.day.Day1;

public class Main {
    private static Day1 day1;

    public static void main(String[] args) {
        initDays();
        day1.run();
    }

    private static void initDays() {
        day1 = new Day1("day1.input");
    }
}