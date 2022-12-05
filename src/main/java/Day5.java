import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Day5 {

    public static String rearrangeStack(String path) {

        Stack<Character> stack1 = new Stack<>();
        stack1.add('B');
        stack1.add('S');
        stack1.add('V');
        stack1.add('Z');
        stack1.add('G');
        stack1.add('P');
        stack1.add('W');
        Stack<Character> stack2 = new Stack<>();
        stack2.add('J');
        stack2.add('V');
        stack2.add('B');
        stack2.add('C');
        stack2.add('Z');
        stack2.add('F');
        Stack<Character> stack3 = new Stack<>();
        stack3.add('V');
        stack3.add('L');
        stack3.add('M');
        stack3.add('H');
        stack3.add('N');
        stack3.add('Z');
        stack3.add('D');
        stack3.add('C');
        Stack<Character> stack4 = new Stack<>();
        stack4.add('L');
        stack4.add('D');
        stack4.add('M');
        stack4.add('Z');
        stack4.add('P');
        stack4.add('F');
        stack4.add('J');
        stack4.add('B');
        Stack<Character> stack5 = new Stack<>();
        stack5.add('V');
        stack5.add('F');
        stack5.add('C');
        stack5.add('G');
        stack5.add('J');
        stack5.add('B');
        stack5.add('Q');
        stack5.add('H');
        Stack<Character> stack6 = new Stack<>();
        stack6.add('G');
        stack6.add('F');
        stack6.add('Q');
        stack6.add('T');
        stack6.add('S');
        stack6.add('L');
        stack6.add('B');
        Stack<Character> stack7 = new Stack<>();
        stack7.add('L');
        stack7.add('G');
        stack7.add('C');
        stack7.add('Z');
        stack7.add('V');
        Stack<Character> stack8 = new Stack<>();
        stack8.add('N');
        stack8.add('L');
        stack8.add('G');
        Stack<Character> stack9 = new Stack<>();
        stack9.add('J');
        stack9.add('F');
        stack9.add('H');
        stack9.add('C');

        Stack[] stacks = new Stack[]{stack1, stack2, stack3, stack4, stack5, stack6, stack7, stack8, stack9};

        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String readLine = null;
            while ((readLine = bufferedReader.readLine()) != null) {

                String[] split = readLine.split(" ");
                int move = Integer.parseInt(split[1]);
                int from = Integer.parseInt(split[3]);
                int to = Integer.parseInt(split[5]);

                Stack fromStack = stacks[from - 1];
                Stack toStack = stacks[to - 1];

                for (int i = 0; i < move; i++) {
                    Object pop = fromStack.pop();
                    toStack.add(pop);
                }
            }


            for (int i = 0; i < stacks.length; i++) {
                sb.append(stacks[i].peek());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return sb.toString();
    }

    public static String rearrangeStack2(String path) {

        Stack<Character> stack1 = new Stack<>();
        stack1.add('B');
        stack1.add('S');
        stack1.add('V');
        stack1.add('Z');
        stack1.add('G');
        stack1.add('P');
        stack1.add('W');
        Stack<Character> stack2 = new Stack<>();
        stack2.add('J');
        stack2.add('V');
        stack2.add('B');
        stack2.add('C');
        stack2.add('Z');
        stack2.add('F');
        Stack<Character> stack3 = new Stack<>();
        stack3.add('V');
        stack3.add('L');
        stack3.add('M');
        stack3.add('H');
        stack3.add('N');
        stack3.add('Z');
        stack3.add('D');
        stack3.add('C');
        Stack<Character> stack4 = new Stack<>();
        stack4.add('L');
        stack4.add('D');
        stack4.add('M');
        stack4.add('Z');
        stack4.add('P');
        stack4.add('F');
        stack4.add('J');
        stack4.add('B');
        Stack<Character> stack5 = new Stack<>();
        stack5.add('V');
        stack5.add('F');
        stack5.add('C');
        stack5.add('G');
        stack5.add('J');
        stack5.add('B');
        stack5.add('Q');
        stack5.add('H');
        Stack<Character> stack6 = new Stack<>();
        stack6.add('G');
        stack6.add('F');
        stack6.add('Q');
        stack6.add('T');
        stack6.add('S');
        stack6.add('L');
        stack6.add('B');
        Stack<Character> stack7 = new Stack<>();
        stack7.add('L');
        stack7.add('G');
        stack7.add('C');
        stack7.add('Z');
        stack7.add('V');
        Stack<Character> stack8 = new Stack<>();
        stack8.add('N');
        stack8.add('L');
        stack8.add('G');
        Stack<Character> stack9 = new Stack<>();
        stack9.add('J');
        stack9.add('F');
        stack9.add('H');
        stack9.add('C');

        Stack[] stacks = new Stack[]{stack1, stack2, stack3, stack4, stack5, stack6, stack7, stack8, stack9};

        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String readLine = null;
            while ((readLine = bufferedReader.readLine()) != null) {

                String[] split = readLine.split(" ");
                int move = Integer.parseInt(split[1]);
                int from = Integer.parseInt(split[3]);
                int to = Integer.parseInt(split[5]);

                Stack fromStack = stacks[from - 1];
                Stack toStack = stacks[to - 1];

                if(move == 1) {
                    for (int i = 0; i < move; i++) {
                        Object pop = fromStack.pop();
                        toStack.add(pop);
                    }
                } else {
                    Stack temp = new Stack();
                    for (int i = 0; i < move; i++) {
                        Object pop = fromStack.pop();
                        temp.add(pop);
                    }
                    int size = temp.size();
                    for (int i = 0; i < size; i++) {
                        toStack.add(temp.pop());
                    }
                }
            }
            for (int i = 0; i < stacks.length; i++) {
                sb.append(stacks[i].peek());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        String character = rearrangeStack("src/main/resources/day5");
        System.out.println(character);

        String character2 = rearrangeStack2("src/main/resources/day5");
        System.out.println(character2);

    }
}
