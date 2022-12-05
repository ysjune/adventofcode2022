import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day1 {

    public static long calories(String path) {

        long total = 0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String readLine = null;
            List<Long> elfs = new ArrayList<>();
            long sum = 0L;
            while ((readLine = bufferedReader.readLine()) != null) {
                if("".equals(readLine)) {
                    elfs.add(sum);
                    sum = 0L;
                    continue;
                }
                sum += Long.parseLong(readLine);
            }

            for (int i = 0; i < elfs.size(); i++) {
                if(total <= elfs.get(i)) {
                    total = elfs.get(i);
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return total;
    }

    public static long top3Calories(String path) {

        long total = 0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String readLine = null;
            List<Long> elfs = new ArrayList<>();
            long sum = 0L;
            while ((readLine = bufferedReader.readLine()) != null) {
                if("".equals(readLine)) {
                    elfs.add(sum);
                    sum = 0L;
                    continue;
                }
                sum += Long.parseLong(readLine);
            }

            List<Long> longs = elfs.stream().sorted(Comparator.reverseOrder()).toList();
            for (int i = 0; i < 3; i++) {
                total += longs.get(i);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return total;
    }



    public static void main(String[] args){

//        long calories = calories("src/main/resources/day1");
//        System.out.println(calories);

        long total = top3Calories("src/main/resources/day1");
        System.out.println(total);

    }
}
