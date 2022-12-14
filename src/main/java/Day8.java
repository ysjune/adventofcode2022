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

    public static long highestScenicScore(String path) {

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

        long score = 0;
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                Integer integer = lists.get(i).get(j);
                score = Math.max(score, findScore(lists, integer, i, j));
            }
        }

        return score;
    }

    public static long findScore(List<List<Integer>> lists, int integer, int i, int j) {

        int height = lists.size(); // i
        int width = lists.get(0).size(); // j

        long upCount = 0;
        long downCount = 0;
        long rightCount = 0;
        long leftCount = 0;

        for (int k = i+1; k < height; k++) {
            upCount++;
            Integer temp = lists.get(k).get(j);
            if(temp >= integer) {
                break;
            }
        }

        for (int k = i-1; k >= 0; k--) {
            downCount++;
            Integer temp = lists.get(k).get(j);
            if(temp >= integer) {
                break;
            }
        }

        for (int k = j+1; k < width; k++) {
            rightCount++;
            Integer temp = lists.get(i).get(k);
            if(temp >= integer) {
                break;
            }
        }

        for (int k = j-1; k >= 0; k--) {
            leftCount++;
            Integer temp = lists.get(i).get(k);
            if(temp >= integer) {
                break;
            }
        }

        return upCount * downCount * rightCount * leftCount;
    }

    public static void main(String[] args) {

//        long total = seeTree("src/main/resources/day8");
//        System.out.println(total);

        long score = highestScenicScore("src/main/resources/day8");
        System.out.println(score);

    }
}
