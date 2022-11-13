import java.io.Serializable;

public class Human implements Serializable {
    String name;
    String sex;
    int age;

    public Human(String name, String sex, int age){
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

  /*  public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }*/

    @Override
    public String toString() {
 return "Name: " + this.name + ", Sex: " + this.sex + ", Age: " + this.age;
    }
}
