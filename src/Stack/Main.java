package Stack;

/**
 * Created by zhh on 2019/9/18.
 */
public class Main {
    public static void main(String[] args) {
        ValidParentheses validParentheses=new ValidParentheses();
        String template="}";
        System.out.println(validParentheses.isValid(template));
    }
}
