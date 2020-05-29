public class Employer {
    private String name;
    private int age;

    public Employer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Employer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name: " + this.name +" age: "+this.age;
    }

    private void Private_Print(String name, int age){
        System.out.println("name is: " + name +  " age is : " + age + " （this is private method）");
    }
}
