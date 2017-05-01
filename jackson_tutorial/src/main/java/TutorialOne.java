import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Created by hsato on 2017/05/01.
 */

// https://github.com/FasterXML/jackson-databind#1-minute-tutorial-pojos-to-json-and-back
public class TutorialOne
{

    private ObjectMapper mapper = new ObjectMapper();



    public void execTutorial(){
        try {
//            MyValue value = mapper.readValue(new File("data.json"), MyValue.class);
            MyValue value = mapper.readValue("{\"name\":\"Bob\", \"age\":13}", MyValue.class);

            System.out.println(value);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}

