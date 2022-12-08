import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day8 {

    public static long seeTree(String path) {

        List<List<Integer>> lists = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String readLine = null;
            while ((readLine = bufferedReader.readLine()) != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (int i = 0; i < readLine.length(); i++) {
                    arrayList.add(Integer.parseInt(String.valueOf(readLine.charAt(i))));
                }
                lists.add(arrayList);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        int count = 0;
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                if (i == 0 || i == lists.size() - 1) {
                    System.out.println(i + "," + j + " = " + lists.get(i).get(j));
                    count++;
                    continue;
                }
                if (j == 0 || j == lists.get(i).size() - 1) {
                    System.out.println(i + "," + j + " = " + lists.get(i).get(j));
                    count++;
                    continue;
                }
                Integer integer = lists.get(i).get(j);
                if (find(lists, integer, i, j)) {
                    System.out.println(i + "," + j + " = " + lists.get(i).get(j));
                    count++;
                }
            }
        }

        return count;
    }

    public static boolean find(List<List<Integer>> lists, int integer, int i, int j) {

        boolean up = true;
        boolean down = true;
        boolean right = true;
        boolean left = true;

        for (int k = 0; k < lists.size(); k++) {
            for (int l = 0; l < lists.get(k).size(); l++) {
                if (k == i && j == l) {
                    continue;
                }
                Integer height = lists.get(k).get(l);

                if (k == i && l < j) {
                    if (height >= integer) {
                        up = false;
                    }
                } else if (k == i && l > j) {
                    if (height >= integer) {
                        down = false;
                    }
                } else if (k < i && j == l) {
                    if (height >= integer) {
                        left = false;
                    }
                } else if (k > i && j == l) {
                    if (height >= integer) {
                        right = false;
                    }
                }
            }
        }

        return up || down || right || left;
    }


    public static void main(String[] args) {

        long total = seeTree("src/main/resources/day8");
        System.out.println(total);

    }
}
