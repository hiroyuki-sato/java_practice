import com.fasterxml.jackson.databind.module.SimpleModule;

public class MySerializerModule
        extends SimpleModule
{
    public MySerializerModule()
    {
        super();
        addSerializer(MyValue.class, new MySerializer());
        addDe
    }
}
