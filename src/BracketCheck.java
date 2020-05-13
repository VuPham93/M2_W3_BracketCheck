import java.util.Stack;

public class BracketCheck {

    public static final String LEFT_BRACKET = "(";
    public static final String RIGHT_BRACKET = ")";

    public static boolean checkBracket(String expression) {
        Stack<String> stack = toStack(expression);
        int countLeft = 0;
        int countRight = 0;

        if (stack.size()%2 != 0)
            return false;

        while (!stack.empty()) {
            String temp = stack.peek();
            if (temp.equals("false"))
                return false;
            else if (temp.equals(LEFT_BRACKET)) {
                countLeft++;
            } else
                countRight++;
            stack.pop();
        }

        return countLeft == countRight;
    }

    private static Stack<String> toStack(String input) {
        String[] stringArray = input.split("");
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < stringArray.length; i++) {
            if (stack.size() == 0) {
                if (stringArray[i].equals(LEFT_BRACKET)) {
                    stack.push(stringArray[i]);
                }
                if (stringArray[i].equals(RIGHT_BRACKET)) {
                    stack.push(stringArray[i]);
                    return stack;
                }
            }
            else if (stringArray[i].equals(LEFT_BRACKET) || stringArray[i].equals(RIGHT_BRACKET)) {
                if (stack.peek().equals(LEFT_BRACKET) && stringArray[i].equals(RIGHT_BRACKET)) {
                    stack.pop();
                } else
                    stack.push(stringArray[i]);

                if (stringArray[i - 1].equals(LEFT_BRACKET) && stringArray[i].equals(RIGHT_BRACKET)) {
                    stack.push("false");
                    return stack;
                }
            }
        }
        return stack;
    }
}