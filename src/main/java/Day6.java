import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Day6 {

    public static long tuningTrouble(String path) {

        long total = 0;
        Queue<Character> queue = new LinkedList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String readLine = null;
            while ((readLine = bufferedReader.readLine()) != null) {
                int k = 0;
                while (k < readLine.length()) {
                    for (int i = k; i < readLine.length(); i++) {
                        char c = readLine.charAt(i);
                        if (!queue.contains(c)) {
                            queue.add(c);
                        } else {
                            queue.clear();
                            break;
                        }
                        if (queue.size() == 4) {
                            total = i;
                            break;
                        }
                    }
                    if (queue.size() == 4) {
                        break;
                    }
                    k++;
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return total + 1;
    }

    public static long distinctCharacters(String path) {

        long total = 0;
        Queue<Character> queue = new LinkedList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String readLine = null;
            while ((readLine = bufferedReader.readLine()) != null) {
                int k = 0;
                while (k < readLine.length()) {
                    for (int i = k; i < readLine.length(); i++) {
                        char c = readLine.charAt(i);
                        if (!queue.contains(c)) {
                            queue.add(c);
                        } else {
                            queue.clear();
                            break;
                        }
                        if (queue.size() == 14) {
                            total = i;
                            break;
                        }
                    }
                    if (queue.size() == 14) {
                        break;
                    }
                    k++;
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return total + 1;
    }


    public static void main(String[] args) {

//        long total = tuningTrouble("src/main/resources/day6");
//        System.out.println(total);

        long total = distinctCharacters("src/main/resources/day6");
        System.out.println(total);

    }
}
