import java.io.BufferedReader;
import java.io.FileReader;

public class Day2 {

    public static long totalScore(String path) {

        long total = 0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String readLine = null;
            while ((readLine = bufferedReader.readLine()) != null) {
                String[] split = readLine.split(" ");
                String opponent = split[0];
                String me = split[1];
                if("X".equals(me)) {
                    total += 1;
                } else if("Y".equals(me)) {
                    total += 2;
                } else if("Z".equals(me)) {
                    total += 3;
                }

                total += game(opponent, me);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return total;
    }

    private static long game(final String opponent, final String me) {

        if("A".equals(opponent)) {
            switch (me) {
                case "X":
                    return 3;
                case "Y":
                    return 6;
                case "Z":
                    return 0;
            }
        } else if("B".equals(opponent)) {
            switch (me) {
                case "X":
                    return 0;
                case "Y":
                    return 3;
                case "Z":
                    return 6;
            }
        } else if("C".equals(opponent)) {
            switch (me) {
                case "X":
                    return 6;
                case "Y":
                    return 0;
                case "Z":
                    return 3;
            }
        }
        return 0;
    }

    public static long strategyScore(String path) {

        long total = 0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String readLine = null;
            while ((readLine = bufferedReader.readLine()) != null) {
                String[] split = readLine.split(" ");
                String opponent = split[0];
                String result = split[1];
                if("X".equals(result)) {
                    total += 0;
                } else if("Y".equals(result)) {
                    total += 3;
                } else if("Z".equals(result)) {
                    total += 6;
                }

                total += expectMyColumn(opponent, result);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return total;
    }

    private static long expectMyColumn(final String opponent, final String result) {
        if("X".equals(result)) {
            switch (opponent) {
                case "A":
                    return 3;
                case "B":
                    return 1;
                case "C":
                    return 2;
            }
        } else if("Y".equals(result)) {
            switch (opponent) {
                case "A":
                    return 1;
                case "B":
                    return 2;
                case "C":
                    return 3;
            }
        } else if("Z".equals(result)) {
            switch (opponent) {
                case "A":
                    return 2;
                case "B":
                    return 3;
                case "C":
                    return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args){

        long calories = totalScore("src/main/resources/day2");
        System.out.println(calories);

        long strategyScore = strategyScore("src/main/resources/day2");
        System.out.println(strategyScore);

    }
}
