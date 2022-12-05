import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Day3 {

    public static long alphabetSum(String path) {

        int total = 0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String readLine = null;
            while ((readLine = bufferedReader.readLine()) != null) {
                int length = readLine.length();
                String pre = readLine.substring(0, length / 2);
                String post = readLine.substring(length/2, length);

                for (int i = 0; i < pre.length(); i++) {
                    char c = pre.charAt(i);
                    if(post.contains(String.valueOf(c))) {
                        total += Character.isLowerCase(c) ? c - 96 : c - 38;
                        break;
                    }
                }
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return total;

    }

    public static long threeGroupSum(String path) {

        int total = 0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String readLine1 = null;
            while ((readLine1 = bufferedReader.readLine()) != null) {
                String readLine2 = bufferedReader.readLine();
                String readLine3 = bufferedReader.readLine();

                for (int i = 0; i < readLine1.length(); i++) {
                    char c = readLine1.charAt(i);
                    if(readLine2.contains(String.valueOf(c)) && readLine3.contains(String.valueOf(c))) {
                        total += Character.isLowerCase(c) ? c - 96 : c - 38;
                        break;
                    }
                }
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return total;

    }


    public static void main(String[] args) {
//        long total = alphabetSum("src/main/resources/day3");
//        System.out.println(total);
        long total = threeGroupSum("src/main/resources/day3");
        System.out.println(total);
    }

}
