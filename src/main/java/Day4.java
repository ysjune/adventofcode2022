import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day4 {

    public static long fullyContains(String path) {

        long total = 0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String readLine = null;
            List<Long> elfs = new ArrayList<>();
            long sum = 0L;
            while ((readLine = bufferedReader.readLine()) != null) {
                String[] split1 = readLine.split(",");
                String[] first = split1[0].split("-");
                String[] second = split1[1].split("-");

                List<Integer> firstList = new ArrayList<>();
                List<Integer> secondList = new ArrayList<>();
                for (int i = Integer.parseInt(first[0]); i <= Integer.parseInt(first[1]); i++) {
                    firstList.add(i);
                }

                for (int i = Integer.parseInt(second[0]); i <= Integer.parseInt(second[1]); i++) {
                    secondList.add(i);
                }

                if(firstList.containsAll(secondList) || secondList.containsAll(firstList)) {
                    total++;
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return total;
    }

    public static long overlap(String path) {

        long total = 0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String readLine = null;
            List<Long> elfs = new ArrayList<>();
            long sum = 0L;
            while ((readLine = bufferedReader.readLine()) != null) {
                String[] split1 = readLine.split(",");
                String[] first = split1[0].split("-");
                String[] second = split1[1].split("-");

                List<Integer> firstList = new ArrayList<>();
                List<Integer> secondList = new ArrayList<>();
                for (int i = Integer.parseInt(first[0]); i <= Integer.parseInt(first[1]); i++) {
                    firstList.add(i);
                }

                for (int i = Integer.parseInt(second[0]); i <= Integer.parseInt(second[1]); i++) {
                    secondList.add(i);
                }

                List<Integer> longerList = firstList.size() > secondList.size() ? firstList : secondList;
                List<Integer> shorterList = firstList.size() > secondList.size() ? secondList : firstList;
                for (Integer integer : longerList) {
                    if (shorterList.contains(integer)) {
                        total++;
                        break;
                    }
                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return total;
    }


    public static void main(String[] args){

        long total = fullyContains("src/main/resources/day4");
        System.out.println(total);

        long total2 = overlap("src/main/resources/day4");
        System.out.println(total2);

    }
}
