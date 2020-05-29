import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.Double;
import java.util.ArrayList;

public class ReflectionTest {


    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String name = in.next();

//        Double d = new Double("111");
//        Class cl = d.getClass();


        String name = "java.lang.Double";
        name = "Employer";

        Class cl = null;
        try {
            cl = Class.forName(name);

            Class supercl  = cl.getSuperclass();
            String modifiers = Modifier.toString(cl.getModifiers());
            if(modifiers.length()>0) System.out.print(modifiers+" ");
            if (supercl != null && supercl != Object.class) System.out.print("extends " + supercl.getName());

            System.out.print("\n{\n");
            printConstructors(cl);
            System.out.println();
            printMethods(cl);
            System.out.println();
            printFields(cl);
            System.out.println("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }




        System.exit(0);
    }

    private static void printConstructors(Class cl) {

        //获得类所有的公有构造器
        Constructor[] constructors = cl.getConstructors();

//        //获得类所有构造器
//        Constructor[] constructors = cl.getConstructors();

        for (Constructor c :constructors){

//            构造函数的名字
            String name = c.getName();
            System.out.print("   ");
//            构造函数前的修饰限定符 public,private...
            String modifier = Modifier.toString(c.getModifiers());
            if(modifier.length()>0) System.out.print(modifier+" ");
            System.out.print(name+"(");

//            构造函数形参的类型
            Class[] paramTypes = c.getParameterTypes();
            for (int j=0;j<paramTypes.length;j++){
                if(j>0) System.out.print(",");
                System.out.print(paramTypes[j].getName());
            }

            System.out.println(");");

        }
    }

    private static void printMethods(Class cl) {

//        所有的公有方法，包括从超类继承的共有方法
        Method[] methods = cl.getMethods();

////        类或接口的全部方法，不包括由超类继承的方法
//        Method[] methods = cl.getDeclaredMethods();

        for (Method m : methods){
//            方法的名字，返回值
            Class retType = m.getReturnType();
            String name = m.getName();
            System.out.print("    ");

//             方法的修饰限定符
            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length()>0) System.out.print(modifiers+" ");
            System.out.print(retType.getName()+" "+name+"(");

//              方法的参数类型
            Class[] paramTypes = m.getParameterTypes();
            for(int j = 0;j<paramTypes.length;j++){
                if (j>0) System.out.print(",");
                System.out.print(paramTypes[j].getName());
            }

            System.out.println(");");
        }
    }

    private static void printFields(Class cl) {
//        当前类的全部域
        Field[] fields = cl.getDeclaredFields();

////        当前类和以及超类的公有域
//        Field[] fields = cl.getFields();

        for (Field f : fields){
//            变量类型
            Class type = f.getType();
//            变量名称
            String name = f.getName();
            System.out.print("   ");
//             变量的修饰限定符
            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length()>0) System.out.print(modifiers + " ");
            System.out.println(type.getName()+" "+name+";");
        }
    }
}
