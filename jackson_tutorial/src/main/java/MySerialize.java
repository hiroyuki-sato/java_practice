import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by hsato on 2017/05/04.
 */
public class MySerialize
{
    private ObjectMapper mapper;

    public MySerialize(){

        this.mapper = new ObjectMapper();
        this.mapper.registerModule(new MySerializerModule());

    }

    public void execute(){
        try {
//            MyValue value = mapper.readValue(new File("data.json"), MyValue.class);
            MyValue value = mapper.readValue("{\"name\":\"Bob\", \"age\":13}", MyValue.class);

            System.out.println(mapper.writeValueAsString(value));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
