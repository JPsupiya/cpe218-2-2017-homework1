import java.util.Stack;

public class Homework1 {

    public static Stack s = new Stack();
    static Node to = null;

    public static void main(String[] args) {
        Node n = null;

        int i = -1;
        int result;
        // Begin of arguments input sample
        if (args.length == 0) {
            String input = "251-*32*+";
            int ro = input.length();

            while (++i < ro) {
                n = new Node(input.charAt(i));
                infix(n);
                s.push(n);
                to = n;
            }
            System.out.print(inorder(to));
            System.out.print('=');
            result = calculate(to);
            System.out.println(result);

            TreeIconDemo2.main(to);
        }
    }

    public static int calculate(Node ro) {
        if (ro.l == '+') {
            return calculate(ro.lf) + calculate(ro.rf);
        } else if (ro.l == '-') {
            return calculate(ro.lf) - calculate(ro.rf);
        } else if (ro.l == '*') {
            return calculate(ro.lf) * calculate(ro.rf);
        } else if (ro.l == '/') {
            return calculate(ro.lf) / calculate(ro.rf);
        } return Character.getNumericValue(ro.l);

    }


    public static void infix(Node ro) {
        if(!Character.isDigit(ro.l)){
            ro.rf = (Node) s.pop();
            ro.lf = (Node) s.pop();
        }
    }
    public static String inorder(Node ro)  {
        String text = "";
        if(!Character.isDigit(ro.l)  && ro != to) text += ('(');
        if(ro.lf != null) text += inorder(ro.lf);
        text += (ro.l);
        if(ro.rf != null) text += inorder(ro.rf);
        if(!Character.isDigit(ro.l) && ro != to) text += (')');
        return text;
    }
}