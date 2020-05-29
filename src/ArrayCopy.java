import java.lang.reflect.Array;
import java.util.Arrays;

//数组动态扩容
public class ArrayCopy {
    public static void main(String[] args) {

        Employer e = new Employer("213",12);
        System.out.println(e.getClass().getName());

        Employer[] employers = new Employer[6];
        employers[0] = e;
        employers[1] = e;


        int[] a = new int[]{1,2,3};
        a = (int[]) goodCopyof(a,10);
        System.out.println(Arrays.toString(a));

        String[] s = new String[]{"qwd","qwdqwd","uinvj"};
        s = (String[]) goodCopyof(s,20);
        System.out.println(Arrays.toString(s));

    }

    public static Object goodCopyof(Object a, int newlength){
//        获得原数组的类型  int[], double[],...
        Class cl = a.getClass();
        if(!cl.isArray()) return null;
        Class componentType = cl.getComponentType();

//        获得原数组长度
        int length = Array.getLength(a);

//        返回一个给定类型，给定维度的新数组
        Object newArray = Array.newInstance(componentType,newlength);

//        数组复制
        System.arraycopy(a,0,newArray,0,Math.min(length,newlength));

        return newArray;
    }

}
