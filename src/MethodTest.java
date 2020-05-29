import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodTest {

    public static double square(double x){
        return x*x;
    }

    public static void printTable(double from, double to, int n, Method f){
        System.out.println(f);

        double dx = (to - from)/(n-1);

        for (double x = from;x<=to;x+=dx){
            try{
                double y = (Double) f.invoke(null,x);
                System.out.printf("%10.4f | 10.4f%n",x,y);

            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws NoSuchMethodException {
//        Method square = MethodTest.class.getMethod("square", double.class);
//        Method sqrt = Math.class.getMethod("sqrt", double.class);
//
//        printTable(1,10,10,square);
//        printTable(1,10,10,sqrt);

        try {
            Class clazz = Class.forName("Employer");
            Constructor[] con = clazz.getConstructors();

//            用指定参数构造新实例
//            具体是con[0]，con[1]打一个断点看一下
            Object e = con[0].newInstance("123",11);

//            直接调用public方法
            Method m = Employer.class.getMethod("toString");
            System.out.println(m.invoke(e));

//            用无参构造器构造新实例
            Object e1 = Employer.class.newInstance();
            Method m1 = Employer.class.getMethod("toString");

//            修改前打印
            System.out.println(m1.invoke(e1));

//            直接调用public方法，修改实例中的变量
            Method m2 = Employer.class.getMethod("setName", String.class);
            Object obj = m2.invoke(e1,"使用反射调用函数");

//            修改后打印
            System.out.println(m1.invoke(e1));

//             调用private方法
            Method m3 = Employer.class.getDeclaredMethod("Private_Print",String.class,int.class);
            m3.setAccessible(true);
            Object obj1 = m3.invoke(e,"privateMethod",111111);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}