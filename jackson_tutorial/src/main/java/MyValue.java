import java.util.Locale;

public class MyValue
{
    public String name;
    public int age;

    @Override
    public String toString(){
        return String.format(Locale.ENGLISH,"name: %s, age: %s",name,age);
    }
}
