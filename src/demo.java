import java.util.Stack;

public class demo {
    public static String decodeString(String s) {
        Stack<Integer> num_stack = new Stack<>();
        Stack<String> str_stack = new Stack<>();

        int multi = 0;

        String res = "";

        for(int i=0;i<s.length();i++){
//            数字
            if (s.charAt(i) >='0' && s.charAt(i)<='9'){
                multi = 10*multi + s.charAt(i)-'0';
            }else if(s.charAt(i) == '['){
                num_stack.push(multi);
                multi = 0;

                str_stack.push(res);
                res = "";

            }else if(s.charAt(i) == ']'){
                int time = num_stack.pop();
                String last_res = str_stack.pop();

                String buff = multiString(res,time);
                res = last_res + buff;

            }else{
                res = res + s.charAt(i);
            }
        }
        return res;

    }

    public static String multiString(String s, int times){
        StringBuffer res = new StringBuffer();
        for (int i=0;i<times;i++){
            res.append(s);
        }
        return res.toString();
    }
    public static void main(String[] args) {
        System.out.println(decodeString("2[abc]3[cd]ef"));
    }
}
