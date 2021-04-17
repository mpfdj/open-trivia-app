package api.trivia.open.snippets;

import api.trivia.open.util.Util;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONException;
import org.jsonbuilder.JsonBuilder;
import org.jsonbuilder.implementations.gson.GsonAdapter;
import org.junit.jupiter.api.Test;

public class JsonTest {

    @Test
    public void testJson() throws JSONException, JsonProcessingException {
//        https://github.com/HknL/JsonBuilder/wiki/JsonBuilder-WIKI#extended-examples
        String json = new JsonBuilder(new GsonAdapter())
                .object("query_string")
                .object("query", "3")
                .object("fields")
                .array(new String[]{"_id"})
                .up().up()
                .object("test", "xxx")
                .build().toString();

        System.out.println(Util.toPrettyFormat(json));

    }


    @Test
    public void testJson2() {

    /*
    {
      "size":0,
      "aggregations":{
        "category":{
          "terms":{
            "field":"category"
          }
        }
      }
    }
    */

        String json = new JsonBuilder(new GsonAdapter())
                .object("size", 0)
                .object("aggregations")
                .object("category")
                .object("terms")
                .object("field", "category")
                .build().toString();

        System.out.println(Util.toPrettyFormat(json));

    }


}