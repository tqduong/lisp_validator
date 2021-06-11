import java.util.Stack;

public class LispCodeValidator {

    public static boolean verifyLISPCode(String code)
    {
        if (code == null || code.length() == 0) return true;
        String value = code.replaceAll("[^()]","");
        Stack stack = new Stack();

        for (char c : value.toCharArray()) {
            if (c == '(') {
                stack.push("(");
            }else if(stack.empty() || stack.peek() != "(") {
                return  false;
            }else{
                stack.pop();
            }
        }

        return stack.empty();
    }
}
