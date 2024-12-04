package pt.bugalho.day;

import pt.bugalho.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day1 {
    private static File file;
    private static final List<Integer> leftSide = new ArrayList<>();
    private static final List<Integer> rightSide = new ArrayList<>();

    public static void run() {
        ClassLoader classLoader = Main.class.getClassLoader();
        file = new File(Objects.requireNonNull(classLoader.getResource("day1.input")).getFile());
        part1();
        part2();
    }

    private static void part1() {
        try (Scanner scanner = new Scanner(file)){
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                List<String> rowData = Arrays.asList(data.split(" {3}"));
                leftSide.add(Integer.valueOf(rowData.get(0)));
                rightSide.add(Integer.valueOf(rowData.get(1)));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        leftSide.sort(Integer::compareTo);
        rightSide.sort(Integer::compareTo);

        int sum = 0;
        for(int i = 0; i < leftSide.size(); i++) {
            if(leftSide.get(i) > rightSide.get(i)) {
                sum += leftSide.get(i) - rightSide.get(i);
            } else {
                sum += rightSide.get(i) - leftSide.get(i);
            }
        }

        System.out.println("Total Distance: " + sum);
    }

    private static void part2() {
        int similarity = 0;
        for(Integer number : leftSide) {
            int numberTimesInRightSide = (int) rightSide.stream().filter(right -> Objects.equals(right, number)).count();
            similarity += number * numberTimesInRightSide;
        }

        System.out.println("Similarity score: " + similarity);
    }
}
